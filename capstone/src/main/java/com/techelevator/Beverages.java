package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends ItemsForSale {


    public Beverages(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }

    Beverages C1 = new Beverages("C1", "Cola", new BigDecimal("1.25"), 5);
    Beverages C2 = new Beverages("C2", "Dr. Salt", new BigDecimal("1.50"), 5);
    Beverages C3 = new Beverages("C3", "Mountain Melter", new BigDecimal("1.50"), 5);
    Beverages C4 = new Beverages("C4", "Heavy", new BigDecimal("1.50"), 5);



    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
