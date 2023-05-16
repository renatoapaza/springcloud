package com.rapaza.springclud.msvc.usuarios.msvcusuarios.reporitories;

import com.rapaza.springclud.msvc.usuarios.msvcusuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
