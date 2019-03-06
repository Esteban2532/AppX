package com.esteban.appx.Entidades;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.esteban.appx.Utilidades.Utilidades;

public class conexionSQLiteHelper extends SQLiteOpenHelper {

    public conexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_COMERCIO);
        db.execSQL(Utilidades.CREAR_TABLA_LOCALIDAD);
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTO);
        db.execSQL(Utilidades.CREAR_TABLA_CENTRO_COMERCIAL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_COMERCIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_LOCALIDAD);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_TIPO_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CENTRO_COMERCIAL);

        onCreate(db);

    }
}
