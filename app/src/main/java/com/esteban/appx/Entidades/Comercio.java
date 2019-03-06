package com.esteban.appx.Entidades;

import java.io.Serializable;

public class Comercio implements Serializable {
    private String email;
    private String password;
    private int nit;
    private String razonSocial;
    private String tipoProductos;
    private String ciudad;
    private String departamento;
    private String Pais;
    private boolean estado;

    public Comercio(String email, String password, int nit, String razonSocial, String tipoProductos, String ciudad, String departamento, String pais, boolean estado) {

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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(String tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
