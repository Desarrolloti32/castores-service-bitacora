package com.grupocastores.bitacoras.resumen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;

@Repository
public class BitacoraRepository{
    
    @Autowired
    private UtilitiesRepository utilitiesRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    static final String queryFilterResumenViaje =" SELECT * FROM OPENQUERY( %s , '"
            + " SELECT "
            + "  tv.folio, "
            + "  tv.idruta, "
            + "  tv.idunidad, "
            + "  tv.idcliente, "
            + "  tv.idoficinacliente, "
            + "  tv.tipounidad AS idtipounidad, "
            + "  cti.nombre AS nombretipounidad, "
            + "  cc.noeconomico, "
            + "  tv.idremolque, "
            + "  tv.estatus, "
            + "  tes.nombre AS nombreestatus, "
            + "  tv.fechaviaje, "
            + "  tet.idnegociacion, "
            + "  tet.idesquema, "
            + "  tv.idoficinaorigen, "
            + "  cof1.plaza AS plazaorigen, "
            + "  tv.idoficinadestino, "
            + "  cof2.plaza AS plazadestino, "
            + "  tv.observaciones, "
            + "  cop.nombre AS nombreoperador "
            + " FROM "
            + "  talones.viajes tv "
            + "  INNER JOIN talones.viajes_esquema_gasto tve "
            + "    ON tv.idviaje = tve.idviaje "
            + "  INNER JOIN talones.guiaviaje tgv "
            + "    ON tv.idviaje = tgv.idviaje "
            + "  INNER JOIN talones.guias tg "
            + "    ON tgv.no_guia = tg.no_guia "
            + "  INNER JOIN talones.tg112022 tgma "
            + "    ON tg.no_guia = tgma.no_guia "
            + "  INNER JOIN talones.talones tt "
            + "    ON tgma.cla_talon = tt.cla_talon "
            + "  INNER JOIN talones.especificacion_talon tet "
            + "    ON tgma.cla_talon = tet.cla_talon "
            + "  INNER JOIN camiones.camiones cc "
            + "    ON tv.idunidad = cc.unidad "
            + "  INNER JOIN camiones.tipounidad cti "
            + "    ON tv.tipounidad = cti.idtipounidad "
            + "  INNER JOIN talones.estatusviajes tes "
            + "    ON tv.estatus = tes.idestatusviajes "
            + "  INNER JOIN camiones.operadores cop "
            + "    ON tv.idoperador = cop.idpersonal "
            + "  INNER JOIN castores.oficinas cof1  "
            + "    ON tv.idoficinaorigen = cof1.idoficina "
            + "  INNER JOIN castores.oficinas cof2  "
            + "    ON tv.idoficinadestino = cof2.idoficina "
            + " WHERE  %s  tv.idCliente = %s AND tv.idOficinacliente = \"%s\"  GROUP BY tv.idviaje; ');";
    
    
    public List<BitacoraResumenViajesCustom> filterViajes(String fechaInicio, String fechaFin, int idViaje, int noEconomico, int tipoUnidad,
            int estatusViaje, int idEsquema, int idNegociacion, int idCliente,String idOficinaCliente, String linkedServer) {
      
        String queryWherePart = "";
      
        
        if( idViaje == 0 && noEconomico==0 ) {
 
            queryWherePart = queryWherePart + " ( tv.fechaviaje BETWEEN \""+fechaInicio+"\" AND \""+fechaFin+"\")  ";
            if(tipoUnidad != 0) {            
                queryWherePart = queryWherePart + " AND tv.tipounidad = "+tipoUnidad+" ";
            }
 
            if(estatusViaje != 9999) {
                queryWherePart = queryWherePart +" AND tv.estatus = "+estatusViaje+" ";
            }else {
                queryWherePart = queryWherePart +" AND tv.estatus NOT IN(5) ";
            }
            
            if(idEsquema != 0) {
                queryWherePart = queryWherePart +" AND tet.idesquema = "+idEsquema+" ";
            }
            if(idNegociacion != 0) {
                queryWherePart = queryWherePart +" AND tet.idnegociacion = "+tipoUnidad+" ";
            }
            
        }
        
        if( idViaje != 0 ) {
            queryWherePart = queryWherePart + " tv.idviaje = "+idViaje+" AND ";
            queryWherePart = queryWherePart +"tv.estatus NOT IN(5) ";
        }
        
        if( noEconomico != 0 ) {
            queryWherePart = queryWherePart + " cc.noeconomico = "+noEconomico+" AND ";
            queryWherePart = queryWherePart +" tv.estatus NOT IN(5) ";
            
        }
        
        queryWherePart = queryWherePart + " AND ";
        Query query = entityManager.createNativeQuery(String.format(
                queryFilterResumenViaje,
                linkedServer,
                
                queryWherePart,
                idCliente,
                idOficinaCliente),
                BitacoraResumenViajesCustom.class
            );
        
        return query.getResultList();
    }
   

   
   
}
