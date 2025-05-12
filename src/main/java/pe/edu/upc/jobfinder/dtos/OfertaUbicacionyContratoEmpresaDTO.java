package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Empresa;

public class OfertaUbicacionyContratoEmpresaDTO {private int id;

    private String name;

    private String typeofcontract;

    private String location;

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

    public String getTypeofcontract() {
        return typeofcontract;
    }

    public void setTypeofcontract(String typeofcontract) {
        this.typeofcontract = typeofcontract;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
