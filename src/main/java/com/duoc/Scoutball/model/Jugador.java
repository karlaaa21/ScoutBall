package com.duoc.Scoutball.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jugadores")

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jugador_id;

    @NotBlank
    private String pnombre;

    @NotBlank
    private String snombre;

    @NotBlank
    private String appaterno;

    @NotBlank
    private String apmaterno;

    @NotBlank
    private String nacionalidad;

    @NotNull
    private Integer fecha_nacimiento;

    @NotBlank
    private String correo;

    @NotBlank
    private String numero_tlf;

    @NotBlank
    private String direccion;

    @NotBlank
    private String  sobre_mi;

    @NotBlank
    private String posicion;

    @NotBlank
    private float altura;

    @NotBlank
    private Float peso;

    @NotBlank
    private String pierna_habil;

    private String representante;

    private String equipo;






}
