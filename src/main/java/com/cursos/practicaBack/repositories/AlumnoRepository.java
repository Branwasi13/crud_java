package com.cursos.practicaBack.repositories;

import com.cursos.practicaBack.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
