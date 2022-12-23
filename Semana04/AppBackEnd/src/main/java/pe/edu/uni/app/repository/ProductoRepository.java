package pe.edu.uni.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
