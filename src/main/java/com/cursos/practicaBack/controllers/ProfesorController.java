package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.ProfesorDTO;
import com.cursos.practicaBack.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("/api/profesores")
    public List<ProfesorDTO> profesores(){
        return profesorRepository.findAll().stream().map(ProfesorDTO::new).collect(Collectors.toList());
    }
}
