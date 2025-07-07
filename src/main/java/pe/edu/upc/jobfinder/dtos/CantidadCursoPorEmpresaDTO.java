package pe.edu.upc.jobfinder.dtos;

public class CantidadCursoPorEmpresaDTO {
    private String empresa;
    private int total;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
