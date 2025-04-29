package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.dtos.DetalleDTO;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Detalle;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;
import pe.edu.upc.jobfinder.servicesinterfaces.IDetalleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalles")
public class DetalleController {
    @Autowired
    private IDetalleService dS;

    @GetMapping
    public List<DetalleDTO> listar(){
        return dS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle d = m.map(dto, Detalle.class);
        dS.insert(d);
    }

    @GetMapping("/{id}")
    public DetalleDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(dS.searchId(id), DetalleDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody DetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle d = m.map(dto, Detalle.class);
        dS.update(d);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        dS.delete(id);
    }
}
