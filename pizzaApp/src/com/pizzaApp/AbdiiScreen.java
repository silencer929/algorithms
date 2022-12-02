package com.pizzaApp;
import java.util.*;
import java.lang.Integer;
public class AbdiiScreen {
    public static AbdiiPizzaBase aziPizzaOrder;
    public static void display(){
        String banner="""
                ,-.----.                                                                                                                                              \s
                \\    /  \\                                                                                                                ,---,                        \s
                |   :    \\   ,--,                                                                                                      ,--.' |              ,-.----.  \s
                |   |  .\\ :,--.'|          ,----,       ,----,                            ,--,      ,---,    ,---.                     |  |  :       ,---.  \\    /  \\ \s
                .   :  |: ||  |,         .'   .`|     .'   .`|                          ,'_ /|  ,-+-. /  |  '   ,'\\           .--.--.  :  :  :      '   ,'\\ |   :    |\s
                |   |   \\ :`--'_      .'   .'  .'  .'   .'  .' ,--.--.             .--. |  | : ,--.'|'   | /   /   |         /  /    ' :  |  |,--. /   /   ||   | .\\ :\s
                |   : .   /,' ,'|   ,---, '   ./ ,---, '   ./ /       \\          ,'_ /| :  . ||   |  ,"' |.   ; ,. :        |  :  /`./ |  :  '   |.   ; ,. :.   : |: |\s
                ;   | |`-' '  | |   ;   | .'  /  ;   | .'  / .--.  .-. |         |  ' | |  . .|   | /  | |'   | |: :        |  :  ;_   |  |   /' :'   | |: :|   |  \\ :\s
                |   | ;    |  | :   `---' /  ;--,`---' /  ;--,\\__\\/: . .         |  | ' |  | ||   | |  | |'   | .; :         \\  \\    `.'  :  | | |'   | .; :|   : .  |\s
                :   ' |    '  : |__   /  /  / .`|  /  /  / .`|," .--.; |         :  | : ;  ; ||   | |  |/ |   :    |          `----.   \\  |  ' | :|   :    |:     |`-'\s
                :   : :    |  | '.'|./__;     .' ./__;     .'/  /  ,.  |         '  :  `--'   \\   | |--'   \\   \\  /          /  /`--'  /  :  :_:,' \\   \\  / :   : :   \s
                |   | :    ;  :    ;;   |  .'    ;   |  .'  ;  :   .'   \\        :  ,      .-./   |/        `----'          '--'.     /|  | ,'      `----'  |   | :   \s
                `---'.|    |  ,   / `---'        `---'      |  ,     .-./         `--`----'   '---'                           `--'---' `--''                `---'.|   \s
                  `---`     ---`-'                           `--`---'                                                                                         `---`\s
                                   welcome to pizza uno shop!!! order a Pizza and get instant delivery
                """;
       System.out.println(banner);
    }
    public static void  orderPizza(){
        // display menu
        AbdiiMenu menu =new AbdiiMenu();
        System.out.println("Order A pizza and get instant delivery");
        System.out.println("------------------- Our menu---------------------------------");
        int count=1;
        for (AbdiiPizzaBase menuItem: menu.getPizzaUnoMenu()){
            System.out.println("("+count +") "+menuItem.getPizzaName()+" price: $"+menuItem.getCost()+"\n");
            count++;
        }
        //place order
        int order;
        Scanner sc=new Scanner(System.in);
        System.out.println("place order( enter number): ");
        order=sc.nextInt();
        //display the chosen pizza to the customer as his order
        if (order <= count && order>=0){
            System.out.println("============== your pizza:"+menu.getPizzaUnoMenu().get(order-1).getPizzaName());
            aziPizzaOrder=menu.getPizzaUnoMenu().get(order-1);
            doToppings();
        }else{
            System.out.println("Invalid Choice");
        }
    }
    public static void doToppings(){
        AbdiiMenu menu =new AbdiiMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select toppings from menu");
        System.out.println("-------------------Our Available Toppings---------------");
        String[] toppings;
        int topping_count = 1;
        for (AbdiiToppingBase topping : menu.getPizzaUnoToppingsMenu()) {
            System.out.println("(" + topping_count + ") " + topping.getToppingName()+"  price: $"+topping.cost());
            topping_count++;
        }
        System.out.println("select Multiple toppings using a comma to separate values e.g 1,2");
        String input = sc.nextLine();
        toppings=input.split(",");
        for(int i=0; i< toppings.length;i++){
            int t= Integer.parseInt(toppings[i]);
            if(t<=topping_count && t>0){
                AbdiiToppingBase order= menu.getPizzaUnoToppingsMenu().get(t-1);
                order.setPizza(aziPizzaOrder);
                AbdiiOrder o= new AbdiiOrder();
                o.setAziOrder(order);
                System.out.println("The pizza order will cost U: $"+ o.calculateTotal()+"\n");
                System.out.println("                  Thank you for patience                   ");
                System.out.println("           Your pizza will be delivered within 1 hour          ");
                System.out.println("                           bye                              ");
            }else{
                System.out.println("Invalid Choice: Do your topping again ");
                doToppings();
            }
        }
    }
}
