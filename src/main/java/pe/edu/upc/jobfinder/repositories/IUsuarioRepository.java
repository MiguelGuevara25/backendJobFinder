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
            " FROM users \n" +
            " WHERE estado = :estado", nativeQuery = true)
    public List<String[]> listaXactivos(@Param("estado")boolean estado);

    @Query(value = "SELECT * \n" +
            " FROM users \n" +
            " WHERE nombre ILIKE %:nombre%", nativeQuery = true)
    public List<Usuario> buscar(@Param("nombre") String nombre);

    @Query(value = "SELECT u.id_usuario, u.nombre, u.apellido\n" +
            " FROM users u\n" +
            " JOIN entrevista e ON u.id_usuario = e.id_usuario\n" +
            " WHERE e.result ILIKE :estado\n" +
            " GROUP BY u.id_usuario, u.nombre, u.apellido", nativeQuery = true)
    public List<String[]> UsuariosXEntrevistasExitosas(@Param("estado")String estado);

    @Query(value = "SELECT \n" +
            "    u.id_usuario,\n" +
            "    u.nombre,\n" +
            "    u.apellido,\n" +
            "    e.job AS experiencia_puesto,\n" +
            "    e.enterprise AS experiencia_empresa,\n" +
            "    es.title_obtained AS estudio_titulo,\n" +
            "    es.study_center AS estudio_centro,\n" +
            "    h.nombre AS habilidad,\n" +
            "    c.nombre_certificado AS certificado,\n" +
            "    c.entidad_emisora_certificado AS certificado_entidad\n" +
            " FROM users u\n" +
            " JOIN curriculum cu ON u.id_usuario = cu.id_usuario\n" +
            " JOIN detalle d ON cu.id_curriculum = d.id_curriculum\n" +
            " LEFT JOIN experiencia e ON d.id_experiencia = e.id\n" +
            " LEFT JOIN estudio es ON d.id = es.id\n" +
            " LEFT JOIN habilidad h ON d.id = h.id_habilidad\n" +
            " LEFT JOIN certificado c ON d.id_certificado = c.id_certificado\n" +
            " WHERE u.id_usuario = :id", nativeQuery = true)
    public List<String[]> UsuariosXDetalles(@Param("id")int id);

    @Query(value = "SELECT u.id_usuario, u.nombre, u.apellido, c.id\n" +
            " FROM users u\n" +
            " JOIN contrato c ON u.id_usuario = c.id_usuario\n" +
            " WHERE c.end_date >= CURRENT_DATE", nativeQuery = true)
    public List<String[]> UsuariosXcontratosActivos();

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
