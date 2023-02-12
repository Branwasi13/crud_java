package com.cursos.practicaBack.repositories;

import com.cursos.practicaBack.models.CursosProfesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CursosProfesoresRepository extends JpaRepository<CursosProfesores, Long> {
}
