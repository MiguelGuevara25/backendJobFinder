package pe.edu.upc.jobfinder.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.jobfinder.dtos.CantidadCursosPlataformaDTO;
import pe.edu.upc.jobfinder.dtos.CertificadoDTO;
import pe.edu.upc.jobfinder.dtos.ContratoDTO;
import pe.edu.upc.jobfinder.dtos.CursoDTO;
import pe.edu.upc.jobfinder.entities.Certificado;
import pe.edu.upc.jobfinder.servicesinterfaces.ICertificadoService;

import java.util.ArrayList;
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
    @GetMapping("/{id}")
    public CertificadoDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.searchId(id), CertificadoDTO.class);
    }
    @PutMapping()
    public void modificar(@RequestBody CertificadoDTO certificadoDTO) {
        ModelMapper m= new ModelMapper();
        Certificado c=m.map(certificadoDTO,Certificado.class);
        cS.modificar(c);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idC) {
        cS.eliminar(idC);
    }

    @GetMapping("/vigentes")
    public List<CertificadoDTO> mostrarCertificadosVigentes() {
        return cS.searchActiveCertificaates().stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, CertificadoDTO.class);
        }).collect(Collectors.toList());
    }
}
