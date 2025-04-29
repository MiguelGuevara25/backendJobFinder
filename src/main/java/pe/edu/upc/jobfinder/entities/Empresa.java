package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "namecompany", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "sector", nullable = false, length = 100)
    private String sector;
    @Column(name = "website", nullable = false, length = 100)
    private String website;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "telephone", nullable = false, length = 100)
    private String telephone;
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;
    @Column(name = "location", nullable = false, length = 100)
    private String location;
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    public Empresa() {
    }

    public Empresa(int id, String name, String description, String sector, String website, String address, String telephone, String mail, String location, String password) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sector = sector;
        this.website = website;
        this.address = address;
        this.telephone = telephone;
        this.mail = mail;
        this.location = location;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
