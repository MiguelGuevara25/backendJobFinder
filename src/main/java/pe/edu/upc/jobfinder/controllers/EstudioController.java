package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.EstudioDTO;
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
    @PostMapping
    public void insertar(@RequestBody EstudioDTO dto) {
        ModelMapper m = new ModelMapper();
        Estudio e = m.map(dto, Estudio.class);
        eS.insert(e);
    }
}
