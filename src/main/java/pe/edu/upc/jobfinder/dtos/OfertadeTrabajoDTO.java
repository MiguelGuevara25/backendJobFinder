package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.*;
import pe.edu.upc.jobfinder.entities.Empresa;

public class OfertadeTrabajoDTO {

    private int id;

    private String name;

    private String description;

    private double salary;

    private String typeofcontract;

    private String experience;

    private String location;

    private Empresa empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTypeofcontract() {
        return typeofcontract;
    }

    public void setTypeofcontract(String typeofcontract) {
        this.typeofcontract = typeofcontract;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
