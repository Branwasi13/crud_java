package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.CursosAlumos;

public class AlumnosCursosDTO {
    private Long id;
    private Long cursoId;
    private String nombreDelCurso, horario, turno;

    public AlumnosCursosDTO() {
    }

    public AlumnosCursosDTO(CursosAlumos cursosAlumos) {
        this.id = cursosAlumos.getId();
        this.cursoId = cursosAlumos.getCurso().getId();
        this.nombreDelCurso = cursosAlumos.getCurso().getNombre();
        this.horario = cursosAlumos.getCurso().getHorario();
        this.turno = cursosAlumos.getCurso().getTurno();
    }


    public Long getId() {
        return id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public String getHorario() {
        return horario;
    }

    public String getTurno() {
        return turno;
    }
}
