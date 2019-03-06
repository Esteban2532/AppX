package com.esteban.appx.Entidades;

import java.io.Serializable;

public class CentroComercial implements Serializable {

    int codigoCcial;
    String nombre;
    int codigoLocalidad;

    public CentroComercial(int codigoCcial, String nombre, int codigoLocalidad) {
        this.codigoCcial = codigoCcial;
        this.nombre = nombre;
        this.codigoLocalidad = codigoLocalidad;
    }

    public int getCodigoCcial() {
        return codigoCcial;
    }

    public void setCodigoCcial(int codigoCcial) {
        this.codigoCcial = codigoCcial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(int codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }
}
