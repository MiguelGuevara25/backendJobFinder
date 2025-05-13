package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CantidadCentroEstudioDTO;
import pe.edu.upc.jobfinder.dtos.EstudioDTO;
import pe.edu.upc.jobfinder.dtos.FrecuenciaInstitucionDTO;
import pe.edu.upc.jobfinder.dtos.HabilidadDTO;
import pe.edu.upc.jobfinder.entities.Estudio;
import pe.edu.upc.jobfinder.servicesinterfaces.IEstudioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudios")
@PreAuthorize("hasAuthority('POSTULANTE')")
public class EstudioController {
    @Autowired
    private IEstudioService eS;

    @GetMapping
    public List<Estudio> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Estudio.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EstudioDTO dto) {
        ModelMapper m = new ModelMapper();
        Estudio e = m.map(dto, Estudio.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EstudioDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EstudioDTO dto = m.map(eS.searchId(id), EstudioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody EstudioDTO dto) {
        ModelMapper m = new ModelMapper();
        Estudio e = m.map(dto, Estudio.class);
        eS.update(e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

    @GetMapping("/buscarInstitucion")
    public List<CantidadCentroEstudioDTO> buscarCentroEstudio(@RequestParam("institucion") String institucion) {
        List<String []> filaLista = eS.buscarCentro(institucion);
        List<CantidadCentroEstudioDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            CantidadCentroEstudioDTO dto = new CantidadCentroEstudioDTO();
            dto.setCenter(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/institucion_mas_frecuente")
    public List<FrecuenciaInstitucionDTO> listarFrecuenciasInstituciones() {
        List<String []> filaLista = eS.institucionesMasFrecuentes();
        List<FrecuenciaInstitucionDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            FrecuenciaInstitucionDTO dto = new FrecuenciaInstitucionDTO();
            dto.setUniversidad(columna[0]);
            dto.setFrecuencia(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
