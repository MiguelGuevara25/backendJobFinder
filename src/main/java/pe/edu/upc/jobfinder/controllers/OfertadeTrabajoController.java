package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;
import pe.edu.upc.jobfinder.entities.Empresa;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.servicesinterfaces.IEmpresaService;
import pe.edu.upc.jobfinder.servicesinterfaces.IOfertadeTrabajoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ofertadetrabajo")
@PreAuthorize("hasAuthority('EMPRESA')")
public class OfertadeTrabajoController {
    @Autowired
    private IOfertadeTrabajoService oS;

    @GetMapping
    public List<OfertadeTrabajoDTO> listar() {
        return oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OfertadeTrabajoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody OfertadeTrabajoDTO dto) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajo a = m.map(dto, OfertadeTrabajo.class);
        oS.insert(a);
    }
    @GetMapping("/{id}")
    public OfertadeTrabajoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajoDTO dto = m.map(oS.searchId(id), OfertadeTrabajoDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody OfertadeTrabajoDTO dto) {
        ModelMapper m = new ModelMapper();
        OfertadeTrabajo a = m.map(dto, OfertadeTrabajo.class);
        oS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        oS.delete(id);
    }

    @GetMapping ("/OfertaSalarioyUbicacion")
    public List<OfertaSalarioyUbicacionDTO> buscarOfertasporSalarioYUbicacion(@RequestParam Double salarioMinimo, String ubicacion)
    {List<String[]> filaLista=oS.buscarOfertasPorSalarioYUbicacion(salarioMinimo, ubicacion);
        List<OfertaSalarioyUbicacionDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            OfertaSalarioyUbicacionDTO dto=new OfertaSalarioyUbicacionDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setName((columna[1]));
            dto.setLocation((columna[2]));
            dto.setSalary(Double.parseDouble(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping ("OfertaUbicacionyContratoEmpresa")
    public List<OfertaUbicacionyContratoEmpresaDTO> buscarOfertasPorUbicacionYContratoConEmpresa(@RequestParam String ubicacion, String tipoContrato)
    {List<String[]> filaLista=oS.buscarOfertasPorUbicacionYContratoConEmpresa(ubicacion, tipoContrato );
        List<OfertaUbicacionyContratoEmpresaDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            OfertaUbicacionyContratoEmpresaDTO dto=new OfertaUbicacionyContratoEmpresaDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setLocation(columna[1]);
            dto.setName(columna[2]);
            dto.setTypeofcontract(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
