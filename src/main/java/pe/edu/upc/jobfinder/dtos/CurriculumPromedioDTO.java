package pe.edu.upc.jobfinder.dtos;

public class CurriculumPromedioDTO {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private int totalExperiencia;
    private int totalEstudios;
    private int totalHabilidades;
    private int totalCertificados;
    private Double puntajeTotal;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTotalExperiencia() {
        return totalExperiencia;
    }

    public void setTotalExperiencia(int totalExperiencia) {
        this.totalExperiencia = totalExperiencia;
    }

    public int getTotalEstudios() {
        return totalEstudios;
    }

    public void setTotalEstudios(int totalEstudios) {
        this.totalEstudios = totalEstudios;
    }

    public int getTotalHabilidades() {
        return totalHabilidades;
    }

    public void setTotalHabilidades(int totalHabilidades) {
        this.totalHabilidades = totalHabilidades;
    }

    public int getTotalCertificados() {
        return totalCertificados;
    }

    public void setTotalCertificados(int totalCertificados) {
        this.totalCertificados = totalCertificados;
    }

    public Double getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Double puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}
