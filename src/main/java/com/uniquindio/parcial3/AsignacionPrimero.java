package com.uniquindio.parcial3;

import java.util.List;

public class AsignacionPrimero implements EstrategiaAsignacion {

    @Override
    public Cocinero elegirCocinero(List<Cocinero> cocinerosDelNivel, Pedido pedido) {
        if (cocinerosDelNivel == null || cocinerosDelNivel.isEmpty()) {
            return null;
        }
        Cocinero primero = cocinerosDelNivel.get(0);
        System.out.println("[STRATEGY] AsignacionPrimero eligio a " + primero.getNombre());
        return primero;
    }
}
