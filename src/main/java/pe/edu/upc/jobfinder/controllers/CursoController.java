package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.jobfinder.dtos.CantidadCursosPlataformaDTO;
import pe.edu.upc.jobfinder.dtos.CantidadCursosPorEmpresaDTO;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.dtos.CursoDTO;

import pe.edu.upc.jobfinder.entities.Curso;

import pe.edu.upc.jobfinder.servicesinterfaces.ICursoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private ICursoService cursoService;
    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,CursoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping()
    public void insertar(@RequestBody CursoDTO cursoDTO) {
        ModelMapper m= new ModelMapper();
        Curso c=m.map(cursoDTO,Curso.class);
        cursoService.insertar(c);
    }
    @GetMapping("/{id}")
    public CursoDTO listarId(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cursoService.searchId(id), CursoDTO.class);
    }
    @PutMapping()
    public void modificar(@RequestBody CursoDTO cursoDTO) {
        ModelMapper m= new ModelMapper();
        Curso c=m.map(cursoDTO,Curso.class);
        cursoService.modificar(c);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idC) {
        cursoService.eliminar(idC);
    }

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

    @GetMapping("/cantidadesempresas")
    public List<CantidadCursosPorEmpresaDTO> listarCantidadCursosEmpresa() {
        List<String[]> filaLista=cursoService.quantityCoursesByEnterprise();
        List<CantidadCursosPorEmpresaDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            CantidadCursosPorEmpresaDTO dto=new CantidadCursosPorEmpresaDTO();
            dto.setEmpresa(columna[0]);
            dto.setTotalCursos(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
