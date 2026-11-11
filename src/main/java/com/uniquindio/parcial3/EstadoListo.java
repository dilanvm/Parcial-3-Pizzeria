package com.uniquindio.parcial3;

public class EstadoListo implements EstadoPedido {

    @Override
    public void asignar(Pedido p, Cocinero c) {
        System.out.println("[STATE] Accion no valida: El pedido ya esta listo, no se puede reasignar.");
    }

    @Override
    public void terminar(Pedido p) {
        System.out.println("[STATE] Accion no valida: El pedido ya fue terminado.");
    }

    @Override
    public void entregar(Pedido p) {
        p.cambiarEstado(new EstadoEntregado());
        if (p.getCocineroAsignado() != null) {
            p.getCocineroAsignado().decrementarPedidos();
        }
    }

    @Override
    public String getNombre() {
        return "Listo";
    }
}
