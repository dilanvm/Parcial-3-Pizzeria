package com.uniquindio.parcial3;

public class Participante {
    protected String nombre;
    protected Mediador mediador;

    public Participante(String nombre, Mediador mediador) {
        this.nombre = nombre;
        this.mediador = mediador;
    }

    public String getNombre() {
        return nombre;
    }

    public Mediador getMediador() {
        return mediador;
    }
}
