package com.esteban.appx.Utilidades;

import android.net.wifi.aware.PublishConfig;

public class Utilidades {

    //Campos de usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_EMAIL="email";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_PASSWORD="password";
    public static final String CAMPO_LOCALIDAD="localidad";


    public static String CREAR_TABLA_USUARIO = "CREATE TABLE "+
            "" + TABLA_USUARIO + " ("+CAMPO_EMAIL+" TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "
            +CAMPO_PASSWORD+" TEXT, "+CAMPO_LOCALIDAD+" TEXT) ";


    //Crear comercio
    public static final String TABLA_COMERCIO="comercio";
    public static final String CAMPO_EMAIL_COMERCIO="email";
    public static final String CAMPO_PASSWORD_COMERCIO="password";
    public static final String CAMPO_NIT="nit";
    public static final String CAMPO_RAZONSOCIAL="razonSocial";
    public static final String CAMPO_ESTADO="estado";


    public static String CREAR_TABLA_COMERCIO = "CREATE TABLE "+
            "" + TABLA_COMERCIO + " ("+CAMPO_EMAIL_COMERCIO+" TEXT, "+CAMPO_PASSWORD_COMERCIO+" TEXT, "+CAMPO_NIT+" INTEGER, "
            +CAMPO_RAZONSOCIAL+" TEXT, "+CAMPO_ESTADO+" BOOLEAN) ";



    public static final String TABLA_LOCALIDAD="localidad";
    public static final String CAMPO_CODIGO_LOCALIDAD="codigoLocalidad";
    public static final String CAMPO_DESCRIPCION_LOCALIDAD="localidad";


    public static String CREAR_TABLA_LOCALIDAD = "CREATE TABLE "+
            "" + TABLA_LOCALIDAD + " ("+CAMPO_CODIGO_LOCALIDAD+" INTEGER, "+CAMPO_DESCRIPCION_LOCALIDAD+" TEXT) ";




    public static final String TABLA_CENTRO_COMERCIAL = "centroComercial";
    public static final String CAMPO_CODIGO_CCIAL = "codigoCcial";
    public static final String CAMPO_NOMBRE_CCIAL = "nombre";
    public static final String CAMPO_FK_CODIGO_LOCALIDAD="codigoLocalidad";

    public static String CREAR_TABLA_CENTRO_COMERCIAL = "CREATE TABLE "+
            "" + TABLA_CENTRO_COMERCIAL + " ("+CAMPO_CODIGO_CCIAL+" INTEGER, "+CAMPO_NOMBRE_CCIAL+" TEXT, "+CAMPO_FK_CODIGO_LOCALIDAD+" INTEGER) ";



    public static final String TABLA_TIPO_PRODUCTO = "tipoProducto";
    public static final String CAMPO_CODIGO_TIPO_PRODUCTO = "codigo";
    public static final String CAMPO_DESCRIPCION_PRODUCTO = "descripcion";

    public static String CREAR_TABLA_PRODUCTO = "CREATE TABLE "+
            "" + TABLA_TIPO_PRODUCTO + " ("+CAMPO_CODIGO_TIPO_PRODUCTO+" INTEGER, "+CAMPO_DESCRIPCION_PRODUCTO+" TEXT) ";





}
