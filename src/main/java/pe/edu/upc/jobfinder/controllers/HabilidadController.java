package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.jobfinder.dtos.HabilidadDTO;
import pe.edu.upc.jobfinder.servicesinterfaces.IHabilidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    private IHabilidadService hS;

    @GetMapping
    public List<HabilidadDTO> listar() {
        return hS.list().stream().map(x ->{
            ModelMapper m = new ModelMapper();
            return m.map(x, HabilidadDTO.class);
        }).collect(Collectors.toList());
    }
}
