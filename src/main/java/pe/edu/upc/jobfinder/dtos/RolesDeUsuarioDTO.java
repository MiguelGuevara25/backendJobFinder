package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Usuario;

public class RolesDeUsuarioDTO {
    private String nombreRol;
    public int idUsuario;

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
