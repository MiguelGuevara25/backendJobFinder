package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
@PreAuthorize("hasAuthority('EMPRESA')")
public class ContratoController {
    @Autowired
    private IContratoService cS;

    @GetMapping
    public List<ContratoDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ContratoDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.searchId(id), ContratoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.update(c);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        cS.delete(id);
    }

    @GetMapping("/tipos-contrato")
    public List<TipoContratoDTO> buscarTipoContrato(@RequestParam String contractType) {
        List<String[]> filaLista =cS.searchByContractType(contractType);
        List<TipoContratoDTO> dtoLista = new ArrayList<>();
        for (String[] columna:filaLista) {
            TipoContratoDTO dto=new TipoContratoDTO();
            dto.setEndDate(LocalDate.parse(columna[0]));
            dto.setStartDate(LocalDate.parse(columna[1]));
            dto.setContractType(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/buscar-salario")
    public List<BuscarSalarioDTO> buscarSalario(@RequestParam Double salary) {
        List<String[]> filaLista = cS.searchSalary(salary);
        List<BuscarSalarioDTO> dtoLista = new ArrayList<>();
        for (String[] columna:filaLista) {
            BuscarSalarioDTO dto = new BuscarSalarioDTO();
            dto.setSalary(Double.parseDouble(columna[0]));
            dto.setName(columna[1]);
            dto.setLastName(columna[2]);
            dto.setEmail(columna[3]);
            dto.setNameJob(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
