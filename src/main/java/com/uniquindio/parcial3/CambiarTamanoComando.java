package com.uniquindio.parcial3;

public class CambiarTamanoComando implements Comando{
    private Pedido pedido;
    private Tamano nuevoTamano;

    public CambiarTamanoComando(Pedido pedido, Tamano nuevoTamano) {
        this.pedido = pedido;
        this.nuevoTamano = nuevoTamano;
    }

    @Override
    public void ejecutar() {
        System.out.println("[COMMAND] Ejecutando CambiarTamanoComando (nuevo tamano: " + nuevoTamano + ")");
        pedido.guardarFoto();
        pedido.setTamano(nuevoTamano);
        pedido.notificarObservadores("tamano cambiado a " + nuevoTamano);
    }

    @Override
    public void deshacer() {
        System.out.println("[COMMAND] Deshaciendo CambiarTamanoComando");
        pedido.volverAFotoAnterior();
    }
}
