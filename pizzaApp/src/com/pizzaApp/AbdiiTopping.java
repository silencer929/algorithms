package com.pizzaApp;

public class AbdiiTopping extends AbdiiToppingBase {
    public AbdiiTopping(String name, double cost,String des) {
        super(name,cost);
        this.setDescription(des);
    }

    @Override
    public void setDescription(String des) {
        this.description=des;
    }
    @Override
    public void setPizza(AbdiiPizzaBase pizza) {
        this.pizza= pizza;
    }

}
