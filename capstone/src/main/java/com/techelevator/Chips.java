package com.techelevator;

import java.math.BigDecimal;

public class Chips extends ItemsForSale{


    public Chips(String location, String name, BigDecimal price, int stock ) {
        super(location,name,price,stock);
    }

    Chips A1= new Chips("A1","Potato Crisps", new BigDecimal("3.05"),5);
//    Chips A2 = new Chips("A2","")


}