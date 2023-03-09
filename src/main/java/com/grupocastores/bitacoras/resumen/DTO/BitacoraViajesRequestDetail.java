package com.grupocastores.bitacoras.resumen.DTO;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BitacoraViajesRequestDetail: Clase que construye los Bitacora Viajes Detalles.
 * 
 * @version 0.0.1
 * @author OscarGuerra [OscarGuerra]
 * @date 2022-08-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BitacoraViajesRequestDetail {
	private int idParent;
	private int idChild;
	private String tipoUnidad;
	private String nombreEsquema;
	private int idUnidad;
	private String nombreSucOrigen;
	private String calleSucOrigen;
	private String coloniaSucOrigen;
	private String ciudadOrigen;
	private int idClienteDestino;
	private String nombreSucDestino;
	private String calleSucDestino;
	private String coloniaSucDestino;
	private String ciudadDestino;
	private int idSucursalDescarga;
	private String idOficinaDestino;
	private String rfcDestino;
	private String noEconomico;
	private Date fechaDescarga;
	private Time horaDescarga;
	private String idOficinaCarga;
	private int idCliente2009Carga;
}
