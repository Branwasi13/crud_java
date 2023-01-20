package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.Profesor;

import java.util.List;
import java.util.stream.Collectors;

public class ProfesorDTO {
    private Long id;
    private String nombreProfesor, apellidoProfesor;

    private List<String> nombreCurso;
    public ProfesorDTO() {
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.nombreProfesor = profesor.getNombreProfesor();
        this.apellidoProfesor = profesor.getApellidoProfesor();
        this.nombreCurso = profesor.getCursos().stream().map(Curso::getNombre).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public List<String> getNombreCurso() {
        return nombreCurso;
    }
}
