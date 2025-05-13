package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Estudio;

import java.util.List;

public interface IEstudioRepository extends JpaRepository<Estudio, Integer> {
    //1.Este query busca centros de estudio cuyo nombre contiene una palabra que tú le pases,
    // y te dice cuántas veces se han registrado en la base de datos.
    //2. te ayuda a saber qué tan común es un centro de estudios,tomar decisiones basadas en
    // popularidad o reputación.

    @Query(value = "SELECT e.study_center, COUNT (*) AS cantidad_registros\n" +
            " FROM Estudio e\n" +
            " WHERE e.study_center like %:nombre%\n" +
            " GROUP BY e.study_center", nativeQuery = true)
    public List<String[]>buscarCentro(@Param("nombre") String nombre);

    //1.Este query cuenta cuántas veces aparece cada centro de estudios en la base de datos, sin filtros.
    //Luego, los ordena del más repetido al menos repetido.
    //2.te da un ranking de las instituciones más frecuentes, lo cual es valioso si quieres entender
    //tu base de datos y actuar en base a eso.

    @Query(value = "SELECT e.study_center, COUNT(*) AS veces_registrada " +
            "FROM estudio e " +
            "GROUP BY e.study_center " +
            "HAVING COUNT(*) = (SELECT MAX(veces_registrada) " +
            "FROM (SELECT COUNT(*) AS veces_registrada FROM estudio GROUP BY study_center) AS subquery) " +
            "ORDER BY veces_registrada DESC;", nativeQuery = true)
    public List<String[]> institucionesMasFrecuentes();

}
