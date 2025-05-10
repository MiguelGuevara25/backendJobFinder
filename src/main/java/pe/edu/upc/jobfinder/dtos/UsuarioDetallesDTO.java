package pe.edu.upc.jobfinder.dtos;

public class UsuarioDetallesDTO {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String puesto;
    private String empresa;
    private String tituloObtenido;
    private String centroDeEstudios;
    private String habilidad;
    private String certificado;
    private String entidadCertificaro;

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public String getCentroDeEstudios() {
        return centroDeEstudios;
    }

    public void setCentroDeEstudios(String centroDeEstudios) {
        this.centroDeEstudios = centroDeEstudios;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getEntidadCertificaro() {
        return entidadCertificaro;
    }

    public void setEntidadCertificaro(String entidadCertificaro) {
        this.entidadCertificaro = entidadCertificaro;
    }
}
