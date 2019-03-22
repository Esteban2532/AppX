package com.esteban.appx;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.esteban.appx.Entidades.conexionSQLiteHelper;
import com.esteban.appx.Utilidades.Utilidades;

import java.util.regex.Pattern;

public class RegistroComercioActivity extends AppCompatActivity {

    EditText correoComercio, nitEmpresa, RazonSocial;
    TextInputLayout campoPassword;


    conexionSQLiteHelper conn;
    boolean cor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_comercio);


        nitEmpresa = (EditText) findViewById(R.id.editTextNit);
        RazonSocial = (EditText) findViewById(R.id.editTextRazoSocial);
        campoPassword = (TextInputLayout) findViewById(R.id.editTextPassword);
        correoComercio = (EditText) findViewById(R.id.editTextCorreoComercio);


    }

    public void onClick(View view) {
        Pattern letras = Pattern.compile(("^[a-zA-ZáÁéÉíÍóÓúÚñÑüÜ\\s]+$"));
        Pattern numeros = Pattern.compile("^[0-9]+$");


        if (nitEmpresa.getText().toString() == "" || numeros.matcher(nitEmpresa.getText().toString()).matches() == false) {
            nitEmpresa.setError("El campo esta vacio o no es un dato de tipo numerico");
        } else if (RazonSocial.getText().toString() == "" || letras.matcher(RazonSocial.getText().toString()).matches() == false) {
            RazonSocial.setError("El campo esta vacio o contiene caracteres no permitidos");
        } else if (Patterns.EMAIL_ADDRESS.matcher(correoComercio.getText().toString()).matches() == false) {
            correoComercio.setError("El correo ingresado no es valido");
            cor = false;
        } else {
            correoComercio.setError(null);
            cor = true;
            RegistrarComercio();
            borrarRegistros();
        }

    }

    private void borrarRegistros() {
        correoComercio.setText("");
        nitEmpresa.setText("");
        RazonSocial.setText("");
        campoPassword.getEditText().setText("");

    }

    private void RegistrarComercio() {
        conn = new conexionSQLiteHelper(getApplicationContext(), "bd_aplicacionx", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] parametros = {nitEmpresa.getText().toString()};
        String[] campos = {Utilidades.CAMPO_EMAIL};
        Cursor mcursor = db.query(Utilidades.TABLA_COMERCIO, campos, Utilidades.CAMPO_NIT +"=?", parametros,
                null, null, null);


        try {

            if (mcursor.moveToFirst()) {
                Toast.makeText(getApplicationContext(), "No se puede guardar la informacion, el usuario ya ha sido registrado", Toast.LENGTH_LONG).show();
                db.close();

            } else {
                conn = new conexionSQLiteHelper(getApplicationContext(), "bd_aplicacionx", null, 1);
                SQLiteDatabase db1 = conn.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(Utilidades.CAMPO_NIT, nitEmpresa.getText().toString());
                values.put(Utilidades.CAMPO_RAZONSOCIAL, RazonSocial.getText().toString());
                values.put(Utilidades.CAMPO_EMAIL_COMERCIO, correoComercio.getText().toString());
                values.put(Utilidades.CAMPO_PASSWORD_COMERCIO, campoPassword.getEditText().getText().toString());
                values.put(Utilidades.CAMPO_ESTADO, 0);
                db1.insert(Utilidades.TABLA_COMERCIO, Utilidades.CAMPO_EMAIL_COMERCIO, values) ;
                Toast.makeText(getApplicationContext(), "El usuario se registro con exito", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(RegistroComercioActivity.this,ModuloComercio.class);
                startActivity(intent);

            }
            db.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
