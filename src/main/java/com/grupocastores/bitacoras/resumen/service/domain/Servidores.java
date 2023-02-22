package com.grupocastores.bitacoras.resumen.service.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="servidores")
public class Servidores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3124390097463302043L;

	/** Primary key. */
    protected static final String PK = "Oficina";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Oficina", unique=true, nullable=false, precision=4)
    private short oficina;
    
    @Column(name="Servidor vinculado", nullable=false, length=30)
    private String servidorVinculado;


    /** Default constructor. */
    public Servidores() {
        super();
    }

    /**
     * Access method for idParametro.
     *
     * @return the current value of idParametro
     */
    public short getOficina() {
        return oficina;
    }

    /**
     * Setter method for idParametro.
     *
     * @param aIdParametro the new value for idParametro
     */
    public void setOficina(short aOficina) {
        oficina = aOficina;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getServidorVinculado() {
        return servidorVinculado;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setServidorVinculado(String aServidorVinculado) {
    	servidorVinculado = aServidorVinculado;
    }

 

    /**
     * Compares the key for this instance with another Parametros.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Parametros and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Servidores)) {
            return false;
        }
        Servidores that = (Servidores) other;
        if (this.getOficina() != that.getOficina()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Parametros.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Servidores)) return false;
        return this.equalKeys(other) && ((Servidores)other).equalKeys(this);
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
        i = getOficina();
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
        StringBuffer sb = new StringBuffer("[Servidor |");
        sb.append(" oficina=").append(getOficina());
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
        ret.put("oficina", Short.valueOf(getOficina()));
        return ret;
    }

}
