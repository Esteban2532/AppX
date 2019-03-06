package com.esteban.appx;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.esteban.appx.Entidades.conexionSQLiteHelper;
import com.esteban.appx.Utilidades.Utilidades;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    EditText campoUser, campoPassword;
    conexionSQLiteHelper conn;

    @Override
    //Nota
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUser = (EditText)findViewById(R.id.editTextUser);
        campoPassword = (EditText)findViewById(R.id.editTextPassword);

       conn = new conexionSQLiteHelper(getApplicationContext(), "bd_aplicacionx", null, 1);
    }

    public void onClick(View view) {
        Intent myintent = null;

        switch (view.getId()) {
            case R.id.buttonIngresar:
                SQLiteDatabase db=conn.getReadableDatabase();
                String[]parametros = {campoUser.getText().toString(), campoPassword.getText().toString()};
                String[]campos ={Utilidades.CAMPO_EMAIL, Utilidades.CAMPO_PASSWORD};
                Cursor mcursor = db.query("usuario", campos,"email = '"+ parametros[0]+"'"+
                                " AND password = '"+parametros[1]+"'",null,null,null,null );
                try {
                    if ( mcursor.moveToFirst()){
                        Intent intent = new Intent(MainActivity.this,IndexActiviy.class);
                        startActivity(intent);
                        //Log.i("dES", mcursor.getString(1));

                    }else{
                        Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
                    }

                }catch (SQLException e){
                    e.printStackTrace();

                }
                break;

            case R.id.textViewRegistro:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Como te deseas registrar");
                builder.setMessage("Elige una opcion");
                builder.setPositiveButton("Comercio", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,RegistroComercioActivity.class);
                        startActivity(intent);
                    }

                });
                builder.setNegativeButton("Usuario", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(MainActivity.this,RegistroUsuarioActivity.class);
                      startActivity(intent);
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
                break;


            case R.id.textRecuperarPassword:
                Intent intent = new Intent(MainActivity.this,RecuperarContrasenaActivity.class);
                startActivity(intent);
                break;

        }

        if(myintent!=null) {
            startActivity(myintent);

        }


    }

}
