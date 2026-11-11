package com.uniquindio.parcial3;

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
}
