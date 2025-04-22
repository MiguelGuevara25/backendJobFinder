package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_habilidad;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    public Habilidad() {
    }

    public Habilidad(int id_habilidad, String nombre) {
        this.id_habilidad = id_habilidad;
        this.nombre = nombre;
    }

    public int getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
