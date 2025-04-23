package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Estudio")
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title_obtained",nullable = false, length = 50)
    private String title_obtained;

    @Column(name = "study_center",nullable = false, length = 50)
    private String study_center;

    @Column(name = "start_date",nullable = false)
    private LocalDate start_date;

    @Column(name = "end_date",nullable = false)
    private LocalDate end_date;

    public Estudio() {
    }

    public Estudio(int id, String title_obtained, String study_center, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.title_obtained = title_obtained;
        this.study_center = study_center;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_obtained() {
        return title_obtained;
    }

    public void setTitle_obtained(String title_obtained) {
        this.title_obtained = title_obtained;
    }

    public String getStudy_center() {
        return study_center;
    }

    public void setStudy_center(String study_center) {
        this.study_center = study_center;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
