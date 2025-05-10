package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Experiencia")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "job",nullable = false, length = 125)
    private String job;

    @Column(name = "enterprise",nullable = false, length = 130)
    private String enterprise;

    @Column(name = "startDate",nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate",nullable = false)
    private LocalDate endDate;

    @Column(name = "description",nullable = false, length = 150)
    private String description;

    public Experiencia() {
    }

    public Experiencia(int id, String job, String enterprise, LocalDate startDate, LocalDate endDate, String description) {
        this.id = id;
        this.job = job;
        this.enterprise = enterprise;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
