package pe.edu.upc.jobfinder.dtos;

public class CantidadCursosPorEmpresaDTO {
    private String empresa;
    private int totalCursos;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getTotalCursos() {
        return totalCursos;
    }

    public void setTotalCursos(int totalCursos) {
        this.totalCursos = totalCursos;
    }
}
