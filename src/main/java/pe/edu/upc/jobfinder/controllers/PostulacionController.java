package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.OfertadeTrabajoDTO;
import pe.edu.upc.jobfinder.dtos.PostulacionDTO;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.entities.Postulacion;
import pe.edu.upc.jobfinder.servicesinterfaces.IOfertadeTrabajoService;
import pe.edu.upc.jobfinder.servicesinterfaces.IPostulacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/postulacion")
public class PostulacionController {
    @Autowired
    private IPostulacionService pS;

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @GetMapping
    public List<PostulacionDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PostulacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'POSTULANTE')")
    @PostMapping
    public void insertar(@RequestBody PostulacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Postulacion a = m.map(dto, Postulacion.class);
        pS.insert(a);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPRESA')")
    @GetMapping("/{id}")
    public PostulacionDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PostulacionDTO dto = m.map(pS.searchId(id), PostulacionDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','POSTULANTE')")
    @PutMapping
    public void modificar(@RequestBody PostulacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Postulacion a = m.map(dto, Postulacion.class);
        pS.update(a);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }
}
