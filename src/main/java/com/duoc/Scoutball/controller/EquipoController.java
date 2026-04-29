package com.duoc.Scoutball.controller;

import com.duoc.Scoutball.model.Equipo;
import com.duoc.Scoutball.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/equipo")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipo() {
        return ResponseEntity.ok(equipoService.getAllEquipos());
    }

    @PostMapping
    public ResponseEntity<Equipo> agregarEquipo(@Valid @RequestBody Equipo equipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.saveEquipo(equipo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarEquipo(@PathVariable Integer id) {
        Equipo equipo = equipoService.getEquipoId(id);
        if (equipo== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Integer id, @Valid @RequestBody Equipo equipo) {
        equipo.setId(id);
        Equipo actualizado = equipoService.updateEquipo(equipo);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Integer id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }
}


