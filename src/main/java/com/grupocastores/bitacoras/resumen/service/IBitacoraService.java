package com.grupocastores.bitacoras.resumen.service;

import java.util.List;

import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesDetail;


//import castores.dao.talones.GuiaviajeDao;

public interface IBitacoraService {

    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, String idViaje, String noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse,String idOficinaCliente, String idoficinaDocumenta);

    public BitacoraResumenViajesDetail getDetalleViaje(int idNegociacion, int idEsquemaViaje, int idRuta,
            int idCliente, String idOficinaCliente, 

            
            
            
            String idoficinaDocumenta, int idUnidad, int noEconomico);
    }
