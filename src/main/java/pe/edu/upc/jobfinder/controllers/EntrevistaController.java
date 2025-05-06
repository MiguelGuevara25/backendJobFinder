package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.*;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Entrevista;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;
import pe.edu.upc.jobfinder.servicesinterfaces.IEntrevistaService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entrevistas")
public class EntrevistaController {
    @Autowired
    private IEntrevistaService eS;

    @GetMapping
    public List<EntrevistaDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EntrevistaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EntrevistaDTO dto) {
        ModelMapper m = new ModelMapper();
        Entrevista e = m.map(dto, Entrevista.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EntrevistaDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(eS.searchId(id), EntrevistaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody EntrevistaDTO dto) {
        ModelMapper m = new ModelMapper();
        Entrevista e = m.map(dto, Entrevista.class);
        eS.update(e);
    }

    @DeleteMapping({"/{id}"})
    public void eliminar(@PathVariable int id) {
        eS.delete(id);
    }

    @GetMapping("/cantidades")
    public List<CantidadEntrevistasDTO> cantidadEntrevistas() {
        List<String[]> filaLista=eS.quantityInterview();
        List<CantidadEntrevistasDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            CantidadEntrevistasDTO dto=new CantidadEntrevistasDTO();
            dto.setQuantityInterview(Integer.parseInt(columna[0]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/ultimas-30-dias")
    public List<EntrevistaUltimos30DiasDTO> entrevistaUltimos30DiasDTO() {
        List<String[]> filaLista=eS.interviewsLast30Days();
        List<EntrevistaUltimos30DiasDTO> dtoLista= new ArrayList<>();
        for (String[] columna:filaLista) {
            EntrevistaUltimos30DiasDTO dto=new EntrevistaUltimos30DiasDTO();
            dto.setDate(LocalDate.parse(columna[0]));
            dto.setHour(LocalTime.parse(columna[1]));
            dto.setName(columna[2]);
            dto.setLastName(columna[3]);
            dto.setPhone(columna[4]);
            dto.setEmail(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
