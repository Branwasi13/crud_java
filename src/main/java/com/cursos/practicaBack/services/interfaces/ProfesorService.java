package com.cursos.practicaBack.services.interfaces;

import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.Profesor;

import java.util.List;

public interface ProfesorService {
    public List<Profesor> getProfesores();

    public Profesor getProfesorById(long id);

    public void saveProfesor(Profesor profesor);

    public void deleteProfesorById(long id);
}
