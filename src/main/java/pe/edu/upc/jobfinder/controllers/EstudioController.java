package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.jobfinder.entities.Estudio;
import pe.edu.upc.jobfinder.servicesinterfaces.IEstudioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudios")
public class EstudioController {
    @Autowired
    private IEstudioService eS;

    @GetMapping
    public List<Estudio> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Estudio.class);
        }).collect(Collectors.toList());
    }
}
