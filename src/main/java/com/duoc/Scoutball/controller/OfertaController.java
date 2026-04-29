package com.duoc.Scoutball.controller;

import com.duoc.Scoutball.model.Oferta;
import com.duoc.Scoutball.service.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/oferta")
public class OfertaController {
    @Autowired
    private OfertaService ofertaService;

    @GetMapping
    public ResponseEntity<List<Oferta>> listarOferta() {
        return ResponseEntity.ok(ofertaService.getAllOferta());
    }

    @PostMapping
    public ResponseEntity<Oferta> agregarOferta(@Valid @RequestBody Oferta oferta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertaService.saveOferta(oferta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> buscarOferta(@PathVariable Integer id) {
        Oferta oferta = ofertaService.getOfertaId(id);
        if (oferta== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oferta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oferta> actualizarOferta(@PathVariable Integer id, @Valid @RequestBody Oferta oferta) {
        oferta.setId(id);
        Oferta actualizado = ofertaService.updateOferta(oferta);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOferta(@PathVariable Integer id) {
        ofertaService.deleteOferta(id);
        return ResponseEntity.noContent().build();
    }
}
