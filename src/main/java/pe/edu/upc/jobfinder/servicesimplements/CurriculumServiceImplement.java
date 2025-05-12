package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Curriculum;
import pe.edu.upc.jobfinder.repositories.ICurriculumRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.ICurriculumService;

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
        curriculumRepository.save(curriculum);
    }

    @Override
    public Curriculum buscarID(int idCurriculum) {
        return curriculumRepository.findById(idCurriculum).orElse(new Curriculum());
    }

    @Override
    public void update(Curriculum curriculum) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<String[]> CurriculumByPromedio() {
        return curriculumRepository.CurriculumByPromedio();
    }
}
