package com.cursos.practicaBack.services.implementations;

import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.repositories.CursoRepository;
import com.cursos.practicaBack.services.interfaces.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getCursos (){
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(long id){
        return cursoRepository.findById(id);
    }

    @Override
    public void saveCurso(Curso curso){
        cursoRepository.save(curso);
    }

    @Override
    public void deleteCursoById(long id){
        cursoRepository.deleteById(id);
    }
}
