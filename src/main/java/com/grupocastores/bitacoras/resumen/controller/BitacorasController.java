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


@RestController
@RequestMapping(value ="/viajes")
public class BitacorasController {
    
    @Autowired
    IBitacoraService bitacoraService;
    
    @RequestMapping("/filterViajes/{fechaInicio}/{fechaFin}/{idViaje}/{noEconomico}/{tipoUnidad}/{estatusViaje}/{idEsquema}/{idNegociacion}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}")
    public ResponseEntity<List<BitacoraResumenViajesCustom>> filterViajes(
            @PathVariable("fechaInicio") String fechaInicio, 
            @PathVariable("fechaFin") String fechaFin,
            @PathVariable("idViaje") int idViaje,
            @PathVariable("noEconomico") int noEconomico,
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
    
    @GetMapping("/findDetacoSumatoria")
    public ResponseEntity<String> fintDetacoSumatoria() throws Exception{
        
             
        return ResponseEntity.ok("hola");
        
    } 
//      
//    @GetMapping("/getFolioViaje/{idFolio}/{idOficinaDocumenta}")
//    public ResponseEntity<FolioDos> getFolioViaje(
//            @PathVariable("idFolio") int idFolio, @PathVariable("idOficinaDocumenta") String idOficinaDocumenta) throws Exception{
//        FolioDos folio = bitacoraService.getFolioViaje(idFolio, idOficinaDocumenta);
//        return ResponseEntity.ok(folio);
//    }
//    
//    @GetMapping("/getFolioGuia/{idFolio}/{idOficinaDocumenta}")
//    public ResponseEntity<FoliosGuias> getFolioTalon(
//            @PathVariable("idFolio") int idFolio, @PathVariable("idOficinaDocumenta") String idOficinaDocumenta) throws Exception{
//        FoliosGuias folio = bitacoraService.getFolioGuia(idFolio, idOficinaDocumenta);
//        return ResponseEntity.ok(folio);
//    }
//    
//    @PostMapping("/insertViaje")
//    public ResponseEntity<Viajes> insertViajes(
//          @RequestBody Viajes dataViaje) throws Exception{
//      Viajes response = bitacoraService.insertViaje(dataViaje);
//      if (response == null)
//          return ResponseEntity.noContent().build();
//      return ResponseEntity.ok(response);
//    }
//    @PutMapping("/updateViaje")
//    public ResponseEntity<Viajes> updateViajes(
//        @RequestBody Viajes dataViaje) throws Exception{
//        Viajes response = bitacoraService.updateViajes(dataViaje);
//        if (response == null)
//            return ResponseEntity.noContent().build();
//        return ResponseEntity.ok(response);
//      }
//    
      
}
