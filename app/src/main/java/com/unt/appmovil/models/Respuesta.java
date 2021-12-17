package com.unt.appmovil.models;

import com.google.gson.annotations.SerializedName;

public class Respuesta {
    @SerializedName("estado")
    private String estado;

    @SerializedName("dnicliente")
    private String dnicliente;

    @SerializedName("nombre")
    private String nombre;

    public Respuesta(String estado, String dnicliente, String nombre) {
        this.estado = estado;
        this.dnicliente = dnicliente;
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
