package com.techelevator;

import java.math.BigDecimal;

public class Candy extends ItemsForSale {

    public Candy(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }

    Candy B1= new Candy("B1","Moonpie", new BigDecimal("1.80"),5);
    Candy B2 = new Candy("B2", "Cowtales", new BigDecimal("1.50"), 5);
    Candy B3 = new Candy("B3", "Wonka Bar", new BigDecimal("1.50"), 5);
    Candy B4 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), 5);


    public String getSound() {
        return "Munch Munch, Yum!";
    }
}
