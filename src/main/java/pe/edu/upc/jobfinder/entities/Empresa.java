package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "namecompany", nullable = false, length = 100)
    private int name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "sector", nullable = false, length = 100)
    private String sector;
    @Column(name = "website", nullable = false, length = 100)
    private String website;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "telephone", nullable = false, length = 100)
    private double telephone;
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;
    @Column(name = "location", nullable = false, length = 100)
    private String location;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}
