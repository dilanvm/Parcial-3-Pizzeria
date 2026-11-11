package com.uniquindio.parcial3;

import java.util.List;

public class AsignacionPorMenosPedidos implements EstrategiaAsignacion {

    @Override
    public Cocinero elegirCocinero(List<Cocinero> cocinerosDelNivel, Pedido pedido) {
        if (cocinerosDelNivel == null || cocinerosDelNivel.isEmpty()) {
            return null;
        }
        Cocinero menor = cocinerosDelNivel.get(0);
        for (Cocinero c : cocinerosDelNivel) {
            if (c.getPedidosActivos() < menor.getPedidosActivos()) {
                menor = c;
            }
        }
        System.out.println("[STRATEGY] AsignacionPorMenosPedidos eligio a " + menor.getNombre() + " (" + menor.getPedidosActivos() + " pedidos activos)");
        return menor;
    }
}
