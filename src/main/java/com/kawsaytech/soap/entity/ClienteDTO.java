package com.kawsaytech.soap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {
    private String identificacion;
    private String datos;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private boolean estado;
    private String message;

}
