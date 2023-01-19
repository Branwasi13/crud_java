package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.CursoDTO;
import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;
import com.cursos.practicaBack.repositories.CursoRepository;
import com.cursos.practicaBack.repositories.CursosAlumnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursosAlumnosRepository cursosAlumnosRepository;

    @GetMapping("/api/cursos")
    public List<CursoDTO> getCursos(){
        return cursoRepository.findAll().stream().map(CursoDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/api/cursos/{id}")
    public CursoDTO getCurso(@PathVariable long id){
        return new CursoDTO(cursoRepository.findById(id));
    }

    @DeleteMapping("/api/eliminarCurso")
    public ResponseEntity<Object> eliminarCurso(@RequestParam long id){
        Curso cursoAEliminar = cursoRepository.findById(id);

        if(cursoAEliminar.getCursosAlumnos().size() > 0){
            Set<Long> cursos = cursoAEliminar.getCursosAlumnos().stream().map(CursosAlumos::getId).collect(Collectors.toSet());

            for (Long cursoId:cursos){
                cursosAlumnosRepository.deleteById(cursoId);
            }
            cursoRepository.deleteById(id);
        } else{
            cursoRepository.deleteById(id);
        }

        return new ResponseEntity<>("Curso eliminado", HttpStatus.OK);
    }
}
