package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.jobfinder.dtos.UsuarioDTO;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @GetMapping()
    public List<UsuarioDTO> findAll() {
        return usuarioService.listar().stream().map(u -> {
            ModelMapper usuarioModelMapper = new ModelMapper();
            return usuarioModelMapper.map(u, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

}
