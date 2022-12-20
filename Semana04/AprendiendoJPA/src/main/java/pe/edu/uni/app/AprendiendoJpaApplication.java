package pe.edu.uni.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.uni.app.domain.Estudiante;
import pe.edu.uni.app.domain.Organizacion;
import pe.edu.uni.app.domain.Proyecto;
import pe.edu.uni.app.repository.OrganizacionRepository;
import pe.edu.uni.app.repository.ProyectoRepository;

@SpringBootApplication
public class AprendiendoJpaApplication implements CommandLineRunner {

	@Autowired
	private OrganizacionRepository organizacionRepository;
	
	@Autowired
	private ProyectoRepository proyectoRepository;


	public static void main(String[] args) {
		SpringApplication.run(AprendiendoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola");
		// Organizacion org = new Organizacion("UNI");
		// organizacionRepository.save(org);

		// mostrarDatos();
		
		prueba01();
	}

	private void mostrarDatos() {
		Organizacion org = organizacionRepository.findById(1L).get();
		System.out.println("ORGANIZACION: " + org.getNombre());

		/*
		 * for(Proyecto p: org.getProyectos() ) { System.out.println(p.getNombre()); }
		 */
	}

	private void prueba01() {
		
		Organizacion organizacion = new Organizacion("The Apache Software Foundation");
		organizacion = organizacionRepository.findById(1L).get();
		
		Proyecto proyecto = new Proyecto("Streaming LOB support (for OpenJPA) 2");
		Estudiante estudiante = new Estudiante("Ignacio Andreu 2");
		estudiante.setProyecto(proyecto);
		proyecto.setEstudiante(estudiante);
		proyecto.setOrganizacion(organizacion);
		//organizacion.getProyectos().add(proyecto);
		
		// organizacionRepository.save(organizacion);
		proyectoRepository.save(proyecto);

	}
}
