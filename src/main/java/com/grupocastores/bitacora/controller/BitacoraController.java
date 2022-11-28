package com.grupocastores.bitacora.controller;

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

import com.grupocastores.bitacora.service.IBitacoraService;


@RestController
@RequestMapping(value ="/bitacora")
public class BitacoraController {
    
    @Autowired
    IBitacoraService bitacoraService;
    
//    @RequestMapping("/findTalones/{mesAnio}/{idEsquema}/{tipoViaje}/{tipoUnidad}/{idCliente}/{idOficinaCliente}/{idOficinaDocumenta}")
//    public ResponseEntity<List<TalonCustomResponse>> findTalones(
//            @PathVariable("mesAnio") String mesAnio, 
//            @PathVariable("idEsquema") int idEsquema,
//            @PathVariable("tipoViaje") int tipoViaje,
//            @PathVariable("tipoUnidad") int tipoUnidad,
//            @PathVariable("idCliente") int idCliente,
//            @PathVariable("idOficinaCliente") String idOficinaCliente,
//            @PathVariable("idOficinaDocumenta") String idOficinaDocumenta,
//            @RequestParam String determinantesOrigen,
//            @RequestParam String determinantesDestino
//            ) throws Exception{
//        List<TalonCustomResponse> response = bitacoraService.findTalones(mesAnio, idEsquema, tipoViaje, tipoUnidad, idCliente, idOficinaCliente, idOficinaDocumenta, determinantesOrigen, determinantesDestino);
//       
//        
//        return ResponseEntity.ok(response);
//        
//    } 
//    
//    @GetMapping("/findDetacoSumatoria/{claTalon}/{idOficinaDocumenta}")
//    public ResponseEntity<DetaCo> fintDetacoSumatoria(
//            @PathVariable("claTalon") String claTalon,       
//            @PathVariable("idOficinaDocumenta") String idOficinaDocumenta) throws Exception{
//        DetaCo response = bitacoraService.findDetacoSumatoria(claTalon,idOficinaDocumenta);
//             
//        return ResponseEntity.ok(response);
//        
//    } 
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
