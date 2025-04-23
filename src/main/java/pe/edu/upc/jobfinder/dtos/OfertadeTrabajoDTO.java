package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OfertadeTrabajoDTO {

    private int id;
    private int name;
    private String description;
    private double salary;
    private String typeofcontract;
    private String experience;
    private String location;
    private String company_id_empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
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

    public String getCompany_id_empresa() {
        return company_id_empresa;
    }

    public void setCompany_id_empresa(String company_id_empresa) {
        this.company_id_empresa = company_id_empresa;
    }
}
