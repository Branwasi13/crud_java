package com.cursos.practicaBack.dto;

import com.cursos.practicaBack.models.Alumno;
import com.cursos.practicaBack.models.CursosAlumos;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AlumnoDTO {
    private Long id;
    private String nombre, historia;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private Set<AlumnosCursosDTO> alumnosCursos = new HashSet<>();

    public AlumnoDTO() {
    }

    public AlumnoDTO(Alumno alumno) {
        this.id = alumno.getId();
        this.nombre = alumno.getNombre();
        this.historia = alumno.getHistoria();
        this.edad = alumno.getEdad();
        this.fechaNacimiento = alumno.getFechaNacimiento();
        this.alumnosCursos = alumno.getCursosAlumnos().stream().map(AlumnosCursosDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public Integer getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Set<AlumnosCursosDTO> getAlumnosCursos() {
        return alumnosCursos;
    }
}
