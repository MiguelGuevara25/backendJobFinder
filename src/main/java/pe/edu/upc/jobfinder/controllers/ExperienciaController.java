package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.DuracionPromedioPorPuestoDTO;
import pe.edu.upc.jobfinder.dtos.ExperienciaDTO;
import pe.edu.upc.jobfinder.dtos.HabilidaVaciaDTO;
import pe.edu.upc.jobfinder.dtos.PromedioExperienciaLaboralDTO;
import pe.edu.upc.jobfinder.entities.Experiencia;
import pe.edu.upc.jobfinder.servicesinterfaces.IExperienciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/experiencias")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    @Autowired
    private IExperienciaService eS;

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping
    public List<ExperienciaDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ExperienciaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE')")
    @PostMapping
    public void insertar(@RequestBody ExperienciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Experiencia e = m.map(dto, Experiencia.class);
        eS.insert(e);
    }

    @PreAuthorize("hasAnyAuthority('EMPRESA','POSTULANTE','ADMIN')")
    @GetMapping("/{id}")
    public ExperienciaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ExperienciaDTO dto = m.map(eS.searchId(id), ExperienciaDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE')")
    @PutMapping
    public void modificar(@RequestBody ExperienciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Experiencia e = m.map(dto, Experiencia.class);
        eS.insert(e);
    }

    @PreAuthorize("hasAnyAuthority('POSTULANTE'")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }
    @GetMapping("/duracion_promedio")
    public List<DuracionPromedioPorPuestoDTO> duracionPromedioPorPuesto() {
        List<String[]> filaLista=eS.DuracionPromedioPorPuesto();
        List<DuracionPromedioPorPuestoDTO> dtoLista =new ArrayList<>();
        for (String[] columna: filaLista) {
            DuracionPromedioPorPuestoDTO dto = new DuracionPromedioPorPuestoDTO();
            dto.setPuesto(columna[0]);
            dto.setDuracion_promedio(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/Promedio_experiencia_laboral")
    public List<PromedioExperienciaLaboralDTO> promedioExperienciaLaboral() {
        List<String[]> filaLista=eS.PromedioExperienciaLaboral();
        List<PromedioExperienciaLaboralDTO> dtoLista =new ArrayList<>();
        for (String[] columna: filaLista) {
            PromedioExperienciaLaboralDTO dto = new PromedioExperienciaLaboralDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setCantidad(Long.parseLong(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
