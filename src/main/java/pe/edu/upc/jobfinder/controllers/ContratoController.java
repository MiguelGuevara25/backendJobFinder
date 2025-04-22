package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    private IContratoService cS;

    @GetMapping
    public List<ContratoDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ContratoDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.searchId(id), ContratoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.update(c);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        cS.delete(id);
    }
}
