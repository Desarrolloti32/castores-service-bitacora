package com.grupocastores.bitacoras.resumen.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TablaTalonesOficina:Entidad custom que mapea los talones por oficina.
 * 
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "tablatalonesoficina")
public class TablaTalonesOficina implements Serializable{
    
    @Id
    @Column(name="cla_talon", nullable=false, length=12)
    private String claTalon;
    @Column(name="idoficina", nullable=false, length=4)
    private String idOficina;
    @Column(nullable=false, length=6)
    private String tabla;
    @Column(nullable=false, precision=5)
    private short status;
    @Column(length=20)
    private String remision;
    @Id
    @Column(nullable=false, length=10)
    private String serie;
    @Column(nullable=false, precision=16, scale=4)
    private BigDecimal maniobras;

}
