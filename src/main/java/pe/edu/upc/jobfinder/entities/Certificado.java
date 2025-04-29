package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Certificado")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCertificado;
    @Column(name = "nombreCertificado", nullable = false, length = 50)
    private String nombreCertificado;
    @Column(name = "entidadEmisoraCertificado", nullable = false, length = 50)
    private String entidadEmisoraCertificado;
    @Column(name = "fechaEmisionCertificado", nullable = false)
    private LocalDate fechaEmisionCertificado;
    @Column(name = "fechaVencimientoCertificado", nullable = false)
    private LocalDate fechaVencimientoCertificado;

    public Certificado() {
    }

    public Certificado(int idCertificado, String nombreCertificado, String entidadEmisoraCertificado, LocalDate fechaEmisionCertificado, LocalDate fechaVencimientoCertificado) {
        this.idCertificado = idCertificado;
        this.nombreCertificado = nombreCertificado;
        this.entidadEmisoraCertificado = entidadEmisoraCertificado;
        this.fechaEmisionCertificado = fechaEmisionCertificado;
        this.fechaVencimientoCertificado = fechaVencimientoCertificado;
    }

    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public String getEntidadEmisoraCertificado() {
        return entidadEmisoraCertificado;
    }

    public void setEntidadEmisoraCertificado(String entidadEmisoraCertificado) {
        this.entidadEmisoraCertificado = entidadEmisoraCertificado;
    }

    public LocalDate getFechaEmisionCertificado() {
        return fechaEmisionCertificado;
    }

    public void setFechaEmisionCertificado(LocalDate fechaEmisionCertificado) {
        this.fechaEmisionCertificado = fechaEmisionCertificado;
    }

    public LocalDate getFechaVencimientoCertificado() {
        return fechaVencimientoCertificado;
    }

    public void setFechaVencimientoCertificado(LocalDate fechaVencimientoCertificado) {
        this.fechaVencimientoCertificado = fechaVencimientoCertificado;
    }
}
