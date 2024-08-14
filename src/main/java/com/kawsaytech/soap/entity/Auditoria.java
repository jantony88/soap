package com.kawsaytech.soap.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accion;
    private String fecha;
    private String usuario;
}
