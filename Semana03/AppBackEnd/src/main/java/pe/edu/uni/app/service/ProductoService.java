package pe.edu.uni.app.service;

import java.util.List;

import pe.edu.uni.app.model.Producto;


public interface ProductoService {

	List<Producto> listarTodos();

	void grabar(Producto producto);

	Producto buscarPorId(Long id);

	void eliminar(Long id);

}
