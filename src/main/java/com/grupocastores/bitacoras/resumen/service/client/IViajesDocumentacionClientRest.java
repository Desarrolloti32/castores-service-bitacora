package com.grupocastores.bitacoras.resumen.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupocastores.commons.inhouse.GuiaViajeCustom;
import com.grupocastores.commons.inhouse.TalonCustomResponse;

@FeignClient(name="castores-service-viajes", url="localhost:8090")
public interface IViajesDocumentacionClientRest {
    
    @GetMapping("/castores/services/viajes/documentacion/getTalonesTrGuia/{noGuia}/{idoficinadocumenta}")
    public ResponseEntity<List<TalonCustomResponse>> getTalonesGuia(
            @PathVariable("noGuia") String noGuia,
            @PathVariable("idoficinadocumenta") String idOficinaDocumenta
        );
    
    @GetMapping("/castores/services/viajes/documentacion/getGuiasViaje/{idViaje}/{idOficinaDocumenta}")
    public ResponseEntity<List<GuiaViajeCustom>> getGuiasViaje(
            @PathVariable("idViaje") int idViaje,
            @PathVariable("idOficinaDocumenta") String idOficinaDocumenta
        );
}
