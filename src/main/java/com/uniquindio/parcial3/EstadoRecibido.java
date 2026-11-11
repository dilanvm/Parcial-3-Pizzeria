package com.uniquindio.parcial3;

public class EstadoRecibido implements EstadoPedido {

    @Override
    public void asignar(Pedido p, Cocinero c) {
        p.setCocineroAsignado(c);
        p.cambiarEstado(new EstadoEnPreparacion());
    }

    @Override
    public void terminar(Pedido p) {
        System.out.println("[STATE] Accion no valida: No se puede terminar un pedido Recibido sin asignar ni preparar.");
    }

    @Override
    public void entregar(Pedido p) {
        System.out.println("[STATE] Accion no valida: No se puede entregar un pedido que apenas fue Recibido.");
    }

    @Override
    public String getNombre() {
        return "Recibido";
    }
}