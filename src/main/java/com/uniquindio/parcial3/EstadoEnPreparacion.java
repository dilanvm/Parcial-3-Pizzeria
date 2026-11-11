package com.uniquindio.parcial3;

public class EstadoEnPreparacion implements EstadoPedido {

    @Override
    public void asignar(Pedido p, Cocinero c) {
        System.out.println("[STATE] Accion no valida: El pedido ya tiene cocinero y esta En preparacion.");
    }

    @Override
    public void terminar(Pedido p) {
        p.cambiarEstado(new EstadoListo());
    }

    @Override
    public void entregar(Pedido p) {
        System.out.println("[STATE] Accion no valida: No se puede entregar un pedido que esta En preparacion.");
    }

    @Override
    public String getNombre() {
        return "En preparacion";
    }
}

