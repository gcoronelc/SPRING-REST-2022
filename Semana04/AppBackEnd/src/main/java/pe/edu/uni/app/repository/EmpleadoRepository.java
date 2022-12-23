package pe.edu.uni.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	List<Empleado> findByNombreAndApellido(String nombre, String apellido);

	List<Empleado> findByNombreLike(String nombre);

	List<Empleado> findByNombreContaining(String nombre);

	List<Empleado> findByNombreContainingIgnoreCase(String nombre);

	List<Empleado> findByNombreLikeIgnoreCase(String nombre);

	Empleado buscarPorEmail(String email);

	@Query("select e from Empleado e where e.id = ?1")
	Empleado buscarPorId(Long id);

	@Query("select e from Empleado e where UPPER(e.nombre) like %?1%")
	List<Empleado> buscarPorNombre(String nombre);

	@Query(value = "SELECT * FROM EMPLEADO WHERE UPPER(nombre) LIKE ?1 AND UPPER(apellido) LIKE ?2", nativeQuery = true)
	List<Empleado> buscarEmpleados(String nombre, String apellido);

	@Query("select e from Empleado e where UPPER(e.nombre) like %:nombre%")
	List<Empleado> buscarEmpleadosPorNombre(@Param("nombre") String nombre);

}
