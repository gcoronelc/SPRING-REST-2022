package pe.edu.uni.app.service;

import java.util.List;
import java.util.Map;

import pe.edu.uni.app.model.Categoria;


public interface CategoriaService {

	List<Categoria> listarTodos();
	
	List<Map<String,?>> listarCategorias();

}
