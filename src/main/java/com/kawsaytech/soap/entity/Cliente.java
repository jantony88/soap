package com.kawsaytech.soap.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {
    private String clienteId;
    private String contrasena;
    private boolean estado;
    private String message;
}
