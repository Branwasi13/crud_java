package com.cursos.practicaBack.services.interfaces;

import com.cursos.practicaBack.models.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> getAlumnos();

    public Alumno getAlumnoById(long id);

    public void saveAlumno(Alumno alumno);

    public void deleteAlumno(Alumno alumno);

}
