package com.grupocastores.bitacoras.resumen.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="asistenciaOperador")

public class AsistenciaOperadorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7822813191635600725L;
	
	@Id
	private int idpersonal;
	private String operador;
	@Id
	private String fecha;
	@Id
	private String hora;
}
