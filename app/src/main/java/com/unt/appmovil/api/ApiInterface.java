package com.unt.appmovil.api;

import com.unt.appmovil.models.Respuesta;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("detail.php")
    Call<Respuesta> consultarEstado(
            @Body HashMap<String, String> map
    );
}
