package com.uniquindio.parcial3;

public class Dueno extends Participante implements Observador{
    public Dueno(String nombre, Mediador mediador) {
        super(nombre, mediador);
    }

    @Override
    public void actualizar(Pedido pedido, String mensaje) {
        System.out.println("[OBSERVER] -> [Duena " + nombre + "] Notificacion de pedido #" + pedido.getId() + ": " + mensaje);
    }
}
