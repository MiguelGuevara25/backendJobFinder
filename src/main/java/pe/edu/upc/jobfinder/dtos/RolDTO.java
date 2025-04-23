package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.jobfinder.entities.Usuario;

public class RolDTO {

    private int idRol;
    private String nombreRol;
    public Usuario usuarioRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Usuario getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(Usuario usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}
