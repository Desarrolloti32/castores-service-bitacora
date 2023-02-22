package com.grupocastores.bitacoras.resumen.DTO;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ahorarioOperador")
public class HorarioOperador implements Serializable{
    

    @Id
    private int idunidad;
    private int tipounidad;
    @Id
    private int idoperador;
    private int idesquemapago;
    private String esquemapago;
    private int tipooperador;
    private int ordenoperador;
    private String horaentrada;
    private String horasalida;
    private String fechamod;
    private String horamod;
    private int idpersonalmod;
    private int idoperadoresunidad;
    private String nombre;
    @Id
    private int estatus;

}
