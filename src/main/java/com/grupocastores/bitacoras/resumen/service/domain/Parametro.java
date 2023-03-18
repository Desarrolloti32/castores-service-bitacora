package com.grupocastores.bitacoras.resumen.service.domain;

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
* Título                    : Parametro.java
* Descripción               : Entity de parametro
* Compañía                  : Transportes Castores de Baja California S.A. de C.V. – Área de Desarrollo
* Fecha de creación         : 2020-02-27
* Autor                     : Adiel Hernandez Palacios / Luis Francisco Bernal Rios
* Versión                   : 1.0.0
* ID Requerimiento/Ticket   : NULL
*/
@Entity(name = "parametroEntity")
public class Parametro implements Serializable {

	private static final long serialVersionUID = 6813122784855586234L;

	/** Primary key. */
    protected static final String PK = "idParametro";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_parametro", unique=true, nullable=false, precision=10)
    private long idParametro;
    
    @Column(nullable=false, length=4)
    private String clave;
    
    @Column(nullable=false, length=80)
    private String nombre;
    
    @Column(length=350)
    private String descripcion;
    
    @Column(nullable=false, length=80)
    private String valor;
    
    @Column(name="fecha_inicio", nullable=false)
    private Timestamp fechaInicio;
    
    @Column(name="fecha_fin")
    private Timestamp fechaFin;
    
    @Column(nullable=false, precision=3)
    private short nacional;

	@Column(name = "id_oficina", precision = 10)
	private long idOficina;

	@Column(name = "id_modulo", precision = 10)
	private long idModulo;

	@Column(name = "id_estatus_parametro", precision = 10)
	private long idEstatusParametro;

	/** Default constructor. */
	public Parametro() {
		super();
	}

	/**
	 * Access method for idParametro.
	 *
	 * @return the current value of idParametro
	 */
	public long getIdParametro() {
		return idParametro;
	}

	/**
	 * Setter method for idParametro.
	 *
	 * @param aIdParametro the new value for idParametro
	 */
	public void setIdParametro(long aIdParametro) {
		idParametro = aIdParametro;
	}

	/**
	 * Access method for clave.
	 *
	 * @return the current value of clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Setter method for clave.
	 *
	 * @param aClave the new value for clave
	 */
	public void setClave(String aClave) {
		clave = aClave;
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
	 * Access method for valor.
	 *
	 * @return the current value of valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setter method for valor.
	 *
	 * @param aValor the new value for valor
	 */
	public void setValor(String aValor) {
		valor = aValor;
	}

	/**
	 * Access method for fechaInicio.
	 *
	 * @return the current value of fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Setter method for fechaInicio.
	 *
	 * @param aFechaInicio the new value for fechaInicio
	 */
	public void setFechaInicio(Timestamp aFechaInicio) {
		fechaInicio = aFechaInicio;
	}

	/**
	 * Access method for fechaFin.
	 *
	 * @return the current value of fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * Setter method for fechaFin.
	 *
	 * @param aFechaFin the new value for fechaFin
	 */
	public void setFechaFin(Timestamp aFechaFin) {
		fechaFin = aFechaFin;
	}

	/**
	 * Access method for nacional.
	 *
	 * @return the current value of nacional
	 */
	public short getNacional() {
		return nacional;
	}

	/**
	 * Setter method for nacional.
	 *
	 * @param aNacional the new value for nacional
	 */
	public void setNacional(short aNacional) {
		nacional = aNacional;
	}

	/**
	 * Access method for idOficina.
	 *
	 * @return the current value of idOficina
	 */
	public long getIdOficina() {
		return idOficina;
	}

	/**
	 * Setter method for idOficina.
	 *
	 * @param aIdOficina the new value for idOficina
	 */
	public void setIdOficina(long aIdOficina) {
		idOficina = aIdOficina;
	}

	/**
	 * Access method for idModulo.
	 *
	 * @return the current value of idModulo
	 */
	public long getIdModulo() {
		return idModulo;
	}

	/**
	 * Setter method for idModulo.
	 *
	 * @param aIdModulo the new value for idModulo
	 */
	public void setIdModulo(long aIdModulo) {
		idModulo = aIdModulo;
	}

	/**
	 * Access method for idEstatusParametro.
	 *
	 * @return the current value of idEstatusParametro
	 */
	public long getIdEstatusParametro() {
		return idEstatusParametro;
	}

	/**
	 * Setter method for idEstatusParametro.
	 *
	 * @param aIdEstatusParametro the new value for idEstatusParametro
	 */
	public void setIdEstatusParametro(long aIdEstatusParametro) {
		idEstatusParametro = aIdEstatusParametro;
	}

	/**
     * Compares the key for this instance with another Parametro.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Parametro and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Parametro)) {
            return false;
        }
        Parametro that = (Parametro) other;
        if (this.getIdParametro() != that.getIdParametro()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Parametro.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Parametro)) return false;
        return this.equalKeys(other) && ((Parametro)other).equalKeys(this);
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
        i = (int)(getIdParametro() ^ (getIdParametro()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Parametro |");
        sb.append(" idParametro=").append(getIdParametro());
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
        ret.put("idParametro", Long.valueOf(getIdParametro()));
        return ret;
    }

}
