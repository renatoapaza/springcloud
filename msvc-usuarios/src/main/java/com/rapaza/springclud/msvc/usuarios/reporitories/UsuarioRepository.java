package com.rapaza.springclud.msvc.usuarios.reporitories;

import com.rapaza.springclud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
