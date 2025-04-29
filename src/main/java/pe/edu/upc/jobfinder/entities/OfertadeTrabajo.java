package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table (name= "OfertadeTrabajo")
public class OfertadeTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "salary", nullable = false)
    private double salary;
    @Column(name = "typeofcontract", nullable = false, length = 100)
    private String typeofcontract;
    @Column(name = "experience", nullable = false, length = 100)
    private String experience;
    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public OfertadeTrabajo() {
    }

    public OfertadeTrabajo(int id, String name, String description, double salary, String typeofcontract, String experience, String location, Empresa empresa) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.typeofcontract = typeofcontract;
        this.experience = experience;
        this.location = location;
        this.empresa = empresa;
    }

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
