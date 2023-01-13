package com.cursos.practicaBack.repositories;

import com.cursos.practicaBack.models.CursosAlumos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursosAlumnosRepository extends JpaRepository<CursosAlumos, Long> {
}
