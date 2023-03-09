package com.grupocastores.bitacoras.resumen.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CiudadesEstadoRequest: Clase que construye los datos de Ciudades y Estados.
 * 
 * @version 0.0.1
 * @author Moises Lopez Arrona [moisesarrona]
 * @date 2022-06-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadesEstadoRequest {
	
	private int idCiudad;
	private String ciudad;
	private String idEstado;
	private String estado;
	
}
