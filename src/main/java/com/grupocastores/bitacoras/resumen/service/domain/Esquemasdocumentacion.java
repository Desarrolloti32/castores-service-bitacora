package com.grupocastores.bitacoras.resumen.service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

/**
 * Esquemasdocumentacion: Entidad para la tabla esquemas.
 * 
 * @version 0.0.1
 * @author Moises Lopez Arrona [moisesarrona]
 * @date 2022-06-14
 */
@Data
@Entity(name="esquemas")
@IdClass(Esquemasdocumentacion.EsquemasdocumentacionId.class)
public class Esquemasdocumentacion implements Serializable {
	
	public static class EsquemasdocumentacionId implements Serializable {
		
		private static final long serialVersionUID = 3496499330239483448L;

		public EsquemasdocumentacionId() {
			super();
		}
		
		int idEsquema;
		
	}

	private static final long serialVersionUID = 2444733238193535922L;

	protected static final String PK = "idEsquema";

    @Id
    @Column(unique=true, nullable=false, precision=11, name="id_esquema")
    private int idEsquema;
    
    @Column(nullable=false, length=80, name="nombre_esquema")
    private String nombreEsquema;
    
    @Column(nullable=false, precision=1)
    private int estatus;

    /** Default constructor. */
    public Esquemasdocumentacion() {
        super();
    }

}
