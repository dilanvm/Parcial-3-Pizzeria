package com.uniquindio.parcial3;

public class CrearPedidoComando implements Comando{
    private Mostrador mostrador;
    private Pedido pedido;

    public CrearPedidoComando(Mostrador mostrador, Pedido pedido) {
        this.mostrador = mostrador;
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND] Ejecutando CrearPedidoComando (Pedido #" + pedido.getId() + ")");
        mostrador.getPedidos().add(pedido);
    }

    @Override
    public void deshacer() {
        System.out.println("[COMMAND] Deshaciendo CrearPedidoComando (Removiendo pedido #" + pedido.getId() + ")");
        mostrador.getPedidos().remove(pedido);
    }
}
