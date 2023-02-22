package com.grupocastores.bitacoras.resumen.service.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Rutas: Entidad para la tabla talones.ruta.
 * 
 * @version 0.0.1
 * @author Cynthia Fuentes Amaro
 * @date 2022-09-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "talones.ruta")
@IdClass(Ruta.RutaId.class)
public class Ruta implements Serializable {
	
	private static final long serialVersionUID = 7981273289853921902L;

	public static class RutaId implements Serializable{
		
		private static final long serialVersionUID = -6711397987332452629L;

		public RutaId() {
			super();
		}
		
		int idRuta;
	}
	
	@Id
    @Column(name = "idruta", nullable = false, precision = 10)
    private int idRuta;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(name = "idoficinaorigen", nullable = false, length = 4)
    private String idOficinaOrigen;
    
    @Column(name = "idoficinadestino", nullable = false, length = 4)
    private String idOficinaDestino;
    
    @Column(nullable = false, precision = 5)
    private Short estatus;
    
    @Column(name = "idtiporuta", nullable = false, precision = 5)
    private Short idTipoRuta;
    
    @Column(name = "idpersonal", precision = 10)
    private int idPersonal;
    
    @Column(name = "fechamod")
    private LocalDate fechaMod;
    
    @Column(name = "horamod")
    private LocalTime horaMod;
    
}
