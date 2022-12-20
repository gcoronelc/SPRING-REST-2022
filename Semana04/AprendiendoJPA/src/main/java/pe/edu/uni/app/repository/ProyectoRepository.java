package pe.edu.uni.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.domain.Proyecto;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long>{

}
