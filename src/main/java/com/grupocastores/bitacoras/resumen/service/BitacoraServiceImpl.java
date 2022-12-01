package com.grupocastores.bitacoras.resumen.service;

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
import com.grupocastores.commons.oficinas.Servidores;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    
    @Autowired
    private BitacoraRepository bitacoraRepository;
    
    @Autowired
    private UtilitiesRepository utilitiesRepository;
    
    
    public static final String DBPRUEBA = "TIJUANAPRUEBA";


    @Override
    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, int idViaje, int noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse, String idOficinaCliente, String idoficinaDocumenta) {
        Servidores server = utilitiesRepository.getLinkedServerByOfice(idoficinaDocumenta);
        List<BitacoraResumenViajesCustom> response = bitacoraRepository.filterViajes(fechaInicio, fechaFin, idViaje, noEconomico, tipoUnidad, estatusViaje, idEsquema, idNegociacion, idClienteinhouse, idOficinaCliente, DBPRUEBA);
        
        return response;
    }

   

   
    
   
    
    
}
