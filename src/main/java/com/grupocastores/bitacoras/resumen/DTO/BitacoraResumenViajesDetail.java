package com.grupocastores.bitacoras.resumen.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BitacoraResumenViajesCustom: Clase que construye la información de las casetas de gastos.
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo
 * @date 2022-11-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "detalleResumenViaje")
public class BitacoraResumenViajesDetail {
    @Id
    private String descripcionNegociacion;
    private String descripcionEsquema;
    private String descripcionRuta;
    private String estatusLiberacion;
    private Double gastoCasetas;
    private String estatusUnidad;
    
}
