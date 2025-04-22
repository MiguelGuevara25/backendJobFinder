package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombre", nullable = false,length = 250)
    private String nombreRol;

    @ManyToOne
    @Column(name = "usuario")
    public Usuario usuarioRol;

    public Rol() {
    }

    public Rol(int idRol, String nombreRol, Usuario usuarioRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.usuarioRol = usuarioRol;
    }

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
