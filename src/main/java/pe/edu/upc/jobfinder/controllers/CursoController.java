package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.jobfinder.dtos.CantidadCursosPlataformaDTO;
import pe.edu.upc.jobfinder.dtos.CursoDTO;

import pe.edu.upc.jobfinder.entities.Curso;

import pe.edu.upc.jobfinder.servicesinterfaces.ICursoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
@PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,CursoDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @PostMapping()
    public void insertar(@RequestBody CursoDTO cursoDTO) {
        ModelMapper m= new ModelMapper();
        Curso c=m.map(cursoDTO,Curso.class);
        cursoService.insertar(c);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping("/{id}")
    public CursoDTO listarId(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cursoService.searchId(id), CursoDTO.class);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @PutMapping()
    public void modificar(@RequestBody CursoDTO cursoDTO) {
        ModelMapper m= new ModelMapper();
        Curso c=m.map(cursoDTO,Curso.class);
        cursoService.modificar(c);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idC) {
        cursoService.eliminar(idC);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','ADMIN')")
    @GetMapping("/cantidades")
    public List<CantidadCursosPlataformaDTO> listarCantidadCursosPlataforma() {
        List<String[]> filaLista=cursoService.quantityCoursesByPlatform();
        List<CantidadCursosPlataformaDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            CantidadCursosPlataformaDTO dto=new CantidadCursosPlataformaDTO();
            dto.setPlataformaCurso(columna[0]);
            dto.setTotalCursos(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping("/busquedas")
    public List<CursoDTO> search(@RequestParam String nombre){
        return cursoService.searchByNameCourse(nombre).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, CursoDTO.class);
        }).collect(Collectors.toList());
    }
}
