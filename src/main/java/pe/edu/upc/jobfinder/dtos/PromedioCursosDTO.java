package pe.edu.upc.jobfinder.dtos;

public class PromedioCursosDTO {
    private String tituloCurso;
    private double promedioProgreso;

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public double getPromedioProgreso() {
        return promedioProgreso;
    }

    public void setPromedioProgreso(double promedioProgreso) {
        this.promedioProgreso = promedioProgreso;
    }
}
