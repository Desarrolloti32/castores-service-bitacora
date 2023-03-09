package com.grupocastores.bitacoras.resumen.service.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * GuMesAnio: Entidad para mapear la tabla guia mes anio.
 * 
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
 */
@Data
@Entity(name="talones.guMesAnio")
public class GuMesAnio {
    @Id
    @Column(name="no_guia", unique=true, nullable=false, precision=12)
    private String noGuia;
    private String unidad;
    private String placas;
    @Column(name="idoperador", precision=11)
    private int idOperador;
    @Column(precision=11)
    private String remolque;
    @Column( precision=11)
    private int origen;
    @Column( precision=11)
    private int destino;
    @Column( precision=40)
    private String despacho;
    @Column(name="idpersonal", precision=11)
    private int idPersonal;
    @Column(name="idoficina", precision=4)
    private String idOficina;
    @Column( precision=6)
    private int moneda;
    @Column( precision=11)
    private BigDecimal conversion;
    private Date fecha;
    private Time hora;
    @Column( precision=6)
    private int status;
    
}
