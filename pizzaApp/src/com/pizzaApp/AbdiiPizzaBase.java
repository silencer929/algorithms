package com.pizzaApp;
import java.lang.*;
abstract public class AbdiiPizzaBase {
    protected String description;
    protected String pizzaName;
    private final double cost;

    public AbdiiPizzaBase(String pizzaName, double cost) {
        this.cost=cost;
        this.pizzaName=pizzaName;
    }
    public String getPizzaName(){
        return this.pizzaName;
    }

    public double getCost(){
        return this.cost;
    }
    public String getDescription(){
        return this.description;
    }
    abstract public void setDescription(String des);
}
