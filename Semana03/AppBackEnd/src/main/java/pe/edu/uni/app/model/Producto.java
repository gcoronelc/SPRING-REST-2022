package pe.edu.uni.app.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@jakarta.persistence.Table(name = "PRODUCTO")
@SequenceGenerator(name = "sq_producto", sequenceName = "sq_producto", allocationSize = 1)
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idprod")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_producto")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "idcat")
	private Categoria categoria;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "stock")
	private Long stock;

	public Producto() {
		this.id = 0L;
		this.precio = 0.0;
		this.stock = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}

}
