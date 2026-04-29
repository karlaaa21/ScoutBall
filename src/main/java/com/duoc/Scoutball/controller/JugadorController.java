package com.duoc.Scoutball.controller;
import com.duoc.Scoutball.model.Jugador;
import com.duoc.Scoutball.service.JugadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> listarJugador() {
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }

    @PostMapping
    public ResponseEntity<Jugador> agregarJugador(@Valid @RequestBody Jugador jugador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorService.saveJugador(jugador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> buscarJugador(@PathVariable Integer id) {
        Jugador jugador = jugadorService.getJugadorId(id);
        if (jugador== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable Integer id, @Valid @RequestBody Jugador jugador) {
        jugador.setId(id);
        Jugador actualizado = jugadorService.updateJugador(jugador);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Integer id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }
}
