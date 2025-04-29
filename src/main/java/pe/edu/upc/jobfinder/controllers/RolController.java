package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.RolDTO;
import pe.edu.upc.jobfinder.entities.Rol;
import pe.edu.upc.jobfinder.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping
    public List<RolDTO> listar(){
        return rolService.listar().stream().map(rol->{
            ModelMapper modelMapper=new ModelMapper();
            return modelMapper.map(rol,RolDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.insertar(rol);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.update(rol);
    }
    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") int idRol) {
        ModelMapper m = new ModelMapper();
        RolDTO rolDTO = m.map(rolService.listarid(idRol), RolDTO.class);
        return rolDTO;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rolService.delete(id);
    }
}
