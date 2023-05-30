package com.grupocastores.bitacoras.resumen.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import com.grupocastores.bitacoras.resumen.DTO.OperadoresSecundariosRequest;
import com.grupocastores.bitacoras.resumen.DTO.TalonCustomResponse;
import com.grupocastores.bitacoras.resumen.DTO.UnidadOperadorRequest;
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
        List<BitacoraResumenViajesCustom> response = new ArrayList<>();

        LocalDate inicio = LocalDate.parse(fechaInicio).withDayOfMonth(1);
        LocalDate fin = LocalDate.parse(fechaFin).withDayOfMonth(1);
        
        long numOfMonthsBetween = ChronoUnit.MONTHS.between(inicio, fin) + 1; 
        List<LocalDate> fechas = IntStream.iterate(0, i -> i + 1)
          .limit(numOfMonthsBetween)
          .mapToObj(i -> inicio.plusMonths(i))
          .collect(Collectors.toList()); 

        fechas.stream().forEach(f -> {
        	String tabla = "" + f.getMonthValue() + f.getYear();
        	response.addAll(bitacoraRepository.filterViajes(fechaInicio, fechaFin, idViaje, noEconomico, tipoUnidad, estatusViaje, idEsquema, idNegociacion, idClienteinhouse, idOficinaCliente, tabla, DBPRUEBA));
        });
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
        
        BitacoraResumenViajesDetail listDetailResumenViaje = new BitacoraResumenViajesDetail();
        try {
            
            Esquemasdocumentacion esquema = bitacoraRepository.getEsquema(idEsquemaViaje);
            Ruta ruta = bitacoraRepository.getRuta(idRuta);
            EstatusUnidadBitacoraResumen estatusUnidad= bitacoraRepository.getEstatusUnidad(idUnidad);
            
            if( esquema != null && ruta != null && estatusUnidad != null) {
                listDetailResumenViaje.setDescripcionEsquema(esquema.getNombreEsquema());
                listDetailResumenViaje.setDescripcionRuta(ruta.getNombre());
                listDetailResumenViaje.setEstatusUnidad(estatusUnidad.getNombreEstatus());
            }
                    
            return listDetailResumenViaje;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return listDetailResumenViaje;
        }
        
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
        
        List<TalonCustomResponse> listTalones = new ArrayList<TalonCustomResponse>();
        try {
            ResponseEntity<List<GuiaViajeCustom>> resEntityGuiasViaje =  viajesDocumentacionFeign.getGuiasViaje(idViaje, idoficinaDocumenta);
            
            if(resEntityGuiasViaje.getStatusCode()==HttpStatus.OK) {
                List<GuiaViajeCustom> listGuiaViaje =resEntityGuiasViaje.getBody();
                for(GuiaViajeCustom guiaViaje : listGuiaViaje) {
                    ResponseEntity<List<TalonCustomResponse>> resEntityTalonesGuia =  viajesDocumentacionFeign.getTalonesTrGuia(guiaViaje.getNoGuia(), idoficinaDocumenta);
                    if(resEntityTalonesGuia.getStatusCode()==HttpStatus.OK) {
                        return resEntityTalonesGuia.getBody();
                    }
                }
            }
            return listTalones; 
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return listTalones; 
        }
      
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
        try {
            
            Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
            ResponseEntity<TablaTalonesOficina> responseTalon =  viajesDocumentacionFeign.getTablaTalon(claTalon, idoficinaDocumenta);
            if(responseTalon.getStatusCode() == HttpStatus.OK) {
                TablaTalonesOficina especificacion = responseTalon.getBody();
                return bitacoraRepository.getTalonDetail(especificacion.getTabla(), claTalon, server.getServidorVinculado() );
            }
            return null;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return null;
        }
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
        BitacoraResumenGuiaDetail guiaDetail = new BitacoraResumenGuiaDetail ();
        try {
            ResponseEntity<GuMesAnio> responseGuia =  viajesDocumentacionFeign.getGuMesAnio(noGuia,tabla, idoficinaDocumenta);
            if(responseGuia.getStatusCode() == HttpStatus.OK) {
                GuMesAnio guia = responseGuia.getBody();
                Moneda moneda =bitacoraRepository.getMoneda(guia.getMoneda());
                Personal operador = utilitiesRepository.getPersonal(guia.getIdOperador());
                ResponseEntity<CiudadesEstadoRequest> responseOrigen =  inhouseFeign.findCiudadAndEstado(guia.getOrigen());
                ResponseEntity<CiudadesEstadoRequest> responseDestino =  inhouseFeign.findCiudadAndEstado(guia.getDestino());
                if(guia != null && operador !=null && responseOrigen.getStatusCode() == HttpStatus.OK && responseDestino.getStatusCode() == HttpStatus.OK) {
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
                }
            }
            return guiaDetail;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return guiaDetail;
        }
        
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
        List<BitacoraViajesRequestDetail> listDetailViaje  = new ArrayList<BitacoraViajesRequestDetail>();
        
        try {
            List<TalonCustomResponse> list = getTalonesByViaje(idoficinaDocumenta, idViaje);
           
            
            for (TalonCustomResponse talon : list) {
                int idViajeParent = bitacoraRepository.getParentRuta(talon.getClaTalon());
                if(idViajeParent != 0 ) {
                    ResponseEntity<List<BitacoraViajesRequestDetail>> viajeDetail = inhouseFeign.findBitacoraViajeDetail(idViajeParent);
                    if(viajeDetail.getStatusCode() == HttpStatus.OK) {
                        listDetailViaje = viajeDetail.getBody();
                    }
                }
            }
                
            return listDetailViaje;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return listDetailViaje;
        }
        
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
        List<BitacoraViajesDetalleVales> listDetalleVales  = new ArrayList<BitacoraViajesDetalleVales>();
        
        try {
            
            List<Object[]>  tablaVales = bitacoraRepository.getTablaVales(folioViaje);
         
            tablaVales.forEach(item -> {
                String idVale = (String)item[0];
                String tabla = (String)item[1];
                BitacoraViajesDetalleVales detalle = bitacoraRepository.getVales(idVale, tabla);
                if(detalle != null) {
                    listDetalleVales.add(detalle);
                }
            });
            
            return listDetalleVales;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return listDetalleVales;
        }

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
    @SuppressWarnings("unchecked")
    @Override
    public  ArrayList<IncidenciasDTO>  obtenerIncidencias(String claTalon, int tipo) {
        
      
        try {
            Parametro parametro = utilitiesRepository.getParametroByClave("0017");
            if( parametro == null ) {
                return null;
            }
            RestTemplate restTemplate = new RestTemplate();
            String urlIncidencia = parametro.getValor()+"/"+claTalon+"/"+tipo;  
            ArrayList<IncidenciasDTO> response = restTemplate.getForObject(urlIncidencia, ArrayList.class);
            
            return  response;    
          
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return  new ArrayList<IncidenciasDTO>();
        }
             
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public List<AsistenciaOperadorDTO> filterAsistencias(String fechaInicio, String fechaFinal) {
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

    /**
     * getUnidadesCliente: Obtiene las unidades de un cliente inhouse
     * 
     * @param idClienteInhouse (int)
     * @return List<UnidadOperadorRequest>
     * @author Cynthia Fuentes Amaro
     * @date 2022-10-28
     */
    @Override
    public List<UnidadOperadorRequest> getUnidadesCliente(int idClienteInhouse, int idTipoUnidad) {
        
        List<Object []> lista = bitacoraRepository.getUnidadesCliente(idClienteInhouse, idTipoUnidad, utilitiesRepository.getDb23());
        List<UnidadOperadorRequest> unidades = new ArrayList<>();
        
        if(lista != null ) {
            lista.stream().forEach(i -> {
                unidades.add(new UnidadOperadorRequest((int)i[0], (int)i[1], (int)i[2], (String)i[3], (String)i[4], (String)i[5], (String)i[6], 
                    (int)i[7], (String)i[8], (String)i[9], i[18] != null ? ((Time)i[18]).toLocalTime() : null, i[19] != null ? ((Time)i[19]).toLocalTime() : null, // Operador 1
                    0, "", "", null, null, // Operador 2
                    (int)i[10], (String)i[11], i[12] != null ? ((String)i[12]).replaceAll("\r\n", "") : null, 
                    i[13] != null ? ((String)i[13]).replaceAll("\r\n", "") : null, (String)i[14], (int)i[15], (String)i[16], (String)i[17], 
                    i[20] != null ? (int)i[20] : 0, i[21] != null ? (String)i[21] : null));
            });
            
             unidades.stream().filter(x -> x.getComplementoCliente() != null && x.getComplementoCliente().contains(x.getAliasInhouse())).collect(Collectors.toList());
        }
        
        return unidades;
        
    }
    
    /**
     * getOperadoresAsignados: Obtiene los operadores asignados a una unidad
     * 
     * @param idUnidad (int)
     * @return List<OperadoresSecundariosRequest>
     * @author Cynthia Fuentes Amaro
     * @date 2022-11-02
     */
    @Override
    public List<OperadoresSecundariosRequest> getOperadoresAsignados(int idUnidad) {
        
        List<Object []> lista = bitacoraRepository.getOperadoresAsignados(idUnidad);
        List<OperadoresSecundariosRequest> operadores = new ArrayList<>();
        
        if(lista != null ) {
            lista.stream().forEach(i -> {
                String idUsuarioMod = (String) utilitiesRepository.findPersonal("idusuario", "idpersonal", String.valueOf((Integer)i[11]));
                
                operadores.add(new OperadoresSecundariosRequest((int)i[12], (int)i[0], (int)i[1], (int)i[2], (String)i[13], (int)i[3], (String)i[4], (int)i[5], (int)i[6], 
                    ((Time)i[7]).toLocalTime(), ((Time)i[8]).toLocalTime(), (short)1, ((Date)i[9]).toLocalDate(), ((Time)i[10]).toLocalTime(), idUsuarioMod));
            });
        }
        
        return operadores;
        
    }
    
}
