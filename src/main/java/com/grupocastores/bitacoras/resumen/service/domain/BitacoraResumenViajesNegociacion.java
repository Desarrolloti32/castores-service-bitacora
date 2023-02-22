package com.grupocastores.bitacoras.resumen.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bitacorasinhouse.negociaciones_clientes ")
public class BitacoraResumenViajesNegociacion {
    @Id
    @Column(name = "id_negociacion_cliente")
    private int idNegociacionCliente;
    @Column(name="id_negociacion")
    private int idNegociacion;
    @Column(name = "desc_negociacion")
    private String descripcionNegociacion;
}
