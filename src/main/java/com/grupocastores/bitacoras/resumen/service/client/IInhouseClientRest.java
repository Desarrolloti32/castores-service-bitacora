package com.grupocastores.bitacoras.resumen.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupocastores.bitacoras.resumen.DTO.BitacoraViajesRequestDetail;
import com.grupocastores.bitacoras.resumen.DTO.CiudadesEstadoRequest;



@FeignClient("castores-service-inhouse")
public interface IInhouseClientRest {
    
   
    @GetMapping("catalogo/findCiudadAndEstado/{idCiudad}")
    public ResponseEntity<CiudadesEstadoRequest> findCiudadAndEstado(@PathVariable("idCiudad") int idCiudad);
    
    @GetMapping("bitacora/findBitacoraViajeDetail/{idViaje}")
    public ResponseEntity<List<BitacoraViajesRequestDetail>> findBitacoraViajeDetail(@PathVariable(name="idViaje") int idViaje);
}
