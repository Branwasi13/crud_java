package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.CursosProfesores;

public class ProfesoresCursosDTO {
    private Long id;
    private String nombreDelCurso,turno,horario;

    public ProfesoresCursosDTO() {
    }

    public ProfesoresCursosDTO(CursosProfesores cursosProfesores) {
        this.id = cursosProfesores.getId();
        this.nombreDelCurso = cursosProfesores.getCurso().getNombre();
        this.turno = cursosProfesores.getCurso().getTurno();
        this.horario = cursosProfesores.getCurso().getHorario();
    }

    public Long getId() {
        return id;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public String getTurno() {
        return turno;
    }

    public String getHorario() {
        return horario;
    }
}
