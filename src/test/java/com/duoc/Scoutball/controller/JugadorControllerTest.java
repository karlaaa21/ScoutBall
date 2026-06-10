package com.duoc.Scoutball.controller;

import com.duoc.Scoutball.model.Jugador;
import com.duoc.Scoutball.model.Equipo;
import com.duoc.Scoutball.service.JugadorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JugadorControllerTest {
  @Mock
  private JugadorService jugadorService;
  @InjectMocks
  private JugadorController jugadorController;
  @Test
  void crearJugador_retorna201_cuandoExisteJugador() {
    // Vamos a verificar que el método agregarLibro del controlador funciona correctamente
    // Para ello crearfemos un libro con un autor válido y simularemos el comportamiento del servicio
    Equipo equipo = new Equipo(1,"Real Madrid C.F.","Madrid","España","LaLiga","Carlo Ancelotti",36,"contacto@realmadrid.com","+34913984300","Búsqueda de talentos jóvenes en Sudamérica");
    Jugador jugador = new Jugador(1,"Cristiano","Ronaldo","Do santos","Aveiro","Portuguesa","1985-02-05","Cristiano.Ronaldo@example.com","+351845944984","Funchal, Madeira , portugal","Delantero con amplia experiencia internacional y gran regate.","Extremo / Delantero",1.87,75.0,"Masculino","ambidiestro","Jorge Mendes","All nassar");
    // ""Simulamos""el comportamiento del servicio (mock):
    // Así evitamos acceder a base de datos en una prueba unitaria.
    // Cuando el servicio intente guardar el libro, le decimos que devuelva el mismo libro (como si lo hubiera guardado).
    // Cuando el controlador invoque saveLibro con ese libro, Mockito devolverá ese mismo libro al instante, sin ejecutar lógica real, sin repositorio, sin DB.
    when(jugadorService.saveJugador(jugador)).thenReturn(jugador);
    // Llamamos al método del controlador que queremos probar.
    // El resultado es un ResponseEntity<Jugador> con estado HTTP y cuerpo.
    var respuesta = jugadorController.agregarJugador(jugador);
    // Para que el test sea completo, verificamos varios aspectos de la respuesta:
    // 1) La respuesta no debe ser nula.
    assertNotNull(respuesta);
    // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
    // 3) El cuerpo de la respuesta debe existir.
    var body = respuesta.getBody();
    assertNotNull(body);
    // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
    assertEquals("Cristiano", body.getPnombre());
    }
}
