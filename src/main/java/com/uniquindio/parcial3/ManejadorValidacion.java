package com.uniquindio.parcial3;

public class ManejadorValidacion extends ManejadorNivel{

        @Override
        public int manejar(Pedido pedido) {
            if (pedido.getCantidad() < 1) {
                System.out.println("[CHAIN] ManejadorValidacion: Pedido invalido (cantidad menor a 1). Solicitud rechazada.");
                return 0;
            }
            System.out.println("[CHAIN] ManejadorValidacion: pedido valido, paso al siguiente");
            if (siguiente != null) {
                return siguiente.manejar(pedido);
            }
            return 0;
        }
}
