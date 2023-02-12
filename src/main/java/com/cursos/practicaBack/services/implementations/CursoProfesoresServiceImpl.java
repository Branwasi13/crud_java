package com.cursos.practicaBack.services.implementations;

import com.cursos.practicaBack.repositories.CursosProfesoresRepository;
import com.cursos.practicaBack.services.interfaces.CursoAlumnosService;
import com.cursos.practicaBack.services.interfaces.CursoProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoProfesoresServiceImpl implements CursoProfesoresService {
    @Autowired
    private CursosProfesoresRepository cursosProfesoresRepository;

    @Override
    public void deleteCursoProfesoresById(long id){
        cursosProfesoresRepository.deleteById(id);
    }
}
