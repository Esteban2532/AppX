package com.esteban.appx;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class RegistroComercioActivity extends AppCompatActivity {

    EditText correoComercio, nitEmpresa, RazonSocial;
    TextInputLayout campoPassword;
    AutoCompleteTextView campoSugerenciaCentro, campoSugerenciaProducto, campoSugerenciaLocalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_comercio);

        correoComercio = (EditText) findViewById(R.id.editTextCorreoComercio);
        nitEmpresa = (EditText)findViewById(R.id.editTextNit);
        RazonSocial = (EditText) findViewById(R.id.editTextRazoSocial);
        campoPassword = (TextInputLayout) findViewById(R.id.editTextPassword);
        campoSugerenciaCentro = (AutoCompleteTextView) findViewById(R.id.editCentroComercial);
        campoSugerenciaCentro = (AutoCompleteTextView) findViewById(R.id.editCentroComercial);
        campoSugerenciaCentro = (AutoCompleteTextView) findViewById(R.id.editCentroComercial);



    }

    public void onClick(View view) {
    }
}
