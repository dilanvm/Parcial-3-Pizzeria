package com.uniquindio.parcial3;

import java.util.List;

public interface EstrategiaAsignacion {
    Cocinero elegirCocinero(List<Cocinero> cocinerosDelNivel, Pedido pedido);
}
