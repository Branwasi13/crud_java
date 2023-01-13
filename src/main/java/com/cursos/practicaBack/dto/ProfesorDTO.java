package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Profesor;

public class ProfesorDTO {
    private Long id;
    private String nombreProfesor, apellidoProfesor, nombreCurso;
    private String pija;

    public ProfesorDTO() {
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.nombreProfesor = profesor.getNombreProfesor();
        this.apellidoProfesor = profesor.getApellidoProfesor();
        this.nombreCurso = profesor.getNombreCurso();
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

    public String getNombreCurso() {
        return nombreCurso;
    }
}
