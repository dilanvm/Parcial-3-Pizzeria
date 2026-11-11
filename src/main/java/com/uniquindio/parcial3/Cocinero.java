package com.uniquindio.parcial3;

public class Cocinero extends Participante{
    private int nivel;
    private int pedidosActivos;

    public Cocinero(String nombre, int nivel, Mediador mediador) {
        super(nombre, mediador);
        this.nivel = nivel;
        this.pedidosActivos = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPedidosActivos() {
        return pedidosActivos;
    }

    public void incrementarPedidos() {
        this.pedidosActivos++;
    }

    public void decrementarPedidos() {
        if (this.pedidosActivos > 0) {
            this.pedidosActivos--;
        }
    }
}
