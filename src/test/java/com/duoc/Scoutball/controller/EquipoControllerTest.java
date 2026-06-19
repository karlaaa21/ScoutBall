package com.duoc.Scoutball.controller;
import com.duoc.Scoutball.model.Jugador;
import com.duoc.Scoutball.model.Equipo;
import com.duoc.Scoutball.service.EquipoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EquipoControllerTest {
@Mock
  private EquipoService equipoService;
  @InjectMocks
  private EquipoController equipoController;
  @Test

  void crearEquipo_retorna201_cuandoExisteEquipo() {
    // Vamos a verificar que el método agregarJugador del controlador funciona correctamente
    // Para ello crearfemos un libro con un autor válido y simularemos el comportamiento del servicio
    Jugador jugador = Jugador.builder()
    .id(1) .pnombre("Cristiano") .snombre("Ronaldo") .appaterno("Do santos") .apmaterno("Aveiro") .nacionalidad("Portuguesa") .fecha_nacimiento("1985-02-05") .correo("akjsakjskjaskj") .numero_tlf("+251420304") .direccion("portugal") .sobre_mi("akjsjas") .posicion("delantero") .altura(1.80f) .peso(80.0f) .sexo("Masculino") .build();
    Equipo equipo = Equipo.builder()
   .id(1) .nombre_equipo("Real madrid") .ubicacion("Madrid") .pais("España") .liga("La liga") .tecnico("Carlo Ancelotti") .titulos(36) .correo("kjasjkasja") .numero_tlf("+34910247520") .interes("buenos") .build();
    // Así evitamos acceder a base de datos en una prueba unitaria.
    // Cuando el servicio intente guardar el libro, le decimos que devuelva el mismo libro (como si lo hubiera guardado).
    // Cuando el controlador invoque saveLibro con ese libro, Mockito devolverá ese mismo libro al instante, sin ejecutar lógica real, sin repositorio, sin DB.
    when(equipoService.saveEquipo(equipo)).thenReturn(equipo);
    // Llamamos al método del controlador que queremos probar.
    // El resultado es un ResponseEntity<Jugador> con estado HTTP y cuerpo.
    var respuesta = equipoController.agregarEquipo(equipo);
    // Para que el test sea completo, verificamos varios aspectos de la respuesta:
    // 1) La respuesta no debe ser nula.
    assertNotNull(respuesta);
    // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
    // 3) El cuerpo de la respuesta debe existir.
    var body = respuesta.getBody();
    assertNotNull(body);
    // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
    assertEquals("Real madrid", body.getNombre_equipo());
    }
}
