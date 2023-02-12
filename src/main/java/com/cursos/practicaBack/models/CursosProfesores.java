package com.cursos.practicaBack.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class CursosProfesores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    public CursosProfesores() {
    }

    public CursosProfesores(Curso curso, Profesor profesor) {
        this.curso = curso;
        this.profesor = profesor;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
