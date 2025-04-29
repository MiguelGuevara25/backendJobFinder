package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.HabilidadDTO;
import pe.edu.upc.jobfinder.entities.Habilidad;
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
        return hS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HabilidadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody HabilidadDTO dto) {
        ModelMapper m = new ModelMapper();
        Habilidad h = m.map(dto, Habilidad.class);
        hS.insert(h);
    }

    @GetMapping("/{id}")
    public HabilidadDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        HabilidadDTO dto = m.map(hS.searchId(id), HabilidadDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody HabilidadDTO dto) {
        ModelMapper m = new ModelMapper();
        Habilidad h = m.map(dto, Habilidad.class);
        hS.update(h);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        hS.delete(id);
    }
}
