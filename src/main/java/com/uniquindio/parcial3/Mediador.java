package com.uniquindio.parcial3;

public class Mediador {
    Pedido hacerPedido(Cliente c, TipoPizza tipo, Tamano tamano, int cantidad);
    void prepararPedido(Pedido p);
    void entregarPedido(Pedido p);
    void cambiarTamano(Pedido p, Tamano nuevo);
    void deshacerUltimaAccion();
}
