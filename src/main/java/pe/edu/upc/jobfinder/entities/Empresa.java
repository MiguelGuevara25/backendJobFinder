package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private int name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
}
