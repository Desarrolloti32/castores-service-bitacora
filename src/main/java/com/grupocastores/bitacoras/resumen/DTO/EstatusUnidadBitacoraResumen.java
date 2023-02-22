package com.grupocastores.bitacoras.resumen.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * EstatusUnidadBitacoraResumen: Entidad para mapear los estatus de unidades en bitacoras.
 * 
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "estatusUnidadResumenViaje")
public class EstatusUnidadBitacoraResumen {
    @Id
    @Column(name = "idunidad")
    private int idUnidad;
    
    @Column(name = "nombre")
    private String nombreEstatus;
}
