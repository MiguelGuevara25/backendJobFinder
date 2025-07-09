package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Usuario;

public class RolDTO {

    private int id;
    private String rol;
    public Usuario user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
