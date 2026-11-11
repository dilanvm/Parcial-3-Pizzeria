package com.uniquindio.parcial3;

public class PreparadorQueso extends PreparadorPizza {

    @Override
    protected void ponerIngredientes() {
        System.out.println("[TEMPLATE] 3. Agregando triple queso mozzarella y parmesano...");
    }

    @Override
    protected void darToqueFinal() {
        System.out.println("[TEMPLATE] 4. Espolvoreando finas hierbas y oregano...");
    }
}
