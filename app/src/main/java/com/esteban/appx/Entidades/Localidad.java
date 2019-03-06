package com.esteban.appx.Entidades;

import java.io.Serializable;

public class Localidad implements Serializable {
    int codigoLocalidad;
    String localidad;

    public Localidad(int codigoLocalidad, String localidad) {
        this.codigoLocalidad = codigoLocalidad;
        this.localidad = localidad;
    }

    public Localidad(){}

    public int getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(int codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
