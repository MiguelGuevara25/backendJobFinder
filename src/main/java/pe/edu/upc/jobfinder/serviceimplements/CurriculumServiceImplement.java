package pe.edu.upc.jobfinder.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Curriculum;
import pe.edu.upc.jobfinder.repositories.ICurriculumRepository;
import pe.edu.upc.jobfinder.serviceinterfaces.ICurriculumService;

import java.util.List;

@Service
public class CurriculumServiceImplement implements ICurriculumService {
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public List<Curriculum> listar() {
        return curriculumRepository.findAll();
    }

    @Override
    public void insert(Curriculum curriculum) {
    }

    @Override
    public Curriculum buscarID(int idCurriculum) {
        return null;
    }

    @Override
    public void update(Curriculum curriculum) {

    }

    @Override
    public void delete(int id) {

    }
}
