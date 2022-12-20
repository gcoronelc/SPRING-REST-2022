package pe.edu.uni.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.domain.Organizacion;

@Repository
public interface OrganizacionRepository extends CrudRepository<Organizacion, Long>{

}
