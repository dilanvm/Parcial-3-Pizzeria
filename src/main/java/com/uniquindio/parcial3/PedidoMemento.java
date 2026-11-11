package com.uniquindio.parcial3;

public class PedidoMemento {
    private final EstadoPedido estado;
    private final Cocinero cocineroAsignado;
    private final Tamano tamano;

    public PedidoMemento(EstadoPedido estado, Cocinero cocineroAsignado, Tamano tamano) {
        this.estado = estado;
        this.cocineroAsignado = cocineroAsignado;
        this.tamano = tamano;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Cocinero getCocineroAsignado() {
        return cocineroAsignado;
    }

    public Tamano getTamano() {
        return tamano;
    }
}
