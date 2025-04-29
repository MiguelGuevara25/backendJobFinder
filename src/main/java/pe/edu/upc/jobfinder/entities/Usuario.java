package pe.edu.upc.jobfinder.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombre", nullable = false, length = 250)
    private String nombreUsuario;

    @Column(name = "apellido", nullable = false, length = 250)
    private String apellidoUsuario;

    @Column(name = "correo", nullable = false, length = 250)
    private String correoUsuario;

    @Column(name = "telefono", nullable = false)
    private int telefonoUsuario;

    @Column(name = "direccion", nullable = false, length = 250)
    private String direccionUsuario;

    @Column(name = "estado", nullable = false)
    private boolean estadoUsuario;

    @Column(name = "usuario", nullable = false, length = 250)
    private String usuarioUsuario;

    @Column(name = "contrasenia", nullable = false, length = 250)
    private String contraseniaUsuario;

    @Column(name = "favorito", nullable = false)
    private boolean favoritoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario, int telefonoUsuario, String direccionUsuario, boolean estadoUsuario, String usuarioUsuario, String contraseniaUsuario, boolean favoritoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.estadoUsuario = estadoUsuario;
        this.usuarioUsuario = usuarioUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.favoritoUsuario = favoritoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(String usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public boolean isFavoritoUsuario() {
        return favoritoUsuario;
    }

    public void setFavoritoUsuario(boolean favoritoUsuario) {
        this.favoritoUsuario = favoritoUsuario;
    }
}
