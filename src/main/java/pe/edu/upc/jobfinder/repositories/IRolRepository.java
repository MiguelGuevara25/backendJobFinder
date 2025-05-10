package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Rol;

import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT u.id_usuario, r.rol\n" +
            " FROM roles r\n" +
            " JOIN users u ON u.id_usuario = r.user_id", nativeQuery = true)
    public List<String[]> rolesXusuario();

}
