package com.rapaza.springclud.msvc.usuarios.controllers;

import com.rapaza.springclud.msvc.usuarios.entity.Usuario;
import com.rapaza.springclud.msvc.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Usuario> usuarioOptional =  usuarioService.porId(id);
        if(usuarioOptional.isPresent())
            return ResponseEntity.ok(usuarioOptional.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario guardar(@RequestBody Usuario usuario){
        return usuarioService.guadar(usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuario,@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioService.porId(id);
        if(usuarioOptional.isPresent()){
            Usuario usuarioDb = usuarioOptional.get();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());

            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guadar(usuarioDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Usuario> o = usuarioService.porId(id);
        if(o.isPresent()){
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
