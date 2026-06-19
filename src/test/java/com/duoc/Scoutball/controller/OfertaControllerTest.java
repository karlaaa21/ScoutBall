package com.duoc.Scoutball.controller;
import com.duoc.Scoutball.model.Oferta;
import com.duoc.Scoutball.model.Equipo;
import com.duoc.Scoutball.service.OfertaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OfertaControllerTest {
  @Mock
  private OfertaService ofertaService;
  @InjectMocks
  private OfertaController ofertaController;
  @Test

 
  void crearOferta_retorna201_cuandoExisteOferta() {


  
    // Vamos a verificar que el método agregarJugador del controlador funciona correctamente
    // Para ello crearfemos un libro con un autor válido y simularemos el comportamiento del servicio
    Equipo equipo = Equipo.builder()
   .id(1) .nombre_equipo("Real madrid") .ubicacion("Madrid") .pais("España") .liga("La liga") .tecnico("Carlo Ancelotti") .titulos(36) .correo("kjasjkasja") .numero_tlf("+34910247520") .interes("buenos") .build();
    Oferta oferta = Oferta.builder()
    .id(1) .fecha_oferta(20260514) .fecha_limite_oferta(20260614) .posicion("Defensa Central") .descripcion("Se busca jugador con buen juego aéreo y liderazgo.") .correo("scouting@club.com") .numero_telefonico("+56987654321") .salario("1500 USD") .build();
    // ""Simulamos""el comportamiento del servicio (mock):
    // Así evitamos acceder a base de datos en una prueba unitaria.
    // Cuando el servicio intente guardar el libro, le decimos que devuelva el mismo libro (como si lo hubiera guardado).
    // Cuando el controlador invoque saveLibro con ese libro, Mockito devolverá ese mismo libro al instante, sin ejecutar lógica real, sin repositorio, sin DB.
    when(ofertaService.saveOferta(oferta)).thenReturn(oferta);
    // Llamamos al método del controlador que queremos probar.
    // El resultado es un ResponseEntity<Jugador> con estado HTTP y cuerpo.
    var respuesta = ofertaController.agregarOferta(oferta);
    // Para que el test sea completo, verificamos varios aspectos de la respuesta:
    // 1) La respuesta no debe ser nula.
    assertNotNull(respuesta);
    // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
    // 3) El cuerpo de la respuesta debe existir.
    var body = respuesta.getBody();
    assertNotNull(body);
    // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
    assertEquals("Defensa Central", body.getPosicion());
    }
}



















