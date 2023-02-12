package com.cursos.practicaBack.services.implementations;

import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.Profesor;
import com.cursos.practicaBack.repositories.ProfesorRepository;
import com.cursos.practicaBack.services.interfaces.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getProfesores(){
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getProfesorById(long id){
        return profesorRepository.findById(id);
    }

    @Override
    public void saveProfesor(Profesor profesor){
        profesorRepository.save(profesor);
    }

    @Override
    public void deleteProfesorById(long id){
        profesorRepository.deleteById(id);
    }
}
