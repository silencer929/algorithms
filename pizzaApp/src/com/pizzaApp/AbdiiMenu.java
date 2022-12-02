package com.pizzaApp;
import java.io.IOException;
import java.util.*;
import java.io.FileReader;
import java.io.File;
import java.lang.*;
public class AbdiiMenu {
    private ArrayList<String> AziPizzas= new ArrayList<String>();
    private ArrayList<String> AziToppings= new ArrayList<String>();
    private String AziCwd=System.getProperty("user.dir");//cwd stands for current working directory
    private ArrayList <AbdiiPizzaBase> pizzaUnoMenu=new ArrayList<AbdiiPizzaBase>();
    private ArrayList <AbdiiToppingBase> pizzaUnoToppingsMenu =new ArrayList<AbdiiToppingBase>();
    public AbdiiMenu() {
        this.setAziPizzas();
        this.setAziToppings();
        this.setPizzaUnoMenu();
        this.setPizzaUnoToppingsMenu();
    }
    public void setAziPizzas(){
        try {
            Scanner sc = new Scanner(new File(AziCwd+"/AziAbdiiPizza.csv"));
            sc.useDelimiter(";");
            while(sc.hasNext()){
                this.AziPizzas.add(sc.next());
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
   public void setAziToppings(){
        try{
        Scanner sc = new Scanner(new FileReader(AziCwd+"/AziAbdiiToppings.csv"));
        sc.useDelimiter(";");
        while(sc.hasNext()){
            this.AziToppings.add(sc.next());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setPizzaUnoMenu(){
        for (String aziPizza : this.AziPizzas) {
            Scanner sc=new Scanner(aziPizza);
            sc.useDelimiter(",");
            ArrayList<String> props= new ArrayList<String>();
            while(sc.hasNext()){
                props.add(sc.next());
            }
            sc.close();
            //initialize a new class object and set object properties
            AbdiiPizza p = new AbdiiPizza(props.get(0),Double.parseDouble(props.get(1)),props.get(2));
            this.pizzaUnoMenu.add(p);
            props.clear();
        }
    }
    public void setPizzaUnoToppingsMenu(){
        for(String topping: this.AziToppings){
         Scanner sc =new Scanner(topping);
         sc.useDelimiter(",");
         ArrayList<String> props= new ArrayList<String>();
         while(sc.hasNext()){
             props.add(sc.next());
         }
         sc.close();
         AbdiiToppingBase t= new AbdiiTopping(props.get(0),Double.parseDouble(props.get(1)),props.get(2));
         props.clear();
         this.pizzaUnoToppingsMenu.add(t);
        }

    }
    public ArrayList<AbdiiPizzaBase> getPizzaUnoMenu(){
        return this.pizzaUnoMenu;
    }
    public ArrayList<AbdiiToppingBase> getPizzaUnoToppingsMenu(){
        return this.pizzaUnoToppingsMenu;
    }
}

