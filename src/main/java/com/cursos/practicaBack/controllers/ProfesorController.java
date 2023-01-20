package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.ProfesorDTO;
import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;
import com.cursos.practicaBack.models.Profesor;
import com.cursos.practicaBack.repositories.CursoRepository;
import com.cursos.practicaBack.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/api/profesores")
    public List<ProfesorDTO> profesores(){
        return profesorRepository.findAll().stream().map(ProfesorDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/api/crearProfesor")
    public ResponseEntity<Object> crearProfesor(
            @RequestParam String nombreDelProfesor, @RequestParam String apellidoDelProfesor) {

        if(nombreDelProfesor.isEmpty() || apellidoDelProfesor.isEmpty()){
            return new ResponseEntity<>("los campos no pueden estar vacios para crear un profesor",HttpStatus.FORBIDDEN);
        }
        Profesor profesor = new Profesor(nombreDelProfesor, apellidoDelProfesor);
        profesorRepository.save(profesor);
        return new ResponseEntity<>("profesor creado", HttpStatus.OK);
    }

    @DeleteMapping("/api/eliminarProfesor")
    public ResponseEntity<Object> eliminarProfesor(@RequestParam long id){

        Profesor profesorEliminar = profesorRepository.findById(id);

        if(profesorEliminar == null){
            return new ResponseEntity<>("no se encontro al profesor que quiere eliminar",HttpStatus.FORBIDDEN);
        }


        return new ResponseEntity<>("Profesor eliminado", HttpStatus.OK);
    }
}
