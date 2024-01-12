package com.grupocastores.bitacoras.resumen.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bitacoraResumenTalonDetail")
public class BitacoraResumenTalonDetail {
    @Id
    @Column(name="cla_talon")
    private String claTalon; 
    
    @Column(name="tipotalon")
    private String tipoTalon; 
    
    @Column(name="tipopago")
    private String tipoPago;
    
    @Column(name="rfcorigen")
    private String rfcOrigen; 
    
    @Column(name="nomorigen")
    private String nomOrigen;
    
    @Column(name="calleorigen") 
    private String calleOrigen; 
    
    @Column(name="coloniaorigen")
    private String coloniaOrigen; 
    
    @Column(name="cporigen")
    private String cpOrigen; 
    
    @Column(name="telorigen")
    private String telOrigen; 
    
    @Column(name="ciudadorigen")
    private String ciudadOrigen; 
    
    @Column(name="estadoorigen")
    private String estadoOrigen; 
    
    @Column(name="serecogera")
    private String seRecogera; 
    
    @Column(name="rfcdestino")
    private String rfcDestino; 
    
    @Column(name="nomdestino")
    private String nomDestino; 
    
    @Column(name="calledestino")
    private String calleDestino; 
    
    @Column(name="coloniadestino")
    private String coloniaDestino; 
    
    @Column(name="cpdestino")
    private String cpDestino; 
    
    @Column(name="teldestino")
    private String telDestino; 
    
    @Column(name="ciudaddestino")
    private String ciudadDestino; 
    
    @Column(name="estadodestino")
    private String estadoDestino; 
    
    @Column(name="seentregara")
    private String seEntregara; 
    
    @Column(name="sumaflete")
    private BigDecimal sumaFlete; 
    
    @Column(name="importeseguro")
    private BigDecimal importeSeguro; 
    
    private BigDecimal casetas; 
    
    @Column(name="otroscargos")
    private BigDecimal otrosCargos; 
    
    private BigDecimal revac;
    
    private int completo; 
    
    private BigDecimal recoleccion; 

    private BigDecimal entrega;
    
    private BigDecimal maniobras;  
    
    private BigDecimal ferry; 
    
    private BigDecimal gps;  
    
    @Column(name="importesubtotal")  
    private BigDecimal importeSubtotal;  
    
    @Column(name="importeiva")  
    private BigDecimal importeIva;   
    
    @Column(name="importeivaret")  
    private BigDecimal importeIvaRet;   
    
    @Column(name="otraslineas")  
    private BigDecimal otrasLineas;  
    
    @Column(name="importetotal")  
    private BigDecimal importeTotal;  
    
    @Column(name="valdecl")  
    private BigDecimal valDecl;
    
    private String empaque;
    
    private int etiquetas;
    
    private int bultos;
    
    @Column(name="quecontiene")  
    private String queContiene;
    
    @Column(name="consccp")  
    private int consCcp;
    
    private int cantidad;
    
    @Column(name="claveunidadpeso")  
    private String claveUnidadPeso;
    
    @Column(name="descripcionunidad")  
    private String descripcionUnidad;
    
    @Column(name="claveprodservcp")  
    private int claveProdServCp;
    
    @Column(name="descripcionclaveprod")  
    private String descripcionClaveProd;
    
    private BigDecimal peso;
    
    @Column(name="materialpeligroso")  
    private String materialPeligroso;
    
    @Column(name="cvematerialpeligroso")  
    private String cveMaterialPeligroso;
    
    @Column(name="tipoembalaje")  
    private String tipoEmbalaje;
    
    @Column(name="descripcion_embalaje")  
    private String descripcionEmbalaje;
    
    @Column(name="valormercancia")  
    private BigDecimal valorMercancia;
    
    private String remision;
    
    private String ubicacion;
    
    private LocalDateTime fecha;
    
    private int estatus;
    
    @Column(name="servicio_full")  
    private String servicioFull;
    
    @Column(name="servicio_contact_center")  
    private String servicioContactCenter;
    
    @Column(name="id_clasificacion_completos")  
    private Integer idClasificacionCompletos;
    
    @Column(name="nombre_clasificacion")  
    private String nombreClasificacion;
    
}
