package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT nombre, apellido, id_usuario \n" +
            " FROM usuario \n" +
            " WHERE estado = :estado", nativeQuery = true)
    public List<String[]> listaXactivos(@Param("estado")boolean estado);

    @Query(value = "SELECT * \n" +
            "FROM usuario \n" +
            "WHERE nombre ILIKE %:nombre%", nativeQuery = true)
    public List<Usuario> buscar(@Param("nombre") String nombre);
}
