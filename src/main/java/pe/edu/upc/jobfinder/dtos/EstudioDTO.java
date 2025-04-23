package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class EstudioDTO {
    private int id;
    private String title_obtained;
    private String study_center;
    private LocalDate start_date;
    private LocalDate end_date;

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
