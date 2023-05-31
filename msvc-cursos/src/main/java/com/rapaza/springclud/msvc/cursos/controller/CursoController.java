package com.rapaza.springclud.msvc.cursos.controller;

import com.rapaza.springclud.msvc.cursos.entity.Curso;
import com.rapaza.springclud.msvc.cursos.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Curso> o = cursoService.porId(id);
        if (o.isPresent())
            return ResponseEntity.ok(o.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> guadar(@RequestBody Curso curso) {
        Curso cursodb = cursoService.guardar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursodb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> o = cursoService.porId(id);
        if (o.isPresent()) {
            Curso cursodb = o.get();
            cursodb.setNombre(curso.getNombre());

            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardar(cursodb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Curso> o = cursoService.porId(id);
        if (o.isPresent()) {
            cursoService.eliminar(o.get().getId());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
