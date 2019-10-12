package com.example.tp_final_inmobiliaria.ui.inmuebles;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private int foto;
    private String direccion;
    private double precio;
    private String descripcion;
    private String tipo;

    public Inmueble(int foto, String direccion, double precio, String descripcion, String tipo) {
        this.foto = foto;
        this.direccion = direccion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

