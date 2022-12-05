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
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupocastores.bitacoras.resumen.repository.BitacoraRepository;
import com.grupocastores.bitacoras.resumen.repository.UtilitiesRepository;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesDetail;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesNegociacion;
import com.grupocastores.commons.inhouse.BitacoraViajesRequest;
import com.grupocastores.commons.inhouse.Esquemasdocumentacion;
import com.grupocastores.commons.inhouse.EstatusunidadBitacoraResumen;
import com.grupocastores.commons.inhouse.Ruta;
import com.grupocastores.commons.oficinas.Servidores;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    
    @Autowired
    private BitacoraRepository bitacoraRepository;
    
    @Autowired
    private UtilitiesRepository utilitiesRepository;
    
    
    public static final String DBPRUEBA = "TIJUANAPRUEBA";


    @Override
    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, String idViaje, String noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse, String idOficinaCliente, String idoficinaDocumenta) {
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        List<BitacoraResumenViajesCustom> response = bitacoraRepository.filterViajes(fechaInicio, fechaFin, idViaje, noEconomico, tipoUnidad, estatusViaje, idEsquema, idNegociacion, idClienteinhouse, idOficinaCliente, DBPRUEBA);
        
        return response;
    }


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

    
    
}
