package pe.edu.uni.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long>{

}
