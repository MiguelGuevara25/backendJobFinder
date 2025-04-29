package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class CertificadoDTO {
    private int idCertificado;

    private String nombreCertificado;

    private String entidadEmisoraCertificado;

    private LocalDate fechaEmisionCertificado;

    private LocalDate fechaVencimientoCertificado;

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
