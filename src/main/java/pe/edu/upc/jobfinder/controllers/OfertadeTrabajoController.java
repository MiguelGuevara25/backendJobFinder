package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.EmpresaDTO;
import pe.edu.upc.jobfinder.dtos.OfertadeTrabajoDTO;
import pe.edu.upc.jobfinder.entities.Empresa;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.servicesinterfaces.IEmpresaService;
import pe.edu.upc.jobfinder.servicesinterfaces.IOfertadeTrabajoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ofertadetrabajo")
public class OfertadeTrabajoController {
    @Autowired
    private IOfertadeTrabajoService oS;

    @GetMapping
    public List<OfertadeTrabajoDTO> listar() {
        return oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OfertadeTrabajoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody OfertadeTrabajoDTO dto) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajo a = m.map(dto, OfertadeTrabajo.class);
        oS.insert(a);
    }
    @GetMapping("/{id}")
    public OfertadeTrabajoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajoDTO dto = m.map(oS.searchId(id), OfertadeTrabajoDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody OfertadeTrabajoDTO dto) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajo a = m.map(dto, OfertadeTrabajo.class);
        oS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        oS.delete(id);
    }
}
