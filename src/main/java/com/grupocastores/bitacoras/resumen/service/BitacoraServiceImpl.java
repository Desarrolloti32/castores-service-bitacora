package com.grupocastores.bitacoras.resumen.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupocastores.bitacoras.resumen.repository.BitacoraRepository;
import com.grupocastores.bitacoras.resumen.repository.UtilitiesRepository;
import com.grupocastores.bitacoras.resumen.service.client.IViajesDocumentacionClientRest;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesDetail;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesNegociacion;
import com.grupocastores.commons.inhouse.BitacoraViajesRequest;
import com.grupocastores.commons.inhouse.Esquemasdocumentacion;
import com.grupocastores.commons.inhouse.EstatusunidadBitacoraResumen;
import com.grupocastores.commons.inhouse.GuiaViajeCustom;
import com.grupocastores.commons.inhouse.Ruta;
import com.grupocastores.commons.inhouse.TalonCustomResponse;
import com.grupocastores.commons.oficinas.Servidores;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    
    @Autowired
    private BitacoraRepository bitacoraRepository;
    
    @Autowired
    private IViajesDocumentacionClientRest viajesDocumentacionFeign;
    
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
        EstatusunidadBitacoraResumen estatusUnidad= bitacoraRepository.getEstatusUnidad(idUnidad);
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

    @SuppressWarnings("unchecked")
    @Override
    public  List<TalonCustomResponse> getTalonesByViaje(String idoficinaDocumenta, int idViaje) {
        ResponseEntity<List<GuiaViajeCustom>> resEntityGuiasViaje =  viajesDocumentacionFeign.getGuiasViaje(idViaje, idoficinaDocumenta);
       
        List<TalonCustomResponse> listTalones = new ArrayList<TalonCustomResponse>();
        if(resEntityGuiasViaje.getStatusCode()==HttpStatus.OK) {
            List<GuiaViajeCustom> listGuiaViaje =resEntityGuiasViaje.getBody();
            int listGuiaViajeSize = listGuiaViaje.size();
            for(int i=0; i< listGuiaViajeSize; i++  ) {
                ResponseEntity<List<TalonCustomResponse>> resEntityTalonesGuia =  viajesDocumentacionFeign.getTalonesGuia(listGuiaViaje.get(i).getNoGuia(), idoficinaDocumenta);
                if(resEntityTalonesGuia.getStatusCode()==HttpStatus.OK) {
                    listTalones = resEntityTalonesGuia.getBody();
                }
            }
        }
        return listTalones;
    }

    
    
}
