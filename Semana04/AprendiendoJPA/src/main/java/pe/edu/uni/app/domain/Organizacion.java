package pe.edu.uni.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Organizacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "org_id")
	private Long idOrganizacion;
	
	@Basic
	@Column(name = "org_nombre", nullable = false, length = 100)
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "organizacion") 
	private List<Proyecto> proyectos = new ArrayList<>();
	
	public Organizacion() {
	}
	
	

	public Organizacion(String nombre) {
		super();
		this.nombre = nombre;
	}



	public Organizacion(Long idOrganizacion, String nombre) {
		super();
		this.idOrganizacion = idOrganizacion;
		this.nombre = nombre;
	}



	public Long getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
}
