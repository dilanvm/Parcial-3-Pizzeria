package com.uniquindio.parcial3;

public class ManejadorCocinero extends ManejadorNivel{
    @Override
    public int manejar(Pedido pedido) {
        if (pedido.getTamano() == Tamano.MEDIANA) {
            System.out.println("[CHAIN] ManejadorCocinero: tamano MEDIANA -> nivel 2 (Cocinero)");
            return 2;
        }
        System.out.println("[CHAIN] ManejadorCocinero: no corresponde, paso al siguiente");
        if (siguiente != null) {
            return siguiente.manejar(pedido);
        }
        return 0;
    }
}
