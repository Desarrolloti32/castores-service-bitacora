package com.grupocastores.bitacoras.resumen.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

/**
 * @title                  : Personal.java
 * @description            : Entity de personal.
 * @date                   : 2022-03-14
 * @company 			   : Transportes Castores de Baja California S.A. de C.V
 * @author                 : Moises Lopez Arrona [moisesarrona]
 * @version 			   : 1.0.0
 * @idTicket               : NULL
 */
@Data
@Entity(name = "personal.personal")
@IdClass(Personal.PersonalId.class)
public class Personal implements Serializable {
	
	public static class PersonalId implements Serializable {
		
		private static final long serialVersionUID = 1336435060912117519L;

		public PersonalId() {
			super();
		}
		
		int idpersonal;
	}

	private static final long serialVersionUID  =  -1837026705539544509L;
	
	@Id
	@Column(unique = true, nullable = false, precision = 11)
    private int idpersonal;
	
    @Column(unique = true, length = 12)
    private String idusuario;
    
    @Column(nullable = false, length = 4)
    private String idoficina;
    
    @Column(nullable = false, length = 40)
    private String nombre;
    
    @Column(nullable = false, length = 40)
    private String apepaterno;
    
    @Column(length = 40)
    private String apematerno;
    
    private LocalDate fechanacimiento;
    
    @Column(length = 1)
    private String sexo;
    
    @Column(length = 13)
    private String rfc;
    @Column(length = 15)
    private String imss;
    
    @Column(length = 18)
    private String curp;
    
    @Column(length = 10)
    private String nocartilla;
    
    @Column(length = 15)
    private String nolic;
    
    @Column(length = 20)
    private String tipolic;
    
    private LocalDate fechaexplic;
    
    private LocalDate fechavenlic;
    
    @Column(length = 20)
    private String nopasaporte;
    
    private LocalDate fechaexppas;
    
    private LocalDate fechavenpas;
    
    @Column(length = 50)
    private String calle;
    
    @Column(length = 15)
    private String noexterior;
    
    @Column(length = 15)
    private String nointerior;
    
    @Column(length = 30)
    private String colonia;
    
    @Column(length = 30)
    private String delegacion;
    
    @Column(length = 6)
    private String cp;
    @Column(precision = 11)
    private int idciudad;
    
    @Column(length = 15)
    private String tel;
    
    @Column(length = 3)
    private String lada;
    
    @Column(precision = 6)
    private short edocivil;
    
    @Column(length = 50)
    private String alergias;
    
    @Column(length = 5)
    private String tiposan;
    
    @Column(precision = 6)
    private short status;
    
    private LocalDate fechaalta;
    
    @Column(length = 255)
    private String foto;
    
    @Column(length = 255)
    private String voz;
    
    @Column(name = "e_mail", length = 255)
    private String eMail;
    
    @Column(length = 255)
    private String fotoperfil;
    
    private LocalDate fechafoto;
    
    private LocalDate fechaaltafoto;
    
    @Column(precision = 11)
    private Integer cuenta;
    
    @Column(precision = 11)
    private Integer mayor;
    
    private LocalDate fechafotoperfil;
    
    private LocalDate fechaaltaperfil;
    
    @Column(length = 20)
    private String nacionalidad;
    
    @Column(precision = 6)
    private short essocio;
    
    private LocalDate fechaingreso;
    
    @Column(length = 30)
    private String puesto;
    
    @Column(length = 25)
    private String sobrenombre;
    
    private String observaciones;
    
    private String observaciones1;
    
    @Column(precision = 16, scale = 4)
    private BigDecimal sueldo;
    
    @Column(precision = 6)
    private short tipopago;
    
    @Column(precision = 6)
    private short tiponomina;
    
    @Column(length = 4)
    private String idnomina;
    
    @Column(nullable = false, precision = 11)
    private int idpersonaalta;
    
    @Column(nullable = false)
    private LocalTime horaalta;
    
    @Column(nullable = false)
    private LocalDate fechacaptura;
    
    @Column(length = 20)
    private String credinfonavit;
    
    @Column(nullable = false, precision = 6)
    private short asegurado;
    
    @Column(precision = 6)
    private short idcontrato;
    
    private LocalDate freingreso;
    
    @Column(nullable = false)
    private LocalDate fechamod;
    
    @Column(nullable = false)
    private LocalTime horamod;
    
    @Column(nullable = false, precision = 1)
    private short idescolaridad;
    
    @Column(nullable = false, precision = 1)
    private short iddocumento;
    
    @Column(nullable = false, length = 200)
    private String carrera;
    

}
