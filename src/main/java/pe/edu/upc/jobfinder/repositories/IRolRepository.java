package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Rol;

import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT u.id_usuario, r.nombre\n" +
            " FROM rol r\n" +
            " JOIN usuario u ON u.id_usuario = r.id_usuario", nativeQuery = true)
    public List<String[]> rolesXusuario();

    @Query(value = "SELECT avg(u.edad), count(*)\n" +
            " FROM rol r\n" +
            " JOIN usuario u ON u.id_usuario = r.id_usuario\n" +
            " WHERE r.nombre ILIKE :nombre%", nativeQuery = true)
    public List<String[]> promedioYcantidadXrol(@Param("nombre") String nombre);
}
