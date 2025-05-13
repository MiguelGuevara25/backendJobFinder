package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;

import pe.edu.upc.jobfinder.entities.InscripcionCurso;
import pe.edu.upc.jobfinder.servicesinterfaces.IInscripcionCursoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscripcioncursos")
public class InscripcionCursoController {
    @Autowired
    private IInscripcionCursoService inscripcionCursoService;

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @GetMapping
    public List<InscripcionCursoDTO> listar() {
        return inscripcionCursoService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,InscripcionCursoDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE','ADMIN')")
    @PostMapping()
    public void insertar(@RequestBody InscripcionCursoDTO inscripcionCursoDTO) {
        ModelMapper m= new ModelMapper();
        InscripcionCurso iC=m.map(inscripcionCursoDTO,InscripcionCurso.class);
        inscripcionCursoService.insertar(iC);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @GetMapping("/{id}")
    public InscripcionCursoDTO listarId(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inscripcionCursoService.searchId(id), InscripcionCursoDTO.class);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping()
    public void modificar(@RequestBody InscripcionCursoDTO inscripcionCursoDTO) {
        ModelMapper m= new ModelMapper();
        InscripcionCurso iC=m.map(inscripcionCursoDTO,InscripcionCurso.class);
        inscripcionCursoService.modificar(iC);
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE','ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idIC) {
        inscripcionCursoService.eliminar(idIC);
    }

    @GetMapping("/total")
    public List<TotalRegistrosPorCursoDTO> totalRegistrosPorCurso() {
        List<String[]> filaLista=inscripcionCursoService.totalRegistrationByCourse();
        List<TotalRegistrosPorCursoDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            TotalRegistrosPorCursoDTO dto=new TotalRegistrosPorCursoDTO();
            dto.setTituloCurso(columna[0]);
            dto.setTotalRegistros(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/promedios")
    public List<PromedioCursosDTO> promedioCursos() {
        List<String[]> filaLista=inscripcionCursoService.promedioDeCursos();
        List<PromedioCursosDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            PromedioCursosDTO dto=new PromedioCursosDTO();
            dto.setTituloCurso(columna[0]);
            dto.setPromedioProgreso(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
