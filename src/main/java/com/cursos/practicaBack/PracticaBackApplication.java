package com.cursos.practicaBack;

import com.cursos.practicaBack.models.*;
import com.cursos.practicaBack.repositories.*;
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
	public CommandLineRunner initData (AlumnoRepository alumnoRepository, CursoRepository cursoRepository, ProfesorRepository profesorRepository, CursosAlumnosRepository cursosAlumnosRepository, CursosProfesoresRepository cursosProfesoresRepository) {
		return (args) -> {
			Alumno alumno1 = new Alumno("julian", 35, LocalDate.of(1988,10,19),"secundario completo");
			alumnoRepository.save(alumno1);
			Alumno alumno2 = new Alumno("Franco", 21, LocalDate.of(1988,11,19),"secundario sin finalizar");
			alumnoRepository.save(alumno2);
			Alumno alumno3 = new Alumno("Marta", 28, LocalDate.of(1976,10,22),"secundario sin finalizar");
			alumnoRepository.save(alumno3);

			Profesor profesor1 = new Profesor("Pedro","Perez");
			profesorRepository.save(profesor1);
			Profesor profesor2 = new Profesor("Susana","Cabrera");
			profesorRepository.save(profesor2);
			Profesor profesor3 = new Profesor("John","Stone");
			profesorRepository.save(profesor3);
			Profesor profesor4 = new Profesor("lionel","messi");
			profesorRepository.save(profesor4);

			Curso curso1 = new Curso ("JAVA", "tarde", "13hs", "Aprende con el mejor curso Java de cero con las mejores prácticas POO, Java EE 9, CDI, JPA, EJB, JSF, Web Services, JAAS");
			cursoRepository.save(curso1);
			Curso curso2 = new Curso ("CSS", "mañana", "11hs", "Aprende CSS, sin conocimientos previos. Conoce todo sobre esta semántica, CSS, como dar estilos a tu sitio web.");
			cursoRepository.save(curso2);
			Curso curso3 = new Curso ("HTML", "mañana", "09hs", "Aprende HTML5. Conoce todo acerca del lenguaje de marcado HTML, sin conocimientos previos, desde 0 y paso a paso.");
			cursoRepository.save(curso3);
			Curso curso4 = new Curso ("JavaScript", "tarde", "16hs", "Dominá el lenguaje de la web de una manera simple y concisa para desarrollar y darle vida a la web que quieras.");
			cursoRepository.save(curso4);

			CursosProfesores cursosProfesores1 = new CursosProfesores(curso1, profesor1);
			cursosProfesoresRepository.save(cursosProfesores1);
			CursosProfesores cursosProfesores2 = new CursosProfesores(curso2, profesor2);
			cursosProfesoresRepository.save(cursosProfesores2);
			CursosProfesores cursosProfesores3 = new CursosProfesores(curso3, profesor3);
			cursosProfesoresRepository.save(cursosProfesores3);
			CursosProfesores cursosProfesores4 = new CursosProfesores(curso4, profesor4);
			cursosProfesoresRepository.save(cursosProfesores4);


			CursosAlumos cursoAlumno1 = new CursosAlumos(curso1, alumno1);
			cursosAlumnosRepository.save(cursoAlumno1);
			CursosAlumos cursoAlumno2 = new CursosAlumos(curso1, alumno2);
			cursosAlumnosRepository.save(cursoAlumno2);
			CursosAlumos cursoAlumno3 = new CursosAlumos(curso2, alumno3);
			cursosAlumnosRepository.save(cursoAlumno3);

		};
	}
}
