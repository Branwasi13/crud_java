package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.CursoDTO;
import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;
import com.cursos.practicaBack.models.Profesor;
import com.cursos.practicaBack.repositories.CursoRepository;
import com.cursos.practicaBack.repositories.CursosAlumnosRepository;
import com.cursos.practicaBack.repositories.ProfesorRepository;
import com.cursos.practicaBack.services.interfaces.CursoAlumnosService;
import com.cursos.practicaBack.services.interfaces.CursoService;
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
    private CursoService cursoService;
    @Autowired
    private CursoAlumnosService cursoAlumnosService;

    @GetMapping("/api/cursos")
    public List<CursoDTO> getCursos(){
        return cursoService.getCursos().stream().map(CursoDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/api/cursos/{id}")
    public CursoDTO getCurso(@PathVariable long id){
        return new CursoDTO(cursoService.getCursoById(id));
    }

    @PostMapping("/api/crearCurso")
    public ResponseEntity<Object> crearCurso(
            @RequestParam String nombre, @RequestParam String turno, @RequestParam String horario, @RequestParam String descripcion) {
        if(nombre.isEmpty() || turno.isEmpty() || horario.isEmpty() || descripcion.isEmpty()){
            return new ResponseEntity<>("todos los campos tienen que estar llenos para crear un curso" ,HttpStatus.FORBIDDEN);
        }
        Curso curso = new Curso(nombre, turno , horario, descripcion);
        cursoService.saveCurso(curso);
        return new ResponseEntity<>("curso creado", HttpStatus.OK);
    }
    @DeleteMapping("/api/eliminarCurso")
    public ResponseEntity<Object> eliminarCurso(@RequestParam long id){
        Curso cursoAEliminar = cursoService.getCursoById(id);

        if(cursoAEliminar.getCursosAlumnos().size() > 0){
            Set<Long> cursos = cursoAEliminar.getCursosAlumnos().stream().map(CursosAlumos::getId).collect(Collectors.toSet());
            for (Long cursoId:cursos){
                cursoAlumnosService.deleteCursoAlumnosById(cursoId);
            }
            cursoService.deleteCursoById(id);
        } else{
            cursoService.deleteCursoById(id);
        }

        return new ResponseEntity<>("Curso eliminado", HttpStatus.OK);
    }
}
