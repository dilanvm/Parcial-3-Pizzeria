package com.uniquindio.parcial3;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTION - PIZZERIA MAMMA MIA        ");
        System.out.println("==================================================");

        // 1. Configuracion inicial del sistema (Mediador y Participantes)
        Mostrador mostrador = new Mostrador();

        Dueno donaRosa = new Dueno("Dona Rosa", mostrador);
        mostrador.setDueno(donaRosa);

        Cocinero pepe = new Cocinero("Pepe", 1, mostrador);
        Cocinero ana = new Cocinero("Ana", 1, mostrador);
        Cocinero lola = new Cocinero("Lola", 2, mostrador);
        Cocinero carlos = new Cocinero("Carlos", 3, mostrador);

        mostrador.agregarCocinero(pepe);
        mostrador.agregarCocinero(ana);
        mostrador.agregarCocinero(lola);
        mostrador.agregarCocinero(carlos);

        Cliente camilo = new Cliente("Camilo", mostrador);
        Cliente valentina = new Cliente("Valentina", mostrador);

        // ===== ESCENA 1: Caso principal (Pasa por los 8 patrones) =====
        System.out.println("\n===== ESCENA 1: Flujo completo de un pedido valido (8 patrones) =====");
        Pedido pedido1 = camilo.pedirPizza(TipoPizza.PEPPERONI, Tamano.PEQUENO, 1);
        mostrador.prepararPedido(pedido1);
        mostrador.entregarPedido(pedido1);

        // ===== ESCENA 2: Cambio dinamico de Strategy y pedido de nivel 3 (Chef) =====
        System.out.println("\n===== ESCENA 2: Cambio dinamico de estrategia y otro nivel =====");
        System.out.println("[CONFIG] Cambiando estrategia del mostrador a AsignacionPrimero...");
        mostrador.setEstrategia(new AsignacionPrimero());
        Pedido pedido2 = valentina.pedirPizza(TipoPizza.HAWAIANA, Tamano.GRANDE, 2);

        // ===== ESCENA 3: Pedido invalido (Chain of Responsibility corta el flujo) =====
        System.out.println("\n===== ESCENA 3: Pedido invalido =====");
        camilo.pedirPizza(TipoPizza.QUESO, Tamano.MEDIANA, 0);

        // ===== ESCENA 4: Deshacer accion (Command + Memento) =====
        System.out.println("\n===== ESCENA 4: Deshacer (Command + Memento) =====");
        System.out.println("Tamano actual del pedido #2: " + pedido2.getTamano());
        mostrador.cambiarTamano(pedido2, Tamano.MEDIANA);
        System.out.println("Tamano despues de cambiar: " + pedido2.getTamano());
        mostrador.deshacerUltimaAccion();
        System.out.println("Tamano despues de deshacer: " + pedido2.getTamano());

        // ===== ESCENA 5: Transicion invalida (State) =====
        System.out.println("\n===== ESCENA 5: Transicion invalida (State) =====");
        System.out.println("Estado actual del pedido #2: " + pedido2.getEstado().getNombre());
        mostrador.entregarPedido(pedido2);

        System.out.println("\n==================================================");
        System.out.println("   SIMULACION FINALIZADA CON EXITO                ");
        System.out.println("==================================================");
    }
}

