package com.uniquindio.parcial3;

public abstract class PreparadorPizza {

    // Metodo plantilla (final para no alterar la estructura del algoritmo)
    public final void preparar(Pedido p) {
        amasar();
        ponerSalsa();
        ponerIngredientes();
        darToqueFinal();
        hornear();
        empacar();
    }

    protected void amasar() {
        System.out.println("[TEMPLATE] 1. Amasando la base de pizza...");
    }

    protected void ponerSalsa() {
        System.out.println("[TEMPLATE] 2. Untando salsa de tomate artesanal...");
    }

    // Pasos abstractos que cada pizza concreta implementa a su manera
    protected abstract void ponerIngredientes();
    protected abstract void darToqueFinal();

    protected void hornear() {
        System.out.println("[TEMPLATE] 5. Horneando a 250 grados en horno de piedra...");
    }

    protected void empacar() {
        System.out.println("[TEMPLATE] 6. Cortando en porciones y empacando en caja termica.");
    }
}
