package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.entities.Postulacion;
import pe.edu.upc.jobfinder.servicesinterfaces.IOfertadeTrabajoService;
import pe.edu.upc.jobfinder.servicesinterfaces.IPostulacionService;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @GetMapping ("/PostulacionEstado")
    public List<PostulacionEstadoDTO> contarPostulacionesPorEstado(@RequestParam Boolean aceptado,Boolean rechazado)
    {List<String[]> filaLista=pS.contarPostulacionesPorEstado(aceptado, rechazado);
        List<PostulacionEstadoDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            PostulacionEstadoDTO dto=new PostulacionEstadoDTO();
            dto.setState(columna[0]);
            dto.setTotalPostulaciones(Integer.parseInt(columna[1]));
            dto.setAceptadas(Integer.parseInt(columna[2]));
            dto.setRechazadas(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping ("/PostulacionIntervalo")
    public List<PostulacionIntervaloDTO> buscarPostulacionesPorintervalodedias()
    {List<String[]> filaLista=pS.buscarPostulacionesPorintervalodedias();
        List<PostulacionIntervaloDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            PostulacionIntervaloDTO dto=new PostulacionIntervaloDTO();
            dto.setAcceptedcandidate(Boolean.parseBoolean(columna[0]));
            dto.setDate(LocalDate.parse(columna[1]));
            dto.setId(Integer.parseInt(columna[2]));
            dto.setState(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }


}
