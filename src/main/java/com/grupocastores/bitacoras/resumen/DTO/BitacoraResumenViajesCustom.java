package com.grupocastores.bitacoras.resumen.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

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
@Entity(name = "bitacoraResumenViajesCustom")
public class BitacoraResumenViajesCustom {
    @Id
    private String folio;
    
    @Column(name="idviaje")
    private int idViaje;
    
    @Column(name="idruta")
    private int idRuta;
    
    @Column(name="idunidad")
    private int idUnidad;
    
    @Column(name="idtipounidad")
    private int idTipoUnidad;
    
    @Transient
    private int unidadUrea;
    @Transient
    private int unidadDiesel;
    
    @Column(name="nombretipounidad")
    private String nombreTipoUnidad;
    
    @Column(name="noeconomico")
    private int noEconomico;
    
    @Column(name="idremolque")
    private int idRemolque;
    
    private int estatus;
    
    @Column(name="nombreestatus")
    private String nombreEstatus;
    
    @Column(name="fechaviaje")
    private LocalDate fechaViaje;
    
    @Column(name="fechamod")
    private LocalDate fechaMod;
    
    @Column(name="idnegociacion")
    private int idNegociacion;
    
    @Column(name="idesquema")
    private int idEsquema;
    
    @Column(name="idoficinaorigen")
    private String idOficinaOrigen;
    
    @Column(name="plazaorigen")
    private String plazaOrigen;
    
    @Column(name="idoficinadestino")
    private String idOficinaDestino;
    
    @Column(name="plazadestino")
    private String plazaDestino;
    
    private String observaciones;
    
    @Column(name="nombreoperador")
    private String nombreOperador;
    
}
