package com.cursos.practicaBack.repositories;


import com.cursos.practicaBack.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoRepository extends JpaRepository <Curso,Long> {
    Curso findById(long id);
}
