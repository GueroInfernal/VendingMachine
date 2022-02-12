package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends ItemsForSale {


    public Beverages(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }





    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
