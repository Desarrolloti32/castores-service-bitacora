
# DOCUMENTACION DE ENDPOINTS 
~~~
### Este microservicio esta orientado al modulo de resumen de viajes
~~~
    
## ENDPOINTS PARA RESUMEN DE VIAJES
## Path /viajes/

### Filtra los viajes dependiendo las especificaciones seleccionadas
	Get(value = "/filterViajes/{fechaInicio}/{fechaFin}/{idViaje}/{noEconomico}/{tipoUnidad}/{estatusViaje}/{idEsquema}/{idNegociacion}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}") 

### Servicio para obtener el detalle del resumen de viaje
	@Get(value = "/getDetalleViaje/{idNegociacion}/{idEsquemaViaje}/{idRuta}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}/{idUnidad}/{noEconomico}")
