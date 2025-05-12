package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Empresa;

public class OfertaSalarioyUbicacionDTO {private int id;

    private String name;

    private double salary;

    private String location;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
