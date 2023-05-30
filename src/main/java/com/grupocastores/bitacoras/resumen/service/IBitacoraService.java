package com.grupocastores.bitacoras.resumen.service;

import java.util.ArrayList;
import java.util.List;

import com.grupocastores.bitacoras.resumen.DTO.AsistenciaOperadorDTO;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenGuiaDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenTalonDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenViajesCustom;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraResumenViajesDetail;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraViajesDetalleVales;
import com.grupocastores.bitacoras.resumen.DTO.BitacoraViajesRequestDetail;
import com.grupocastores.bitacoras.resumen.DTO.HorarioOperador;
import com.grupocastores.bitacoras.resumen.DTO.IncidenciasDTO;
import com.grupocastores.bitacoras.resumen.DTO.TalonCustomResponse;
import com.grupocastores.bitacoras.resumen.DTO.UnidadOperadorRequest;
import com.grupocastores.commons.inhouse.OperadoresSecundariosRequest;


public interface IBitacoraService {
    
    /**
     * filterViajes: Servicio para filtrar viajes.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @date 2022-12-06
     */
    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, String idViaje, String noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idClienteinhouse,String idOficinaCliente, String idoficinaDocumenta);
    
    /**
     * getDetalleViaje: Servicio para obtener el detalle del resumen de viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @date 2022-12-06
     */
    public BitacoraResumenViajesDetail getDetalleViaje(int idNegociacion, int idEsquemaViaje, int idRuta,
            int idCliente, String idOficinaCliente, String idoficinaDocumenta, int idUnidad, int noEconomico);
    
    /**
     * getTalonesByViaje: Servicio para obtener talones por viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @date 2022-12-07
     */
    public List<TalonCustomResponse> getTalonesByViaje(String idoficinaDocumenta, int idUnidad);
    
    /**
     * detTalonDetail: Servicio para obtener el detalle del resumen de talones.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return List<TalonCustomResponse>
     * @date 2022-12-13
     */
    public List<BitacoraResumenTalonDetail> getTalonDetail(String claTalon, String idoficinaDocumenta);

    /**
     * getDetalleGuia: Servicio para obtener el detalle de guia.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail
     * @date 2022-12-13
     */
    public BitacoraResumenGuiaDetail getDetalleGuia(String noGuia, String tabla, String idoficinaDocumenta) throws Exception;
    
    /**
     * getDetalleRuta: Servicio para obtener el detalle de ruta.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail>
     * @date 2022-12-18
     */
    public List<BitacoraViajesRequestDetail> getDetalleRuta(int idViaje, String idOficinaCliente, String idoficinaDocumenta2);
    
    
    /**
     * getVales: Servicio para obtener los vales por folio.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenGuiaDetail
     * @date 2022-12-19
     */
    public List<BitacoraViajesDetalleVales> getVales(String folioViaje);

    

    /**
     * obtenerCoordenadas: Obtiene coordenadas por dirección.
     * 
     * @param calle String
     * @param numExt String
     * @param colinia String
     * @param cp String
     * @param ciudad String
     * @param estado String
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra] 
     * @return Coordenada
     * @date 2022-09-26
     */
    ArrayList<IncidenciasDTO> obtenerIncidencias(String claTalon, int tipo);
  
    
    
    
    
    
    
    
    
    ///////////// MIGRAR AL MS CORRESPONDIENTE
    
    public List<AsistenciaOperadorDTO> filterAsistencias(String fechaInicio, String fechaFinal);

    public List<AsistenciaOperadorDTO> filterAsistencias(String fechaInicio, String fechaFinal, int idOperador);

    public List<HorarioOperador> filterHorario(int idunidad, int tipoOperador, int idOperador);

    public List<UnidadOperadorRequest> getUnidadesCliente(int idClienteInhouse, int idTipoUnidad);

    public List<OperadoresSecundariosRequest> getOperadoresAsignados(int idUnidad);

   

    
}
