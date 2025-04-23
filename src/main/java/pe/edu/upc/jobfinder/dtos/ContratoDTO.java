package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Empresa;

import java.time.LocalDate;

public class ContratoDTO {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double salary;
    private String contractType;

    //private Usuario usuarios;
    //private Postulacion postulacion;
    private Empresa empresa;
}
