package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.UsuarioDTO;
import pe.edu.upc.jobfinder.dtos.UsuariosActivosDTO;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/listar")
    public List<UsuarioDTO> findAll() {
        return usuarioService.listar().stream().map(u -> {
            ModelMapper usuarioModelMapper = new ModelMapper();
            return usuarioModelMapper.map(u, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void inserta(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        Usuario usuario = usuarioModelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.insertar(usuario);
    }

    @GetMapping({"/{id}"})
    public UsuarioDTO buscaPorId(@PathVariable("id") int idUsuario) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        UsuarioDTO usuarioDTO = usuarioModelMapper.map(usuarioService.buscarID(idUsuario), UsuarioDTO.class);
        return usuarioDTO;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        Usuario usuario = usuarioModelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.insertar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idUsuario) {
        usuarioService.eliminar(idUsuario);
    }

    @GetMapping("/activos")
    public List<UsuariosActivosDTO> buscar(@RequestParam boolean estado){
        List<String[]> filaLista=usuarioService.listaXactivos(estado);
        List<UsuariosActivosDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuariosActivosDTO dto=new UsuariosActivosDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setApellidoUsuario(columna[1]);
            dto.setIdUsuario(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/busquedas")
    public List<UsuarioDTO> buscar(@RequestParam String n){
        return usuarioService.buscar(n).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
