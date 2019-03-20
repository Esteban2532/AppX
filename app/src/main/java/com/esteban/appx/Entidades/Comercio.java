package com.esteban.appx.Entidades;

import java.io.Serializable;

public class Comercio implements Serializable {
    private String email;
    private String password;
    private String nit;
    private String razonSocial;

    private boolean estado;

    public Comercio(String email, String password, String nit, String razonSocial, boolean estado) {

        this.email = email;
        this.password = password;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
