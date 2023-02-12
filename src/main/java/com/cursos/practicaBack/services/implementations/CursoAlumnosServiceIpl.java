package com.cursos.practicaBack.services.implementations;

import com.cursos.practicaBack.repositories.CursosAlumnosRepository;
import com.cursos.practicaBack.services.interfaces.CursoAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoAlumnosServiceIpl implements CursoAlumnosService {
    @Autowired
    private CursosAlumnosRepository cursosAlumnosRepository;

    @Override
    public void deleteCursoAlumnosById(long id){
        cursosAlumnosRepository.deleteById(id);
    }
}
