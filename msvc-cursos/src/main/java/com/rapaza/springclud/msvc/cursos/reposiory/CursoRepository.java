package com.rapaza.springclud.msvc.cursos.reposiory;

import com.rapaza.springclud.msvc.cursos.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
