package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.CursosProfesores;
import com.cursos.practicaBack.models.Profesor;

public class CursosProfesoresDTO {
    private Long id;
    private String nombreDelProfesor, apellidoDelProfesor;

    public CursosProfesoresDTO() {
    }

    public CursosProfesoresDTO(CursosProfesores cursosProfesores) {
        this.id = cursosProfesores.getProfesor().getId();
        this.nombreDelProfesor = cursosProfesores.getProfesor().getNombreProfesor();
        this.apellidoDelProfesor = cursosProfesores.getProfesor().getApellidoProfesor();
    }

    public Long getId() {
        return id;
    }

    public String getNombreDelProfesor() {
        return nombreDelProfesor;
    }

    public String getApellidoDelProfesor() {
        return apellidoDelProfesor;
    }
}
