package com.example.betsysanchez.a58_provedordecontenidos_calllog;

/**
 * Created by BetsySanchez on 20/05/2018.
 */

public class Call {
    String nombre,numero,duracion,tipo;

    public Call(String nombre, String numero, String duracion, String tipo) {
        this.nombre = nombre;
        this.numero = numero;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
