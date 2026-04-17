package com.duoc.Scoutball.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Postulaciones")

public class Postulacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postulacion_id;

    @NotBlank
    private String estado;

    
    private String mensaje;

    @NotBlank
    private int fecha_postulacion;
}
