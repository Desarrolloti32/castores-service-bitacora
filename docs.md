
# DOCUMENTACION DE ENDPOINTS 
~~~
### Este microservicio esta orientado al modulo de resumen de viajes
~~~
    
## ENDPOINTS PARA RESUMEN DE VIAJES
## Path /viajes

### Filtra los viajes dependiendo las especificaciones seleccionadas
	Get(value = "/filterViajes/{fechaInicio}/{fechaFin}/{idViaje}/{noEconomico}/{tipoUnidad}/{estatusViaje}/{idEsquema}/{idNegociacion}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}")
	Response:
	`
		[
		    {
			"folio": "22020300039",
			"idruta": 4564,
			"idunidad": 3044,
			"idtipounidad": 1,
			"nombretipounidad": "TRAILER",
			"noeconomico": 95835,
			"idremolque": 0,
			"estatus": 3,
			"nombreestatus": "TERMINADO",
			"fechaviaje": "2022-11-23",
			"fechamod": "2022-11-22",
			"idnegociacion": 0,
			"idesquema": 3,
			"idoficinaorigen": "1101",
			"plazaorigen": "LEON",
			"idoficinadestino": "1101",
			"plazadestino": "LEON",
			"observaciones": "ESTA ES UNA OBSERVACIÓN DE PRUEBA",
			"nombreoperador": "CASTRO ESPARZA ROBERTO"
		    },
		    {
			"folio": "22020300041",
			"idruta": 4564,
			"idunidad": 3044,
			"idtipounidad": 1,
			"nombretipounidad": "TRAILER",
			"noeconomico": 95835,
			"idremolque": 923,
			"estatus": 3,
			"nombreestatus": "TERMINADO",
			"fechaviaje": "2022-11-23",
			"fechamod": "2022-11-23",
			"idnegociacion": 0,
			"idesquema": 3,
			"idoficinaorigen": "1101",
			"plazaorigen": "LEON",
			"idoficinadestino": "1101",
			"plazadestino": "LEON",
			"observaciones": "ESTA ES UNA OBSERVACIÓN DE PRUEBA\nPrueba de modulo",
			"nombreoperador": "CONTRERAS PEREZ ALEJANDRO"
		    }
		]
	`

### Servicio para obtener el detalle del resumen de viaje
	@Get(value = "/getDetalleViaje/{idNegociacion}/{idEsquemaViaje}/{idRuta}/{idCliente}/{idOficinaCliente}/{idoficinaDocumenta}/{idUnidad}/{noEconomico}")
