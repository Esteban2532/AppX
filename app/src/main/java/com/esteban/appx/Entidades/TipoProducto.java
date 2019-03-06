package com.esteban.appx.Entidades;

import java.io.Serializable;

public class TipoProducto implements Serializable {

    int codigo;
    String descripcion;

    public TipoProducto(int codigoTipoProducto, String descripcion) {
        this.codigo = codigoTipoProducto;
        this.descripcion = descripcion;
    }

    public int getCodigoTipoProducto() {
        return codigo;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigo = codigoTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }
}
