package pe.edu.upc.jobfinder.dtos;

public class DuracionPromedioPorPuestoDTO {
    private String puesto;
    private int duracion_promedio;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getDuracion_promedio() {
        return duracion_promedio;
    }

    public void setDuracion_promedio(int duracion_promedio) {
        this.duracion_promedio = duracion_promedio;
    }
}
