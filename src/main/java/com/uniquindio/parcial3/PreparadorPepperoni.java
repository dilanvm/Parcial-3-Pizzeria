package com.uniquindio.parcial3;

public class PreparadorPepperoni extends PreparadorPizza {

    @Override
    protected void ponerIngredientes() {
        System.out.println("[TEMPLATE] 3. Colocando queso mozzarella y abundante pepperoni...");
    }

    @Override
    protected void darToqueFinal() {
        System.out.println("[TEMPLATE] 4. Agregando un toque de aceite de oliva y oregano...");
    }
}
