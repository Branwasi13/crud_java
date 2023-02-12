package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.AlumnoDTO;
import com.cursos.practicaBack.models.Alumno;
import com.cursos.practicaBack.models.CursosAlumos;
import com.cursos.practicaBack.repositories.CursosAlumnosRepository;
import com.cursos.practicaBack.services.interfaces.AlumnoService;
import com.cursos.practicaBack.services.interfaces.CursoProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CursoProfesoresService cursoProfesoresService;

    @GetMapping("/api/alumnos")
    public List<AlumnoDTO> alumnos(){
        return alumnoService.getAlumnos().stream().map(AlumnoDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/api/alumnos/{id}")
    public AlumnoDTO getAlumno (@PathVariable long id){
        return new AlumnoDTO(alumnoService.getAlumnoById(id));
    }

    @PostMapping("/api/registrarAlumno")
    public ResponseEntity<Object> registrarAlumno(
            @RequestParam String nombre, @RequestParam String historia, @RequestParam Integer edad, @RequestParam LocalDate fechaNacimiento) {

        if(nombre.isEmpty() || historia.isEmpty() || edad == null || fechaNacimiento == null){
            return new ResponseEntity<>("No se permiten campos vacios", HttpStatus.FORBIDDEN);
        }

        Alumno alumno = new Alumno(nombre, edad, fechaNacimiento, historia);
        alumnoService.saveAlumno(alumno);

        return new ResponseEntity<>("Alumno registrado", HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/editarNombre")
    public ResponseEntity<Object> modificarNombreAlumno(@RequestParam String nombre, @RequestParam long id){
        Alumno alumnoAModificar = alumnoService.getAlumnoById(id);

        if (nombre.isEmpty()){
            return new ResponseEntity<>("Por favor, ingrese el nombre antes de modificar.", HttpStatus.FORBIDDEN);
        }

        alumnoAModificar.setNombre(nombre);
        alumnoService.saveAlumno(alumnoAModificar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/eliminarAlumno")
    public ResponseEntity<Object> eliminarAlumno(@RequestParam long id){
        Alumno alumnoAEliminar = alumnoService.getAlumnoById(id);

        if (alumnoAEliminar == null){
            return new ResponseEntity<>("El alumno no existe", HttpStatus.FORBIDDEN);
        }
        if(alumnoAEliminar.getCursosAlumnos().size() > 0){
            Set<Long> alumnos = alumnoAEliminar.getCursosAlumnos().stream().map(CursosAlumos::getId).collect(Collectors.toSet());

            for (Long ids:alumnos){
                cursoProfesoresService.deleteCursoProfesoresById(ids);
            }
            alumnoService.deleteAlumno(alumnoAEliminar);
        }
        else {
            alumnoService.deleteAlumno(alumnoAEliminar);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
