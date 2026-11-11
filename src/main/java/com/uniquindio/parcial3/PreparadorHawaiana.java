package com.uniquindio.parcial3;

public class PreparadorHawaiana extends PreparadorPizza {

    @Override
    protected void ponerIngredientes() {
        System.out.println("[TEMPLATE] 3. Agregando queso mozzarella, jamon en cubos y pina dulce...");
    }

    @Override
    protected void darToqueFinal() {
        System.out.println("[TEMPLATE] 4. Agregando toque agridulce especial de la casa...");
    }
}
