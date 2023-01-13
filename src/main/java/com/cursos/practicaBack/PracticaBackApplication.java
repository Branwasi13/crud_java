package com.cursos.practicaBack;

import com.cursos.practicaBack.models.Alumno;
import com.cursos.practicaBack.models.Curso;
import com.cursos.practicaBack.models.CursosAlumos;
import com.cursos.practicaBack.models.Profesor;
import com.cursos.practicaBack.repositories.AlumnoRepository;
import com.cursos.practicaBack.repositories.CursoRepository;
import com.cursos.practicaBack.repositories.CursosAlumnosRepository;
import com.cursos.practicaBack.repositories.ProfesorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PracticaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaBackApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (AlumnoRepository alumnoRepository, CursoRepository cursoRepository, ProfesorRepository profesorRepository, CursosAlumnosRepository cursosAlumnosRepository) {
		return (args) -> {
			Alumno alumno1 = new Alumno("julian", 35, LocalDate.of(1988,10,19),"secundario completo");
			alumnoRepository.save(alumno1);
			Profesor profesor1 = new Profesor("Pedro","Perez", "JAVA");
			profesorRepository.save(profesor1);
			Curso curso1 = new Curso ("JAVA",profesor1, "mañana", "13hs", "Aprende con el mejor curso Java de cero con las mejores prácticas POO, Java EE 9, CDI, JPA, EJB, JSF, Web Services, JAAS");
			cursoRepository.save(curso1);
			CursosAlumos cursoAlumno1 = new CursosAlumos(curso1, alumno1);
			cursosAlumnosRepository.save(cursoAlumno1);

			Profesor profesor2 = new Profesor("Susana","Cabrera", "CSS");
			profesorRepository.save(profesor2);
			Curso curso2 = new Curso ("CSS",profesor2, "tarde", "11hs", "Aprende CSS, sin conocimientos previos. Conoce todo sobre esta semántica, CSS, como dar estilos a tu sitio web.");
			cursoRepository.save(curso2);
			Alumno alumno2 = new Alumno("Franco", 21, LocalDate.of(1988,11,19),"secundario sin finalizar");
			alumnoRepository.save(alumno2);
			Alumno alumno3 = new Alumno("Marta", 28, LocalDate.of(1976,10,22),"secundario sin finalizar");
			alumnoRepository.save(alumno3);
			CursosAlumos cursoAlumno2 = new CursosAlumos(curso1, alumno2);
			cursosAlumnosRepository.save(cursoAlumno2);
			CursosAlumos cursoAlumno3 = new CursosAlumos(curso2, alumno3);
			cursosAlumnosRepository.save(cursoAlumno3);

		};
	}
}
