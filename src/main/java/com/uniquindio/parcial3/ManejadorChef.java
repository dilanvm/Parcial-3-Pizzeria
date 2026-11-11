package com.uniquindio.parcial3;

public class ManejadorChef {
    @Override
    public int manejar(Pedido pedido) {
        if (pedido.getTamano() == Tamano.GRANDE) {
            System.out.println("[CHAIN] ManejadorChef: tamano GRANDE -> nivel 3 (Chef)");
            return 3;
        }
        System.out.println("[CHAIN] ManejadorChef: no corresponde al nivel");
        if (siguiente != null) {
            return siguiente.manejar(pedido);
        }
        return 0;
    }
}
