package com.uniquindio.parcial3;

public interface EstadoPedido {
    void asignar(Pedido p, Cocinero c);
    void terminar(Pedido p);
    void entregar(Pedido p);
    String getNombre();
}
