package com.duoc.Scoutball.model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Postulaciones")

public class Postulacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String estado;
    
    private String mensaje;

    @NotBlank
    private int fecha_postulacion;

    @ManyToOne
    private List<Jugador> jugador;

    @ManyToOne 
    private List<Equipo> equipo;

}
