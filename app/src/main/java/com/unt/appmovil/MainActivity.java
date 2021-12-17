package com.unt.appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unt.appmovil.api.ApiClient;
import com.unt.appmovil.models.Respuesta;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static Respuesta Data;

    String _dni;
    EditText dni;
    Button btnConsult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dni=findViewById(R.id.txtdni);
        btnConsult=findViewById(R.id.btnConsult);

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _dni=dni.getText().toString();
                if (_dni.isEmpty())
                {
                    dni.requestFocus();
                    dni.setError("Ingrese DNI");
                    return;
                }
                fnConsultar();

            }
        });
    }
    private void fnConsultar()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("dni", _dni);
        System.out.println("Rest1"+_dni);
        Call<Respuesta> call = ApiClient.getApiService().consultarEstado(map);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                //System.out.println("Rest2");
                if(response.body() != null && response.isSuccessful()){
                   Data = response.body();
                   //System.out.println("Rest:"+Data);
                    //progressDialog.dismiss();
                    if(Data.getEstado() != ""){
                        Intent intent = new Intent(MainActivity.this, Mensaje.class); //cierra actividad y lleva a otra
                        startActivity(intent);
                        finish();
                    }
                } else{
                    //progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Ocurrio un error.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                //progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Datos ingresados incorrectos.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}