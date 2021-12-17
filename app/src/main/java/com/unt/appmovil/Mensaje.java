package com.unt.appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mensaje extends AppCompatActivity {
    TextView estado,dni,nombre;
    Button btnReturn;
    MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        estado=findViewById(R.id.txtEstado);
        //dni=findViewById(R.id.txtdni);
        nombre=findViewById(R.id.txtNombres);
        btnReturn=findViewById(R.id.btnVolver);

        fnConsultar();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mensaje.this, MainActivity.class); //cierra actividad y lleva a otra
                startActivity(intent);
                finish();
            }
        });
    }
    private void fnConsultar()
    {
        estado.setText(mainActivity.Data.getEstado());
        //dni.setText(mainActivity.Data.getDnicliente());
        nombre.setText(mainActivity.Data.getNombre());
    }
}