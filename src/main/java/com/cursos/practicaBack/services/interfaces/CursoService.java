package com.cursos.practicaBack.services.interfaces;

import com.cursos.practicaBack.models.Curso;

import java.util.List;

public interface CursoService {

    public List<Curso> getCursos();

    public Curso getCursoById(long id);

    public void saveCurso(Curso curso);

    public void deleteCursoById(long id);
}
