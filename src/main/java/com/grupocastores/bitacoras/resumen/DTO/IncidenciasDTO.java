package com.grupocastores.bitacoras.resumen.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(shape= JsonFormat.Shape.ARRAY)

public class IncidenciasDTO  {
    @JsonRawValue
    private String image;
}
