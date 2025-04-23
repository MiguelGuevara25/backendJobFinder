package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.ExperienciaDTO;
import pe.edu.upc.jobfinder.entities.Experiencia;
import pe.edu.upc.jobfinder.servicesinterfaces.IExperienciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {
    @Autowired
    private IExperienciaService eS;

    @GetMapping
    public List<ExperienciaDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ExperienciaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ExperienciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Experiencia e = m.map(dto, Experiencia.class);
        eS.insert(e);
    }
}
