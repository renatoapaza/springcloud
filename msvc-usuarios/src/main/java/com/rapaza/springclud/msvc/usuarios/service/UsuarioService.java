package com.rapaza.springclud.msvc.usuarios.service;

import com.rapaza.springclud.msvc.usuarios.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    List<Usuario> listarPorIds(Iterable<Long> ids);

    Usuario guadar(Usuario usuario);

    void eliminar(Long id);

    Optional<Usuario> porEmail(String email);

    boolean existePorEmail(String email);
}
