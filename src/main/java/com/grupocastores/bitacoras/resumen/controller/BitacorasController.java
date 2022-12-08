package com.grupocastores.bitacoras.resumen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupocastores.bitacoras.resumen.service.IBitacoraService;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesCustom;
import com.grupocastores.commons.inhouse.BitacoraResumenViajesDetail;


@RestController
@RequestMapping(value ="/viajes")
public class BitacorasController {
    
    @Autowired
    IBitacoraService bitacoraService;
    
    /**
     * filterViajes: Servicio para filtrar viajes.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return List<BitacoraResumenViajesCustom>
     * @date 2022-12-06
     */
    @RequestMapping("/filterViajes/{fechaInicio}/{fechaFin}/{idViaje}/{noEconomico}/{tipoUnidad}/{estatusViaje}/{idEsquema}/{idNegociacion}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}")
    public ResponseEntity<List<BitacoraResumenViajesCustom>> filterViajes(
            @PathVariable("fechaInicio") String fechaInicio, 
            @PathVariable("fechaFin") String fechaFin,
            @PathVariable("idViaje") String idViaje,
            @PathVariable("noEconomico") String noEconomico,
            @PathVariable("tipoUnidad") int tipoUnidad,
            @PathVariable("estatusViaje") int estatusViaje,
            @PathVariable("idEsquema") int idEsquema,
            @PathVariable("idNegociacion") int idNegociacion,
            @PathVariable("idCliente") int idCliente,
            @PathVariable("idOficinaCliente") String idOficinaCliente,
            @PathVariable("idoficinaDocumenta") String idoficinaDocumenta
          
            ) throws Exception{
        List<BitacoraResumenViajesCustom> response = bitacoraService.filterViajes(fechaInicio, fechaFin, idViaje, noEconomico, tipoUnidad, estatusViaje, idEsquema, idNegociacion, idCliente, idOficinaCliente, idoficinaDocumenta);
       
        
        return ResponseEntity.ok(response);
        
    } 
    
    /**
     * getDetalleViaje: Servicio para obtener el detalle del resumen de viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenViajesDetail
     * @date 2022-12-06
     */
    @GetMapping("/getDetalleViaje/{idNegociacion}/{idEsquemaViaje}/{idRuta}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}/{idUnidad}/{noEconomico}")
    public ResponseEntity<BitacoraResumenViajesDetail> getDetalleViaje(
            @PathVariable("idNegociacion") int idNegociacion,
            @PathVariable("idEsquemaViaje") int idEsquemaViaje,
            @PathVariable("idRuta") int idRuta,
            @PathVariable("idCliente") int idCliente,
            @PathVariable("idOficinaCliente") String idOficinaCliente,
            @PathVariable("idoficinaDocumenta") String idoficinaDocumenta,
            @PathVariable("idUnidad") int idUnidad,
            @PathVariable("noEconomico") int noEconomico) throws Exception{
        BitacoraResumenViajesDetail response = bitacoraService.getDetalleViaje(idNegociacion, idEsquemaViaje, idRuta,  idCliente, idOficinaCliente, idoficinaDocumenta, idUnidad, noEconomico);
       
        
        return ResponseEntity.ok(response);
        
    } 
    
    /**
     * getDetalleViaje: Servicio para obtener el detalle del resumen de viaje.
     * 
     * @version 0.0.1
     * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
     * @return BitacoraResumenViajesDetail
     * @date 2022-12-06
     */
    @GetMapping("/getTalonesByViaje/{idoficinaDocumenta}/{idViaje}")
    public ResponseEntity<BitacoraResumenViajesDetail> getTalonesByViaje(    
            @PathVariable("idoficinaDocumenta") String idoficinaDocumenta,
            @PathVariable("idViaje") int idViaje) throws Exception{
        BitacoraResumenViajesDetail response = bitacoraService.getTalonesByViaje(idoficinaDocumenta, idViaje);
       
        
        return ResponseEntity.ok(response);
        
    } 
    

      
}
