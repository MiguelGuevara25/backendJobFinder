package pe.edu.upc.jobfinder.entities;

import java.time.LocalDate;

public class Contrato {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double salary;
    private String contractType;

    //private Usuario usuarios;
    //private Postulacion postulacion;
    private Empresa empresa;
}
