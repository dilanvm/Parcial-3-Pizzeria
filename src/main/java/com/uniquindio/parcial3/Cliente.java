package com.uniquindio.parcial3;

public class Cliente extends Participante implements Observador{
    public Cliente(String nombre, Mediador mediador) {
        super(nombre, mediador);
    }

    public Pedido pedirPizza(TipoPizza tipo, Tamano tamano, int cantidad) {
        return mediador.hacerPedido(this, tipo, tamano, cantidad);
    }

    @Override
    public void actualizar(Pedido pedido, String mensaje) {
        System.out.println("[OBSERVER] -> [Cliente " + nombre + "] Tu pedido #" + pedido.getId() + " ahora esta: " + mensaje);
    }
}
