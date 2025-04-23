package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CursoDTO;
import pe.edu.upc.jobfinder.dtos.InscripcionCursoDTO;
import pe.edu.upc.jobfinder.entities.Curso;

import pe.edu.upc.jobfinder.entities.InscripcionCurso;
import pe.edu.upc.jobfinder.serviceinterfaces.IInscripcionCursoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscripcioncursos")
public class InscripcionCursoController {
    @Autowired
    private IInscripcionCursoService inscripcionCursoService;
    @GetMapping
    public List<InscripcionCursoDTO> listar() {
        return inscripcionCursoService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,InscripcionCursoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping()
    public void insertar(@RequestBody InscripcionCursoDTO inscripcionCursoDTO) {
        ModelMapper m= new ModelMapper();
        InscripcionCurso iC=m.map(inscripcionCursoDTO,InscripcionCurso.class);
        inscripcionCursoService.insertar(iC);
    }
    @PutMapping()
    public void modificar(@RequestBody InscripcionCursoDTO inscripcionCursoDTO) {
        ModelMapper m= new ModelMapper();
        InscripcionCurso iC=m.map(inscripcionCursoDTO,InscripcionCurso.class);
        inscripcionCursoService.modificar(iC);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idIC) {
        inscripcionCursoService.eliminar(idIC);
    }
}
