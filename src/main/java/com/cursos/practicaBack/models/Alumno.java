package com.cursos.practicaBack.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private Long id;
    private String nombre, historia;
    private Integer edad;
    private LocalDate fechaNacimiento;
    @OneToMany(mappedBy="alumno", fetch=FetchType.EAGER)
    private Set<CursosAlumos> cursosAlumnos = new HashSet<>();

    public Alumno() {
    }

    public Alumno(String nombre, Integer edad, LocalDate fechaNacimiento, String historia){
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.historia = historia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CursosAlumos> getCursosAlumnos() {
        return cursosAlumnos;
    }

    public void setCursosAlumnos(Set<CursosAlumos> cursosAlumnos) {
        this.cursosAlumnos = cursosAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
