package com.grupocastores.bitacoras.resumen.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
* Título                    : Moneda.java
* Descripción               : Entity de moneda
* Compañia                  : Transportes Castores de Baja California S.A. de C.V. Area de Desarrollo
* Fecha de creación         : 2020-05-15
* Autor                     : Pablo Velazquez Martinez
* Versión                   : 1.0.0
* ID Requerimiento/Ticket   : NULL
*/
@Entity(name = "moneda")
public class Moneda implements Serializable {

	private static final long serialVersionUID = -6723317403458304837L;
	/** Primary key. */
    protected static final String PK = "idMoneda";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_moneda", unique=true, nullable=false, precision=10)
    private long idMoneda;
    
    @Column(nullable=false, length=80)
    private String nombre;
    
    @Column(length=350)
    private String descripcion;
    
    @Column(name="tipo_cambio", nullable=false, precision=12, scale=2)
    private double tipoCambio;
    
    @Column(name="fecha_registro", nullable=false)
    private Timestamp fechaRegistro;
    
    @Column(name="fecha_modificacion")
    private Timestamp fechaModificacion;
    
    @Column(name="id_usuario_modificacion", precision=10)
    private long idUsuarioModificacion;

	@Column(name = "id_estatus_moneda", precision = 10)
	private long idEstatusMoneda;

	/** Default constructor. */
	public Moneda() {
		super();
	}

	/**
	 * Access method for idMoneda.
	 *
	 * @return the current value of idMoneda
	 */
	public long getIdMoneda() {
		return idMoneda;
	}

	/**
	 * Setter method for idMoneda.
	 *
	 * @param aIdMoneda the new value for idMoneda
	 */
	public void setIdMoneda(long aIdMoneda) {
		idMoneda = aIdMoneda;
	}

	/**
	 * Access method for nombre.
	 *
	 * @return the current value of nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter method for nombre.
	 *
	 * @param aNombre the new value for nombre
	 */
	public void setNombre(String aNombre) {
		nombre = aNombre;
	}

	/**
	 * Access method for descripcion.
	 *
	 * @return the current value of descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter method for descripcion.
	 *
	 * @param aDescripcion the new value for descripcion
	 */
	public void setDescripcion(String aDescripcion) {
		descripcion = aDescripcion;
	}

	/**
	 * Access method for tipoCambio.
	 *
	 * @return the current value of tipoCambio
	 */
	public double getTipoCambio() {
		return tipoCambio;
	}

	/**
	 * Setter method for tipoCambio.
	 *
	 * @param aTipoCambio the new value for tipoCambio
	 */
	public void setTipoCambio(double aTipoCambio) {
		tipoCambio = aTipoCambio;
	}

	/**
	 * Access method for fechaRegistro.
	 *
	 * @return the current value of fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Setter method for fechaRegistro.
	 *
	 * @param aFechaRegistro the new value for fechaRegistro
	 */
	public void setFechaRegistro(Timestamp aFechaRegistro) {
		fechaRegistro = aFechaRegistro;
	}

	/**
	 * Access method for fechaModificacion.
	 *
	 * @return the current value of fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Setter method for fechaModificacion.
	 *
	 * @param aFechaModificacion the new value for fechaModificacion
	 */
	public void setFechaModificacion(Timestamp aFechaModificacion) {
		fechaModificacion = aFechaModificacion;
	}

	/**
	 * Access method for idUsuarioModificacion.
	 *
	 * @return the current value of idUsuarioModificacion
	 */
	public long getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * Setter method for idUsuarioModificacion.
	 *
	 * @param aIdUsuarioModificacion the new value for idUsuarioModificacion
	 */
	public void setIdUsuarioModificacion(long aIdUsuarioModificacion) {
		idUsuarioModificacion = aIdUsuarioModificacion;
	}

	/**
	 * Compares the key for this instance with another Moneda.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Moneda and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Moneda)) {
			return false;
		}
		Moneda that = (Moneda) other;
		if (this.getIdMoneda() != that.getIdMoneda()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Moneda.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Moneda))
			return false;
		return this.equalKeys(other) && ((Moneda) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = (int) (getIdMoneda() ^ (getIdMoneda() >>> 32));
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Moneda |");
		sb.append(" idMoneda=").append(getIdMoneda());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("idMoneda", Long.valueOf(getIdMoneda()));
		return ret;
	}

}
