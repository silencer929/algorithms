package com.pizzaApp;

public class AbdiiPizza extends AbdiiPizzaBase {

    public AbdiiPizza(String pizzaName, double cost,String des) {
        super( pizzaName, cost);
        this.setDescription(des);
    }

    @Override
    public void setDescription(String des) {
        this.description = des;
    }
}
