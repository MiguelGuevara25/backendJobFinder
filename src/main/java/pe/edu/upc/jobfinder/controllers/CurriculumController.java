package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CurriculumDTO;
import pe.edu.upc.jobfinder.dtos.CurriculumPromedioDTO;
import pe.edu.upc.jobfinder.entities.Curriculum;
import pe.edu.upc.jobfinder.servicesinterfaces.ICurriculumService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping()
    public List<CurriculumDTO> listar() {
        return curriculumService.listar().stream().map(curriculum -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(curriculum, CurriculumDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE')")
    @PostMapping
    public void insertar(@RequestBody CurriculumDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Curriculum curriculum = modelMapper.map(dto, Curriculum.class);
        curriculumService.insert(curriculum);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping("/{id}")
    public CurriculumDTO listarId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        CurriculumDTO dto = modelMapper.map(curriculumService.buscarID(id), CurriculumDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE')")
    @PutMapping
    public void modificar(@RequestBody CurriculumDTO dto) {
        ModelMapper m = new ModelMapper();
        Curriculum curriculum = m.map(dto, Curriculum.class);
        curriculumService.update(curriculum);
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE','ADMIN')")
    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        curriculumService.delete(id);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @GetMapping("/Promedio")
    public List<CurriculumPromedioDTO> curriculumPromedios() {
        List<String[]> filaLista=curriculumService.CurriculumByPromedio();
        List<CurriculumPromedioDTO> dtoListaa=new ArrayList<>();
        for(String[] columna:filaLista){
            CurriculumPromedioDTO dto=new CurriculumPromedioDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dto.setTotalExperiencia(Integer.parseInt(columna[3]));
            dto.setTotalEstudios(Integer.parseInt(columna[4]));
            dto.setTotalHabilidades(Integer.parseInt(columna[5]));
            dto.setTotalCertificados(Integer.parseInt(columna[6]));
            dto.setPuntajeTotal(Double.parseDouble(columna[7]));
            dtoListaa.add(dto);
        }
        return dtoListaa;
    }
}
