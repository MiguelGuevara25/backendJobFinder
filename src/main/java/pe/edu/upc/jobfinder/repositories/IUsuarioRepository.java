package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsuarioUsuario(String username);

    @Query(value = "SELECT nombre, apellido, id_usuario \n" +
            " FROM usuario \n" +
            " WHERE estado = :estado", nativeQuery = true)
    public List<String[]> listaXactivos(@Param("estado")boolean estado);

    @Query(value = "SELECT * \n" +
            "FROM usuario \n" +
            "WHERE nombre ILIKE %:nombre%", nativeQuery = true)
    public List<Usuario> buscar(@Param("nombre") String nombre);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
