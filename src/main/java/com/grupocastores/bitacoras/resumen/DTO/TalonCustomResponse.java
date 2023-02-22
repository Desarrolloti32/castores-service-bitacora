package com.grupocastores.bitacoras.resumen.DTO;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TablaTalonesOficina:Entidad custom que mapea importes de talones.
 * 
 * 
 * @version 0.0.1
 * @author Oscar Eduardo Guerra Salcedo [OscarGuerra]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="findTalonCustom")
public class TalonCustomResponse {
    @Id
    @Column(name = "clatalon")
    private String claTalon;
    @Transient
    private String noGuia;
    
    @Column(name = "nomorigen")
    private String nomOrigen;
    
    @Column(name = "calleorigen")
    private String calleOrigen;
    
    @Column(name = "nomdestino")
    private String nomDestino;
    
    @Column(name = "calledestino")
    private String calleDestino;
    
    @Column(name = "idesquema")
    private int idEsquema;
    
    @Column(name = "idnegociacion")
    private int idNegociacion;
    
    @Column(name = "idcliente")
    private int idCliente;
    
    @Column(name = "idoficina")
    private String idOficina;
    
    private String remision;
    
    @Column(name = "importeseguro")
    private BigDecimal importeSeguro;
    
    private BigDecimal recoleccion; 
    private BigDecimal entrega;
    private BigDecimal maniobras; 
    private BigDecimal ferry; 
    private BigDecimal revac;
    
    @Column(name = "otroscargos")
    private BigDecimal otrosCargos;
    private BigDecimal gps;
    
    @Column(name = "importesubtotal")
    private BigDecimal importeSubtotal; 
    
    @Column(name = "importeiva")
    private BigDecimal importeIva ;
    
    @Column(name = "importeivaret")
    private BigDecimal importeIvaRet; 
    
    @Column(name = "otraslineas")
    private BigDecimal otrasLineas; 
    
    @Column(name = "importetotal")
    private BigDecimal importeTotal;
    
    @Column(name = "valdecl")
    private BigDecimal valDecl; 
}