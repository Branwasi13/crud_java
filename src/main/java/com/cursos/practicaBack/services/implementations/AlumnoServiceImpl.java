package com.cursos.practicaBack.services.implementations;

import com.cursos.practicaBack.models.Alumno;
import com.cursos.practicaBack.repositories.AlumnoRepository;
import com.cursos.practicaBack.services.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAlumnos(){
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getAlumnoById(long id){
        return alumnoRepository.findById(id);
    }

    @Override
    public void saveAlumno(Alumno alumno){
        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(Alumno alumno){
        alumnoRepository.delete(alumno);
    }
}
