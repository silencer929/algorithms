package com.pizzaApp;

public class AbdiiOrder {
    private AbdiiToppingBase aziOrder;
    public AbdiiOrder(){
    }
    public double calculateTotal(){
        return aziOrder.getCost();
    }
    public void setAziOrder(AbdiiToppingBase aziOrder) {
        this.aziOrder = aziOrder;
    }

    public AbdiiToppingBase getAziOrder() {
        return aziOrder;
    }

    public void makeReceipt(){

    }
}
