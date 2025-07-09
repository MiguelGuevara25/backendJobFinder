package pe.edu.upc.jobfinder.dtos;

public class CurriculumPromedioDTO {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private Double puntaje_absoluto;
    private Double porcentaje_perfil;

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

    public Double getPuntaje_absoluto() {
        return puntaje_absoluto;
    }

    public void setPuntaje_absoluto(Double puntaje_absoluto) {
        this.puntaje_absoluto = puntaje_absoluto;
    }

    public Double getPorcentaje_perfil() {
        return porcentaje_perfil;
    }

    public void setPorcentaje_perfil(Double porcentaje_perfil) {
        this.porcentaje_perfil = porcentaje_perfil;
    }
}
