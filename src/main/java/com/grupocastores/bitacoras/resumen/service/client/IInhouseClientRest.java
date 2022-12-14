package com.grupocastores.bitacoras.resumen.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupocastores.commons.inhouse.CiudadesEstadoRequest;
import com.grupocastores.commons.inhouse.GuMesAnio;
import com.grupocastores.commons.inhouse.GuiaViajeCustom;
import com.grupocastores.commons.inhouse.TablaTalonesOficina;
import com.grupocastores.commons.inhouse.TalonCustomResponse;

@FeignClient("castores-service-inhouse")
public interface IInhouseClientRest {
    
   
    @GetMapping("catalogo/findCiudadAndEstado/{idCiudad}")
    public ResponseEntity<CiudadesEstadoRequest> findCiudadAndEstado(@PathVariable("idCiudad") int idCiudad);
}
