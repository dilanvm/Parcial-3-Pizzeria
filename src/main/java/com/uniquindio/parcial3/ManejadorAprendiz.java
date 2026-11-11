package com.uniquindio.parcial3;

public class ManejadorAprendiz extends ManejadorNivel{

        @Override
        public int manejar(Pedido pedido) {
            if (pedido.getTamano() == Tamano.PEQUENO) {
                System.out.println("[CHAIN] ManejadorAprendiz: tamano PEQUENA -> nivel 1 (Aprendiz)");
                return 1;
            }
            System.out.println("[CHAIN] ManejadorAprendiz: no corresponde, paso al siguiente");
            if (siguiente != null) {
                return siguiente.manejar(pedido);
            }
            return 0;
        }
}
