package com.esteban.appx.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String email;
    private String nombre;
    private String apellido;
    private String password;
    private String ciudad;
    private String departamento;
    private String pais;

    public Usuario(String correo, String nombre, String apellido, String password, String ciudad, String departamento, String pais) {
        this.email = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }



}
