package pe.edu.upc.jobfinder.dtos;

public class PromedioExperienciaLaboralDTO {
    private int id_usuario;
    private Long cantidad;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
