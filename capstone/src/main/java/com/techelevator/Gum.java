package com.techelevator;

import java.math.BigDecimal;

public class Gum extends ItemsForSale{

    public Gum(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }

    Gum D1 = new Gum("D1", "U-Chews", new BigDecimal("0.85"), 5);
    Gum D2 = new Gum("D2", "Little League Chew", new BigDecimal("0.95"), 5);
    Gum D3 = new Gum("D3", "Chiclets", new BigDecimal("0.95"), 5);
    Gum D4 = new Gum("D4", "Triplemint", new BigDecimal("0.75"), 5);


    public String getSound() {
        return "Chew Chew, Yum!";
    }
}

