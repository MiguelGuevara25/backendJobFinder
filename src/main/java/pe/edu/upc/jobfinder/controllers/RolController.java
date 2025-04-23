package pe.edu.upc.jobfinder.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.jobfinder.dtos.RolDTO;
import pe.edu.upc.jobfinder.serviceinterfaces.IRolService;

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
}
