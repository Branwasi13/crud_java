package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CursoDTO {
    private Long id;
    private String nombre, turno, horario, descripcion;
    private Set<CursosAlumnosDTO> cursosAlumnosDTOS = new HashSet<>();

    private Set<CursosProfesoresDTO> cursosProfesoresDTOS = new HashSet<>();

    public CursoDTO() {
    }

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nombre = curso.getNombre();
        this.turno = curso.getTurno();
        this.horario = curso.getHorario();
        this.descripcion = curso.getDescripcion();
        this.cursosAlumnosDTOS = curso.getCursosAlumnos().stream().map(CursosAlumnosDTO::new).collect(Collectors.toSet());
        this.cursosProfesoresDTOS = curso.getProfesores().stream().map(CursosProfesoresDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTurno() {
        return turno;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<CursosAlumnosDTO> getCursosAlumnosDTOS() {
        return cursosAlumnosDTOS;
    }

    public Set<CursosProfesoresDTO> getCursosProfesoresDTOS() {
        return cursosProfesoresDTOS;
    }
}
