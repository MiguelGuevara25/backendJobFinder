package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.jobfinder.dtos.CurriculumDTO;
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
}
