package pe.edu.uni.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.model.Producto;
import pe.edu.uni.app.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoControllerV1 {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> traerTodos(){
		return productoService.listarTodos();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Producto> traerPorId(@PathVariable("id") Long id){
		Producto objProducto = productoService.buscarPorId(id);
		if(objProducto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(objProducto);
	}
	
	
	

}
