package com.grupocastores.bitacoras.resumen.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GuiaViajeCustom: Entidad para mapear datos custom de guias.
 * 
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
 */
@Data
@Entity(name ="guiaviajecustom")
@NoArgsConstructor
@AllArgsConstructor
public class GuiaViajeCustom implements Serializable{
    
    @Id
    @Column(name="idviaje", nullable=false, precision=19)
    private long idViaje;
    @Id
    @Column(name="idoficina", nullable=false, length=4)
    private String idOficina;
    @Id
    @Column(name="no_guia", nullable=false, length=12)
    private String noGuia;
    @Column(name="idoficinaguia", length=4)
    private String idOficinaGuia;
    @Column(name="estatusguia", precision=5)
    private short estatusGuia;
    @Column(precision=10)
    private int consecutivo;
    @Column(name="impresionpreguia", precision=5)
    private short impresionPreguia;
    @Column(name="impresionguia", precision=5)
    private short impresionGuia;
    @Column(precision=5)
    private short estatus;
    @Column(name="idpersonal", precision=10)
    private int idPersonal;
    @Column(name="fechamod")
    private LocalDate fechaMod;
    @Column(name="horamod", precision=10)
    private LocalTime horaMod;
    @Column(name="totalguia", nullable=false, precision=16, scale=4)
    private BigDecimal totalGuia;
    @Column(name="idoficinadeposito", nullable=false, length=4)
    private String idOficinaDeposito;
    @Column(name="totaldeposito", nullable=false, precision=16, scale=4)
    private BigDecimal totalDeposito;
    @Column(name="operacionguia", nullable=false, precision=5)
    private short operacionGuia;
    @Column(name="idoficinadestino", nullable=false, length=4)
    private String idOficinaDestino;
    @Column(nullable=false, precision=5)
    private short visitada;
    private String tabla;
}
