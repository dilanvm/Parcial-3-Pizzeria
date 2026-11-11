package com.uniquindio.parcial3;

public class AsignarPedidoComando implements Comando{
    private Pedido pedido;
    private Cocinero cocinero;

    public AsignarPedidoComando(Pedido pedido, Cocinero cocinero) {
        this.pedido = pedido;
        this.cocinero = cocinero;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND] Ejecutando AsignarPedidoComando a " + cocinero.getNombre());
        pedido.guardarFoto();
        cocinero.incrementarPedidos();
        pedido.asignar(cocinero);
    }

    @Override
    public void deshacer() {
        System.out.println("[COMMAND] Deshaciendo AsignarPedidoComando de " + cocinero.getNombre());
        cocinero.decrementarPedidos();
        pedido.volverAFotoAnterior();
    }
}
