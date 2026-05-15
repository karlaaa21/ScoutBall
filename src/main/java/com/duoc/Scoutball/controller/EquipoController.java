package com.duoc.Scoutball.controller;

import com.duoc.Scoutball.dto.EquipoDetalleDTO;
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
        System.out.println("[EquipoController] -> listarEquipos");
        return ResponseEntity.ok(equipoService.getAllEquipos());
    }

    @PostMapping
    public ResponseEntity<Equipo> agregarEquipo(@Valid @RequestBody Equipo equipo) {
        System.out.println("[EquipoController] -> agregarEquipo");
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.saveEquipo(equipo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarEquipo(@PathVariable Integer id) {
        System.out.println("[EquipoController] -> buscarEquipo id=" + id);
        Equipo equipo = equipoService.getEquipoId(id);
        if (equipo== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Integer id, @Valid @RequestBody Equipo equipo) {
        System.out.println("[EquipoController] -> actualizarEquipoid=" + id);
        equipo.setId(id);
        Equipo actualizado = equipoService.updateEquipo(equipo);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Integer id) {
        System.out.println("[EquipoController] -> eliminarEquipo id=" + id);
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalle-equipo")
    public ResponseEntity<List<EquipoDetalleDTO>> getEquipoDetalleDTO() {
        System.out.println("[EquipoController] -> equipoDetalle");
        return ResponseEntity.ok(equipoService.getEquipoDetalleDTO());
    }
    



}


