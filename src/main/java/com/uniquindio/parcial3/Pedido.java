package com.uniquindio.parcial3;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private TipoPizza tipoPizza;
    private Tamano tamano;
    private int cantidad;
    private Cocinero cocineroAsignado;
    private EstadoPedido estado;
    private List<Observador> observadores;
    private CuidadorMementos cuidadorMementos;

    public Pedido(int id, Cliente cliente, TipoPizza tipoPizza, Tamano tamano, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.cocineroAsignado = null;
        this.estado = new EstadoRecibido();
        this.observadores = new ArrayList<Observador>();
        this.cuidadorMementos = new CuidadorMementos();
    }
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    public void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(this, mensaje);
        }
    }

    // --- Patron State (Contexto y delegacion) ---
    public void cambiarEstado(EstadoPedido nuevoEstado) {
        System.out.println("[STATE] Pedido #" + id + ": " + this.estado.getNombre() + " -> " + nuevoEstado.getNombre());
        this.estado = nuevoEstado;
        notificarObservadores(nuevoEstado.getNombre());
    }

    public void asignar(Cocinero c) {
        estado.asignar(this, c);
    }

    public void terminar() {
        estado.terminar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    // --- Patron Memento (Originador) ---
    public PedidoMemento crearMemento() {
        return new PedidoMemento(estado, cocineroAsignado, tamano);
    }

    public void restaurarDesdeMemento(PedidoMemento m) {
        this.estado = m.getEstado();
        this.cocineroAsignado = m.getCocineroAsignado();
        this.tamano = m.getTamano();
        System.out.println("[MEMENTO] Pedido #" + id + " restaurado: Estado=" + estado.getNombre() + ", Tamano=" + tamano);
        notificarObservadores("Se deshizo el ultimo cambio");
    }

    public void guardarFoto() {
        System.out.println("[MEMENTO] Se guardo una foto del pedido #" + id);
        cuidadorMementos.guardar(crearMemento());
    }

    public void volverAFotoAnterior() {
        PedidoMemento m = cuidadorMementos.recuperarUltimo();
        if (m != null) {
            restaurarDesdeMemento(m);
        } else {
            System.out.println("[MEMENTO] No hay fotos previas para el pedido #" + id);
        }
    }

    // --- Getters y Setters ---
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoPizza getTipoPizza() {
        return tipoPizza;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Cocinero getCocineroAsignado() {
        return cocineroAsignado;
    }

    public void setCocineroAsignado(Cocinero cocineroAsignado) {
        this.cocineroAsignado = cocineroAsignado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
