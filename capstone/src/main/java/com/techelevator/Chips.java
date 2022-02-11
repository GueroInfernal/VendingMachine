package com.techelevator;


import java.math.BigDecimal;

public class Chips extends ItemsForSale{


    public Chips(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }

    Chips A1 = new Chips("A1","Potato Crisps", new BigDecimal("3.05"),5);
    Chips A2 = new Chips("A2", "Stacker", new BigDecimal("1.45"), 5);
    Chips A3 = new Chips( "A3", "Grain Waves", new BigDecimal("2.75"), 5);
    Chips A4 = new Chips("A4", "Cloud Popcorn", new BigDecimal("3.65"), 5);


    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
