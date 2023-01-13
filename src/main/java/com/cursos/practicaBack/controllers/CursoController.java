package com.cursos.practicaBack.controllers;

import com.cursos.practicaBack.dto.CursoDTO;
import com.cursos.practicaBack.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/api/cursos")
    public List<CursoDTO> cursos(){
        return cursoRepository.findAll().stream().map(CursoDTO::new).collect(Collectors.toList());
    }
}
