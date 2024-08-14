package com.kawsaytech.soap.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre requerido")
    private String nombre;
    @NotBlank(message = "Apellido requerido")
    private String apellido;
    private String genero;

    @Column(unique = true)
    @NotBlank(message = "Numero de cedula requerido")
    private String identificacion;

    private String direccion;
    private String telefono;
}
