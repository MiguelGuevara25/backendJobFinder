package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CertificadoDTO;
import pe.edu.upc.jobfinder.entities.Certificado;
import pe.edu.upc.jobfinder.serviceinterfaces.ICertificadoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certificados")
public class CertificadoController {
    @Autowired
    private ICertificadoService cS;
    @GetMapping
    public List<CertificadoDTO> listar() {
        return cS.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,CertificadoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping()
    public void insertar(@RequestBody CertificadoDTO certificadoDTO) {
        ModelMapper m= new ModelMapper();
        Certificado c=m.map(certificadoDTO,Certificado.class);
        cS.insertar(c);
    }
    @PutMapping()
    public void modificar(@RequestBody CertificadoDTO certificadoDTO) {
        ModelMapper m= new ModelMapper();
        Certificado c=m.map(certificadoDTO,Certificado.class);
        cS.modificar(c);
    }
    public void eliminar(@PathVariable("id") int idC) {
        cS.eliminar(idC);
    }
}
