package com.rapaza.springclud.msvc.usuarios.msvcusuarios.service;

import com.rapaza.springclud.msvc.usuarios.msvcusuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    Usuario guadar(Usuario usuario);

    void eliminar(Long id);
}
