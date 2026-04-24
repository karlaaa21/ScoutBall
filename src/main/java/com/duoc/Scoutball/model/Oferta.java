package com.duoc.Scoutball.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="Ofertas")

public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oferta_id;

    @NotBlank
    private int fecha_oferta;

    @NotBlank
    private int fecha_limite_oferta;

    @NotBlank
    private String posicion;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String correo;

    @NotBlank
    private String numero_telefonico;

    @NotNull
    private String salario;

    @OneToOne
    private Jugador jugador;

    @ManyToOne
    private List<Equipo>equipo;
}
