package com.uniquindio.parcial3;

public class EstadoEntregado implements EstadoPedido {

    @Override
    public void asignar(Pedido p, Cocinero c) {
        System.out.println("[STATE] Accion no valida: El pedido ya fue entregado.");
    }

    @Override
    public void terminar(Pedido p) {
        System.out.println("[STATE] Accion no valida: El pedido ya fue entregado.");
    }

    @Override
    public void entregar(Pedido p) {
        System.out.println("[STATE] Accion no valida: El pedido ya fue entregado previamente.");
    }

    @Override
    public String getNombre() {
        return "Entregado";
    }
}

