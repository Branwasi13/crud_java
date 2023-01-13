package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.AlumnoDTO;
import com.cursos.practicaBack.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("/api/alumnos")
    public List<AlumnoDTO> alumnos(){
        return alumnoRepository.findAll().stream().map(AlumnoDTO::new).collect(Collectors.toList());
    }
}
