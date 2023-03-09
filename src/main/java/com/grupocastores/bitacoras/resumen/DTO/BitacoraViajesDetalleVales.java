package com.grupocastores.bitacoras.resumen.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bitacoraViajesDetalleVales")

public class BitacoraViajesDetalleVales {
    @Id
    @Column(name = "idvale")
    private String idVale;
    
    private BigDecimal cantidad;

    @Column(name = "cantidadrecibida")
    private BigDecimal cantidadRecibida;

    @Column(name = "cantidadrecibidag")
    private BigDecimal cantidadRecibidaG;
    
    private String observaciones;

    @Column(name = "tipopago")
    private String tipoPago;

    @Column(name = "tipogasto")
    private String tipoGasto;
    
    private LocalDate fecha;
}
