package com.uniquindio.parcial3;

import java.util.Stack;

public class HistorialComandos {
    private Stack<Comando> historial;

    public HistorialComandos() {
        this.historial = new Stack<Comando>();
    }

    public void ejecutar(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            Comando ultimo = historial.pop();
            ultimo.deshacer();
        } else {
            System.out.println("[COMMAND] No hay acciones en el historial para deshacer.");
        }
    }
}
