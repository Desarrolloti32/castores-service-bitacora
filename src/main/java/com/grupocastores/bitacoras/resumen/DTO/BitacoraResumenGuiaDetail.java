package com.grupocastores.bitacoras.resumen.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "bitacoraResumenGuiaDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraResumenGuiaDetail {
    @Id
    @Column(name="no_guia", unique=true, nullable=false, precision=12)
    private String noGuia;
    private String unidad;
    private String placas;
    @Column( precision=11)
    private String operador;
    @Column( precision=11)
    private String remolque;
    private String origen;
    private String destino;
    @Column( precision=40)
    private String despacho;
    private String moneda;
    
}
