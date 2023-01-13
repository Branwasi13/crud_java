package com.cursos.practicaBack.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nombre, turno, horario, descripcion;
    @OneToOne
    private Profesor profesor;
    @OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
    private Set<CursosAlumos> cursosAlumnos = new HashSet<>();

    public Curso() {
    }

    public Curso(String nombre,Profesor profesor, String turno, String horario, String descripcion) {
        this.nombre = nombre;
        this.turno = turno;
        this.horario = horario;
        this.profesor = profesor;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public Set<CursosAlumos> getCursosAlumnos() {
        return cursosAlumnos;
    }

    public void setCursosAlumnos(Set<CursosAlumos> cursosAlumnos) {
        this.cursosAlumnos = cursosAlumnos;
    }


    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
