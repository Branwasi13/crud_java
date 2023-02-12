package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Profesor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfesorDTO {
    private Long id;
    private String nombreProfesor, apellidoProfesor;

    private Set<ProfesoresCursosDTO> cursos = new HashSet<>();
    public ProfesorDTO() {
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.nombreProfesor = profesor.getNombreProfesor();
        this.apellidoProfesor = profesor.getApellidoProfesor();
        this.cursos = profesor.getCursos().stream().map(ProfesoresCursosDTO::new).collect(Collectors.toSet());
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

    public Set<ProfesoresCursosDTO> getCursos() {
        return cursos;
    }
}
