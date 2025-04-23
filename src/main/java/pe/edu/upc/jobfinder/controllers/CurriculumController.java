package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.dtos.CurriculumDTO;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Curriculum;
import pe.edu.upc.jobfinder.serviceinterfaces.ICurriculumService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @GetMapping()
    public List<CurriculumDTO> listar() {
        return curriculumService.listar().stream().map(curriculum -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(curriculum, CurriculumDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ContratoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Curriculum curriculum = modelMapper.map(dto, Curriculum.class);
        curriculumService.insert(curriculum);
    }

    @GetMapping("/{id}")
    public ContratoDTO listarId(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(curriculumService.buscarID(id), ContratoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Curriculum curriculum = m.map(dto, Curriculum.class);
        curriculumService.update(curriculum);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        curriculumService.delete(id);
    }
}
