package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Alumno;
import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CursosAlumnosDTO {
    private Long id;
    private Long alumnoId;
    private String nombreDelAlumno;

    public CursosAlumnosDTO() {
    }

    public CursosAlumnosDTO(CursosAlumos cursosAlumos) {
        this.id = cursosAlumos.getId();
        this.alumnoId = cursosAlumos.getAlumno().getId();
        this.nombreDelAlumno = cursosAlumos.getAlumno().getNombre();
    }

    public Long getId() {
        return id;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public String getNombreDelAlumno() {
        return nombreDelAlumno;
    }
}
