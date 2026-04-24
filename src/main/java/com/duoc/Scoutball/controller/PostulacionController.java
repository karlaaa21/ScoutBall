package com.duoc.Scoutball.controller;

import com.duoc.Scoutball.model.Postulacion;
import com.duoc.Scoutball.service.PostulacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/postulacion")
public class PostulacionController {
    @Autowired
    private PostulacionService postulacionService;

    @GetMapping
    public ResponseEntity<List<Postulacion>> listarPostulacion() {
        return ResponseEntity.ok(postulacionService.getAllPostulacion());
    }

    @PostMapping
    public ResponseEntity<Postulacion> agregarPostulacion(@Valid @RequestBody Postulacion postulacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postulacionService.savePostulacion(postulacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> buscarPostulacion(@PathVariable Integer id) {
        Postulacion postulacion = postulacionService.getPostulacionId(id);
        if (postulacion== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postulacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postulacion> actualizarPostulacion(@PathVariable Integer id, @Valid @RequestBody Postulacion postulacion) {
        postulacion.setPostulacion_id(id);
        Postulacion actualizado = postulacionService.updatePostulacion(postulacion);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPostulacion(@PathVariable Integer id) {
        postulacionService.deletePostulacion(id);
        return ResponseEntity.noContent().build();
    }
}
