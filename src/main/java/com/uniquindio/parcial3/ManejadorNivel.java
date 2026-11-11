package com.uniquindio.parcial3;

public abstract class ManejadorNivel {
        protected ManejadorNivel siguiente;

        public void setSiguiente(ManejadorNivel siguiente) {
            this.siguiente = siguiente;
        }

        public abstract int manejar(Pedido pedido);
    }

