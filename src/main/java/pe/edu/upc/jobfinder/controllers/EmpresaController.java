package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CantidadEntrevistasDTO;
import pe.edu.upc.jobfinder.dtos.EmpresaDTO;
import pe.edu.upc.jobfinder.dtos.EmpresaSectorDTO;
import pe.edu.upc.jobfinder.dtos.EmpresaUbicacionDTO;
import pe.edu.upc.jobfinder.entities.Empresa;
import pe.edu.upc.jobfinder.servicesinterfaces.IEmpresaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaService eS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/buscarporsector")
    public List<EmpresaSectorDTO> buscarporsector(@RequestParam String nombre) {
        List<String[]> filaLista=eS.buscarPorSector(nombre);
        List<EmpresaSectorDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            EmpresaSectorDTO dto=new EmpresaSectorDTO();
            dto.setSector(columna[0]);
            dto.setName(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/contarEmpresasPorUbicacion")
    public List<EmpresaUbicacionDTO> contarEmpresasPorUbicacion (@RequestParam String sector) {
        List<String[]> filaLista=eS.contarEmpresasPorUbicacion(sector);
        List<EmpresaUbicacionDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            EmpresaUbicacionDTO dto=new EmpresaUbicacionDTO();
            dto.setSector(columna[0]);
            dto.setLocation(columna[1]);
            dto.setCantidadEmpresas(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }





}
