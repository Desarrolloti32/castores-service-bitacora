package com.grupocastores.bitacoras.resumen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.grupocastores.bitacoras.resumen.DTO.AsistenciaOperadorDTO;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenGuiaDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenTalonDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenViajesCustom;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenViajesDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraViajesDetalleVales;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraViajesRequestDetail;
import com.grupocastores.bitacoras.resumen.DTO.CiudadesEstadoRequest;
import com.grupocastores.bitacoras.resumen.DTO.EstatusUnidadBitacoraResumen;
import com.grupocastores.bitacoras.resumen.DTO.GuiaViajeCustom;
import com.grupocastores.bitacoras.resumen.DTO.HorarioOperador;
import com.grupocastores.bitacoras.resumen.DTO.IncidenciasDTO;
import com.grupocastores.bitacoras.resumen.DTO.Moneda;
import com.grupocastores.bitacoras.resumen.DTO.TalonCustomResponse;
import com.grupocastores.bitacoras.resumen.repository.BitacoraRepository;
import com.grupocastores.bitacoras.resumen.repository.UtilitiesRepository;
import com.grupocastores.bitacoras.resumen.service.client.IInhouseClientRest;
import com.grupocastores.bitacoras.resumen.service.client.IViajesDocumentacionClientRest;
import com.grupocastores.bitacoras.resumen.service.domain.BitacoraResumenViajesNegociacion;
import com.grupocastores.bitacoras.resumen.service.domain.Esquemasdocumentacion;
import com.grupocastores.bitacoras.resumen.service.domain.GuMesAnio;
import com.grupocastores.bitacoras.resumen.service.domain.Parametro;
import com.grupocastores.bitacoras.resumen.service.domain.Personal;
import com.grupocastores.bitacoras.resumen.service.domain.Ruta;
import com.grupocastores.bitacoras.resumen.service.domain.Servidores;
import com.grupocastores.bitacoras.resumen.service.domain.TablaTalonesOficina;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    
    
    Logger logger = LoggerFactory.getLogger(BitacoraServiceImpl.class);
    
    @Autowired
    private BitacoraRepository bitacoraRepository;
    
    @Autowired
    private IViajesDocumentacionClientRest viajesDocumentacionFeign;
    
    @Autowired
    private IInhouseClientRest inhouseFeign;
    
    @Autowired
    private UtilitiesRepository utilitiesRepository;
    
    
    public static final String DBPRUEBA = "TIJUANAPRUEBA";

    
    /**
     * filterViajes: Servicio para filtrar viajes.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return List<BitacoraResumenViajesCustom>
     * @date 2022-12-06
     */
    @Override
    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, String idViaje, String noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse, String idOficinaCliente, String idoficinaDocumenta) {
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        List<BitacoraResumenViajesCustom> response = bitacoraRepository.filterViajes(fechaInicio, fechaFin, idViaje, noEconomico, tipoUnidad, estatusViaje, idEsquema, idNegociacion, idClienteinhouse, idOficinaCliente, DBPRUEBA);
        
        return response;
    }
    
    /**
     * getDetalleViaje: Servicio para obtener el detalle del resumen de viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenViajesDetail
     * @date 2022-12-06
     */
    @Override
    public BitacoraResumenViajesDetail getDetalleViaje(int idNegociacion, int idEsquemaViaje, int idRuta,
            int idCliente, String idOficinaCliente, String idoficinaDocumenta, int idUnidad, int noEconomico) {
        
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        
        BitacoraResumenViajesNegociacion negociacion = bitacoraRepository.getNegocioacion(idNegociacion);
        Esquemasdocumentacion esquema = bitacoraRepository.getEsquema(idEsquemaViaje);
        Ruta ruta = bitacoraRepository.getRuta(idRuta);
        EstatusUnidadBitacoraResumen estatusUnidad= bitacoraRepository.getEstatusUnidad(idUnidad);
        BitacoraResumenViajesDetail listDetailResumenViaje = new BitacoraResumenViajesDetail();
        
        if(negociacion != null && esquema != null && ruta != null && estatusUnidad != null) {
            listDetailResumenViaje.setDescripcionNegociacion(negociacion.getDescripcionNegociacion());
            listDetailResumenViaje.setDescripcionEsquema(esquema.getNombreEsquema());
            listDetailResumenViaje.setDescripcionRuta(ruta.getNombre());
            listDetailResumenViaje.setEstatusUnidad(estatusUnidad.getNombreEstatus());
            listDetailResumenViaje.setEstatusLiberacion("test");
            listDetailResumenViaje.setGastoCasetas(10041.4323);
        }
                
        return listDetailResumenViaje;
    }
    
    /**
     * getDetalleViaje: Servicio para obtener talones por viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return List<TalonCustomResponse>
     * @date 2022-12-06
     */
    @SuppressWarnings("unchecked")
    @Override
    public  List<TalonCustomResponse> getTalonesByViaje(String idoficinaDocumenta, int idViaje) {
        ResponseEntity<List<GuiaViajeCustom>> resEntityGuiasViaje =  viajesDocumentacionFeign.getGuiasViaje(idViaje, idoficinaDocumenta);
       
        List<TalonCustomResponse> listTalones = new ArrayList<TalonCustomResponse>();
        if(resEntityGuiasViaje.getStatusCode()==HttpStatus.OK) {
            List<GuiaViajeCustom> listGuiaViaje =resEntityGuiasViaje.getBody();
            int listGuiaViajeSize = listGuiaViaje.size();
            for(int i=0; i< listGuiaViajeSize; i++  ) {
                ResponseEntity<List<TalonCustomResponse>> resEntityTalonesGuia =  viajesDocumentacionFeign.getTalonesTrGuia(listGuiaViaje.get(i).getNoGuia(), idoficinaDocumenta);
                if(resEntityTalonesGuia.getStatusCode()==HttpStatus.OK) {
                    listTalones = resEntityTalonesGuia.getBody();
                }
            }
        }
        return listTalones;
    }
    
    /**
     * detTalonDetail: Servicio para obtener el detalle del resumen de talones.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return List<TalonCustomResponse>
     * @date 2022-12-13
     */
    @SuppressWarnings("null")
    @Override
    public List<BitacoraResumenTalonDetail> getTalonDetail(String claTalon, String idoficinaDocumenta) {
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        ResponseEntity<TablaTalonesOficina> responseTalon =  viajesDocumentacionFeign.getTablaTalon(claTalon, idoficinaDocumenta);
        if(responseTalon.getStatusCode() == HttpStatus.OK) {
            TablaTalonesOficina especificacion = responseTalon.getBody();
            List<BitacoraResumenTalonDetail> response = bitacoraRepository.getTalonDetail(especificacion.getTabla(), claTalon, DBPRUEBA );
            
            return response;
        }
        return null;
    }
    
    /**
     * getDetalleGuia: Servicio para obtener el detalle de guia.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail
     * @date 2022-12-13
     */
    @Override
    public BitacoraResumenGuiaDetail getDetalleGuia(String noGuia, String tabla, String idoficinaDocumenta) throws Exception {
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        ResponseEntity<GuMesAnio> responseGuia =  viajesDocumentacionFeign.getGuMesAnio(noGuia,tabla, idoficinaDocumenta);
        BitacoraResumenGuiaDetail guiaDetail = new BitacoraResumenGuiaDetail ();
        if(responseGuia.getStatusCode() == HttpStatus.OK) {
            GuMesAnio guia = responseGuia.getBody();
            Moneda moneda =bitacoraRepository.getMoneda(guia.getMoneda());
            Personal operador = utilitiesRepository.getPersonal(guia.getIdOperador());
            ResponseEntity<CiudadesEstadoRequest> responseOrigen =  inhouseFeign.findCiudadAndEstado(guia.getOrigen());
            ResponseEntity<CiudadesEstadoRequest> responseDestino =  inhouseFeign.findCiudadAndEstado(guia.getDestino());
            if(guia != null && operador!=null && responseGuia.getStatusCode() == HttpStatus.OK && responseDestino.getStatusCode() == HttpStatus.OK) {
                CiudadesEstadoRequest origen = responseOrigen.getBody();
                CiudadesEstadoRequest destino = responseDestino.getBody();
                guiaDetail.setNoGuia(noGuia);
                guiaDetail.setUnidad(guia.getUnidad());
                guiaDetail.setPlacas(guia.getPlacas());
                guiaDetail.setOperador(operador.getNombre() + operador.getApematerno() + operador.getApematerno());
                guiaDetail.setRemolque(guia.getRemolque());
                guiaDetail.setOrigen(origen.getCiudad());
                guiaDetail.setDestino(destino.getCiudad());
                guiaDetail.setMoneda(moneda.getNombre());
                return guiaDetail;
            }
        }
        return guiaDetail;
    }
    
    /**
     * getDetalleRuta: Servicio para obtener el detalle de ruta.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail>
     * @date 2022-12-18
     */
    @Override
    public List<BitacoraViajesRequestDetail> getDetalleRuta(int idViaje, String idOficinaCliente, String idoficinaDocumenta) {
        List<TalonCustomResponse> list = getTalonesByViaje(idoficinaDocumenta, idViaje);
        
        int listSize = list.size();
        List<BitacoraViajesRequestDetail> listDetailViaje  = new ArrayList<BitacoraViajesRequestDetail>();
        for (int i = 0; i < listSize; i++) {
            
            int idViajeParent = bitacoraRepository.getParentRuta(list.get(i).getClaTalon());
            if(idViajeParent != 0 ) {
                ResponseEntity<List<BitacoraViajesRequestDetail>> viajeDetail = inhouseFeign.findBitacoraViajeDetail(idViajeParent);
                
                if(viajeDetail.getStatusCode() == HttpStatus.OK) {
                    listDetailViaje = viajeDetail.getBody();
                    if(!listDetailViaje.isEmpty()) {
                        i = listSize;                   
                    }
                }
            }
        }
            
        return listDetailViaje;
    }
    
    
    /**
     * getVales: Servicio para obtener los vales por folio de viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail
     * @date 2022-12-19
     */
    @Override
    public List<BitacoraViajesDetalleVales> getVales(String folioViaje) {
        List<Object[]>  tablaVales = bitacoraRepository.getTablaVales(folioViaje);
        int tablaValesSize = tablaVales.size();
        List<BitacoraViajesDetalleVales> listDetalleVales  = new ArrayList<BitacoraViajesDetalleVales>();
        if(!tablaVales.isEmpty()) {  
            tablaVales.forEach(item -> {
                String idVale = (String)item[0];
                String tabla = (String)item[1];
                BitacoraViajesDetalleVales detalle = bitacoraRepository.getVales(idVale, tabla);
                if(detalle != null) {
                    listDetalleVales.add(detalle);
                }
            });
        }
        return listDetalleVales;

    }   
    
    
    
    /**
     * obtenerIncidencias: Consulta incidencias(tipo 1) o evidencias(tipo 2).
     * 
     * @param claTalon String
     * @param tipo int
   
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra] 
     * @return InsidenciasDTO
     * @date 2023-14-03
     */
    @Override
    public IncidenciasDTO  obtenerIncidencias(String claTalon, int tipo) {

        try {
            Parametro parametro = utilitiesRepository.getParametroByClave("0017");
            if( parametro == null ) {
                return null;
            }
            RestTemplate restTemplate = new RestTemplate();
            String urlIncidencia = parametro.getValor()+"/"+claTalon+"/"+tipo;  
            IncidenciasDTO response = restTemplate.getForObject(urlIncidencia, IncidenciasDTO.class);
            
            return  response;    
          
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
             
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public List<AsistenciaOperadorDTO> filterAsistencias(String fechaInicio, String fechaFinal) {
//      OficinaViewDTO server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        List<AsistenciaOperadorDTO> list = bitacoraRepository.filterAsistencias(fechaInicio, fechaFinal);
        return list;
    }

    @Override
    public List<AsistenciaOperadorDTO> filterAsistencias(String fechaInicio, String fechaFinal, int idOperador) {
        List<AsistenciaOperadorDTO> list = bitacoraRepository.filterAsistencias(fechaInicio, fechaFinal, idOperador);
        return list;
    }

    @Override
    public List<HorarioOperador> filterHorario(int idunidad, int tipoOperador, int idOperador) {
        List<HorarioOperador> list = bitacoraRepository.filterHorario(idunidad, tipoOperador, idOperador);
        return list;
    }
    
}
