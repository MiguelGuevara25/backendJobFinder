package pe.edu.upc.jobfinder.dtos;

public class EmpresaUbicacionDTO {

    private String sector;

    private String location;

    private int cantidadEmpresas;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCantidadEmpresas() {
        return cantidadEmpresas;
    }

    public void setCantidadEmpresas(int cantidadEmpresas) {
        this.cantidadEmpresas = cantidadEmpresas;
    }
}
