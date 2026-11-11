package com.uniquindio.parcial3;

import java.util.ArrayList;
import java.util.List;

public class Mostrador implements Mediador{
    private List<Cocinero> cocineros;
    private List<Pedido> pedidos;
    private Dueno dueno;
    private HistorialComandos historial;
    private ManejadorNivel cadenaNiveles;
    private EstrategiaAsignacion estrategia;
    private int contadorId;

    public Mostrador() {
        this.cocineros = new ArrayList<Cocinero>();
        this.pedidos = new ArrayList<Pedido>();
        this.historial = new HistorialComandos();
        this.estrategia = new AsignacionPorMenosPedidos();
        this.contadorId = 1;

        // Construccion de la cadena de responsabilidad
        ManejadorValidacion val = new ManejadorValidacion();
        ManejadorAprendiz ap = new ManejadorAprendiz();
        ManejadorCocinero coc = new ManejadorCocinero();
        ManejadorChef chef = new ManejadorChef();

        val.setSiguiente(ap);
        ap.setSiguiente(coc);
        coc.setSiguiente(chef);
        this.cadenaNiveles = val;
    }

    public void agregarCocinero(Cocinero c) {
        this.cocineros.add(c);
    }

    public void setDueno(Dueno d) {
        this.dueno = d;
    }

    public void setEstrategia(EstrategiaAsignacion estrategia) {
        this.estrategia = estrategia;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Cocinero> getCocineros() {
        return cocineros;
    }

    @Override
    public Pedido hacerPedido(Cliente c, TipoPizza tipo, Tamano tamano, int cantidad) {
        System.out.println("[MEDIATOR] El mostrador recibio el pedido de " + c.getNombre() + ": " + cantidad + " " + tipo + " " + tamano);
        Pedido pedido = new Pedido(contadorId++, c, tipo, tamano, cantidad);

        // Registrar observadores: cliente y dueña
        pedido.agregarObservador(c);
        if (dueno != null) {
            pedido.agregarObservador(dueno);
        }

        // 1. Comando CrearPedido
        Comando cmdCrear = new CrearPedidoComando(this, pedido);
        historial.ejecutar(cmdCrear);

        // 2. Chain of Responsibility para determinar nivel
        int nivelRequerido = cadenaNiveles.manejar(pedido);
        if (nivelRequerido == 0) {
            System.out.println("[MEDIATOR] Pedido #" + pedido.getId() + " no pudo ser procesado por error en la validacion.");
            return pedido;
        }

        // Filtrar cocineros del nivel requerido
        List<Cocinero> candidatos = new ArrayList<Cocinero>();
        for (Cocinero cocinero : cocineros) {
            if (cocinero.getNivel() == nivelRequerido) {
                candidatos.add(cocinero);
            }
        }

        if (candidatos.isEmpty()) {
            System.out.println("[MEDIATOR] No hay cocineros registrados con nivel " + nivelRequerido);
            return pedido;
        }

        // 3. Strategy para elegir cocinero
        Cocinero elegido = estrategia.elegirCocinero(candidatos, pedido);

        // 4. Comando AsignarPedido (guarda Memento y cambia estado con State)
        Comando cmdAsignar = new AsignarPedidoComando(pedido, elegido);
        historial.ejecutar(cmdAsignar);

        return pedido;
    }

    @Override
    public void prepararPedido(Pedido p) {
        System.out.println("[MEDIATOR] El mostrador envia a preparar el pedido #" + p.getId());

        // Template Method: seleccion del preparador segun tipo de pizza
        PreparadorPizza preparador;
        if (p.getTipoPizza() == TipoPizza.QUESO) {
            preparador = new PreparadorQueso();
        } else if (p.getTipoPizza() == TipoPizza.PEPPERONI) {
            preparador = new PreparadorPepperoni();
        } else {
            preparador = new PreparadorHawaiana();
        }

        preparador.preparar(p);

        // Transicion de Estado: En preparacion -> Listo
        p.terminar();
    }

    @Override
    public void entregarPedido(Pedido p) {
        System.out.println("[MEDIATOR] El mostrador procede a entregar el pedido #" + p.getId());
        p.entregar();
    }

    @Override
    public void cambiarTamano(Pedido p, Tamano nuevo) {
        System.out.println("[MEDIATOR] Solicitando cambio de tamano del pedido #" + p.getId() + " a " + nuevo);
        Comando cmd = new CambiarTamanoComando(p, nuevo);
        historial.ejecutar(cmd);
    }

    @Override
    public void deshacerUltimaAccion() {
        System.out.println("[MEDIATOR] Solicitando al historial deshacer la ultima accion");
        historial.deshacerUltimo();
    }
}
