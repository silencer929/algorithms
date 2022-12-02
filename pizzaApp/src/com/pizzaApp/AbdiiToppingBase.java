package com.pizzaApp;

abstract public class AbdiiToppingBase {
    protected AbdiiPizzaBase pizza;
    protected double cost;
    protected String description;
    protected String toppingName;
    public AbdiiToppingBase(String name,double toppingCost){
        this.cost=toppingCost;
        this.toppingName=name;
    }
    abstract public void setDescription(String des);
    abstract  public void setPizza(AbdiiPizzaBase pizza);
    public String getDescription(){
        return this.pizza.getDescription()+"\n"+this.description;
    }
    public double getCost(){
        double total;
        total=this.pizza.getCost()+this.cost;
        return total;
    }
    public  double cost(){
        return this.cost;
    }

    public String getToppingName() {
        return toppingName;
    }


}
