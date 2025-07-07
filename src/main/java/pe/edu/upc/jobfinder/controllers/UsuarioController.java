package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class    UsuarioController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    IUsuarioService usuarioService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public List<UsuarioListarDTO> findAll() {
        return usuarioService.listar().stream().map(u -> {
            ModelMapper usuarioModelMapper = new ModelMapper();
            return usuarioModelMapper.map(u, UsuarioListarDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'POSTULANTE', 'EMPRESA')")
    @PostMapping
    public void inserta(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        Usuario usuario = usuarioModelMapper.map(usuarioDTO, Usuario.class);
        String encryptedPassword = passwordEncoder.encode(usuario.getContraseniaUsuario());
        usuario.setContraseniaUsuario(encryptedPassword);
        usuarioService.insertar(usuario);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'POSTULANTE', 'EMPRESA')")
    @GetMapping({"/{id}"})
    public UsuarioDTO buscaPorId(@PathVariable("id") int idUsuario) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        UsuarioDTO usuarioDTO = usuarioModelMapper.map(usuarioService.buscarID(idUsuario), UsuarioDTO.class);
        return usuarioDTO;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'POSTULANTE', 'EMPRESA')")
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper usuarioModelMapper = new ModelMapper();
        Usuario usuario = usuarioModelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.insertar(usuario);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idUsuario) {
        usuarioService.eliminar(idUsuario);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPRESA')")
    @GetMapping("/busquedas")
    public List<UsuarioDTO> buscar(@RequestParam String n){
        return usuarioService.buscar(n).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/entrevistasxaprobadas")
    public List<UsuariosEntrevistasAprovadasDTO> EntrevistasAprovadas(@RequestParam String estado){
        List<String[]> filaLista=usuarioService.UsuariosXEntrevistasExitosas(estado);
        List<UsuariosEntrevistasAprovadasDTO> dtoListaa=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuariosEntrevistasAprovadasDTO dto=new UsuariosEntrevistasAprovadasDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dtoListaa.add(dto);
        }
        return dtoListaa;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/contratosactivos")
    public List<UsuariosContratoActivoDTO> ContratoActivos(){
        List<String[]> filaLista=usuarioService.UsuariosXcontratosActivos();
        List<UsuariosContratoActivoDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuariosContratoActivoDTO dto=new UsuariosContratoActivoDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dto.setId_contrato(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/detallesxusuarios")
    public List<UsuarioDetallesDTO> UsuariosDetalles(){
        List<String[]> filaLista=usuarioService.UsuariosXcontratosActivos();
        List<UsuarioDetallesDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuarioDetallesDTO dto=new UsuarioDetallesDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dto.setPuesto(columna[3]);
            dto.setEmpresa(columna[4]);
            dto.setTituloObtenido(columna[5]);
            dto.setCentroDeEstudios(columna[6]);
            dto.setHabilidad(columna[7]);
            dto.setCertificado(columna[8]);
            dto.setEntidadCertificaro(columna[9]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
