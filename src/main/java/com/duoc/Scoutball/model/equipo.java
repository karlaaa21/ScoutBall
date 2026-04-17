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
@Table(name="equipos")
public class equipo {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipo_id;

    @NotBlank
    private String nombre_equipo;

    @NotBlank
    private String ubicacion;

    @NotBlank
    private String pais;

    @NotBlank
    private String liga;

    @NotBlank
    private String tecnico;

    private Integer titulos;

    @NotBlank
    private String correo;

    @NotBlank
    private String numero_tlf;

    private String  interes;


}
