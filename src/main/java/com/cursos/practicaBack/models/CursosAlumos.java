package com.cursos.practicaBack.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class CursosAlumos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    public CursosAlumos() {
    }

    public CursosAlumos(Curso curso, Alumno alumno) {
        this.curso = curso;
        this.alumno = alumno;
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
