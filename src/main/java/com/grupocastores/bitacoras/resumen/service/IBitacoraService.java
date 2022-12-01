package com.grupocastores.bitacoras.resumen.service;

import java.util.List;

import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;


//import castores.dao.talones.GuiaviajeDao;

public interface IBitacoraService {

    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, int idViaje, int noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse,String idOficinaCliente, String idoficinaDocumenta);}
