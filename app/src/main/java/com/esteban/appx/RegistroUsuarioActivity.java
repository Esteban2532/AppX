package com.esteban.appx;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.esteban.appx.Entidades.conexionSQLiteHelper;
import com.esteban.appx.Utilidades.Utilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText campoCorreo, campoNombre, campoApellido;
    TextInputLayout campoPassword;
    AutoCompleteTextView campoSugerencia;

    conexionSQLiteHelper conn;
    boolean cor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        campoCorreo = (EditText) findViewById(R.id.editTextCorreo);
        campoNombre = (EditText) findViewById(R.id.editTextNombre);
        campoApellido = (EditText) findViewById(R.id.editTextApellido);
        campoSugerencia = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextLocalidad);
        campoPassword = (TextInputLayout) findViewById(R.id.editTextPassword);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Localidad);
        campoSugerencia.setAdapter(adaptador);

        conn = new conexionSQLiteHelper(getApplicationContext(), "bd_aplicacionx", null, 1);
    }

    public void evento(View view) {
        Pattern letras = Pattern.compile(("^[a-zA-ZáÁéÉíÍóÓúÚñÑüÜ\\s]+$"));
        //Pattern numeros = Pattern.compile("");

        if (Patterns.EMAIL_ADDRESS.matcher(campoCorreo.getText().toString()).matches() == false) {
            campoCorreo.setError("El correo ingresado no es valido");
            cor = false;
        } else if (campoNombre.getText().toString() == "" || letras.matcher(campoNombre.getText().toString()).matches() == false) {
            campoNombre.setError("El campo esta vacio o contiene caracteres no permitidos");
        } else if (campoApellido.getText().toString() == "" || letras.matcher(campoApellido.getText().toString()).matches() == false) {
            campoApellido.setError("El campo esta vacio o contiene caracteres no permitidos");
        } else if (campoSugerencia.getText().toString() == "") {
            campoSugerencia.setError("El campo esta vacio");

        } else {

            campoCorreo.setError(null);
            cor = true;
            RegistrarUsuario();
            borrarRegistros();

        }
    }

    private void borrarRegistros() {
        campoCorreo.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoPassword.getEditText().setText("");
        campoSugerencia.setText("");

    }

    private void RegistrarUsuario() {

        conexionSQLiteHelper conn = new conexionSQLiteHelper(RegistroUsuarioActivity.this, "bd_aplicacionx", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] parametros = {campoCorreo.getText().toString()};
        String[] campos = {Utilidades.CAMPO_EMAIL};
        Cursor mcursor = db.query("usuario", campos, "email = '" + parametros[0] + "" +
                "'", null, null, null, null);


        try {

            if (mcursor.moveToFirst()) {
                Toast.makeText(getApplicationContext(), "No se puede guardar la informacion, el usuario ya ha sido registrado", Toast.LENGTH_LONG).show();


            } else {
                //SQLiteDatabase db = conn.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put(Utilidades.CAMPO_EMAIL, campoCorreo.getText().toString());
                values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
                values.put(Utilidades.CAMPO_APELLIDO, campoApellido.getText().toString());
                values.put(Utilidades.CAMPO_PASSWORD, campoPassword.getEditText().getText().toString());
                values.put(Utilidades.CAMPO_LOCALIDAD, campoSugerencia.getText().toString());

                Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_EMAIL, values);

                Toast.makeText(getApplicationContext(), "El usuario se registro con exito", Toast.LENGTH_LONG).show();

            }
            db.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static String[] Localidad = {
            "Colombia/Antioquia/Medellin",
            "Colombia/Antioquea/Envigado",
            "Colombia/Antioquia/Sabaneta",
            "Colombia/Antioquia/Bello",
            "Colombia/Antioquia/Itagui",
            "Colombia/Cundinamarca/Bogota",
            "Colombia/Cundinamarca/Chia",
            "Colombia/Caldas/Manizales",
            "Colombia/Risaralda/Pereira",
            "Colombia/Valle/Cali"

    };

}


