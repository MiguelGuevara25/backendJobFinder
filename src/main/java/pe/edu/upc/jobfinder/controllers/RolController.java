package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.RolDTO;
import pe.edu.upc.jobfinder.dtos.RolesDeUsuarioDTO;
import pe.edu.upc.jobfinder.dtos.RolesPromYcantDTO;
import pe.edu.upc.jobfinder.entities.Rol;
import pe.edu.upc.jobfinder.servicesinterfaces.IRolService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/asignados")
    public List<RolesDeUsuarioDTO> rolesDeUsuario() {
        List<String[]> filaLista=rolService.rolesXusuario();
        List<RolesDeUsuarioDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            RolesDeUsuarioDTO dto=new RolesDeUsuarioDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setNombreRol(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/promedio")
    public List<RolesPromYcantDTO> rolesPromYcant(@RequestParam String tipodeRol){
        List<String[]> filaLista=rolService.promedioYcantidadXrol(tipodeRol);
        List<RolesPromYcantDTO> dtoLista =new ArrayList<>();
        for(String[] columna:filaLista){
            RolesPromYcantDTO dto=new RolesPromYcantDTO();
            dto.setPromedio(Double.parseDouble(columna[0]));
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
