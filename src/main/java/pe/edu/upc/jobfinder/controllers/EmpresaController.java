package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.EmpresaDTO;
import pe.edu.upc.jobfinder.entities.Empresa;
import pe.edu.upc.jobfinder.servicesinterfaces.IEmpresaService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/empresas")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmpresaController {

    @Autowired
    private IEmpresaService eS;

    @GetMapping
    public List<EmpresaDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EmpresaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        Empresa a = m.map(dto, Empresa.class);
        eS.insert(a);
    }
    @GetMapping("/{id}")
    public EmpresaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EmpresaDTO dto = m.map(eS.searchId(id), EmpresaDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        Empresa a = m.map(dto, Empresa.class);
        eS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }



}
