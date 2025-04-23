package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.dtos.EntrevistaDTO;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Entrevista;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;
import pe.edu.upc.jobfinder.servicesinterfaces.IEntrevistaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entrevistas")
public class EntrevistaController {
    @Autowired
    private IEntrevistaService eS;

    @GetMapping
    public List<EntrevistaDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EntrevistaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EntrevistaDTO dto) {
        ModelMapper m = new ModelMapper();
        Entrevista e = m.map(dto, Entrevista.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EntrevistaDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(eS.searchId(id), EntrevistaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody EntrevistaDTO dto) {
        ModelMapper m = new ModelMapper();
        Entrevista e = m.map(dto, Entrevista.class);
        eS.update(e);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        eS.delete(id);
    }
}
