package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private int stock=5;
    private BigDecimal machineBalance = new BigDecimal("0.00");

    public BigDecimal getMachineBalance() {
        return machineBalance;
    }

    public void setMachineBalance(BigDecimal machineBalance) {
        this.machineBalance = machineBalance;
    }

    VendingMachine() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /*public String[] getSpiltArray() {
        String[] slotLocation = new String[0];
        File inputFile = new File("C:\\Users\\Student\\workspace\\capstone-1-team-4\\capstone\\vendingmachine.csv");
        try (Scanner fileToRead = new Scanner(inputFile)) {
            while (fileToRead.hasNextLine()) {
                String line = fileToRead.nextLine();
                // Map<String,Integer> listItems = new HashMap<>();
                 slotLocation = line.split("\\|");
                System.out.println(Arrays.toString(slotLocation));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return slotLocation;
    }*/
    Chips A1 = new Chips("A1","Potato Crisps", new BigDecimal("3.05"),5);
    Chips A2 = new Chips("A2", "Stacker", new BigDecimal("1.45"), 5);
    Chips A3 = new Chips( "A3", "Grain Waves", new BigDecimal("2.75"), 5);
    Chips A4 = new Chips("A4", "Cloud Popcorn", new BigDecimal("3.65"), 5);

    Candy B1= new Candy("B1","Moonpie", new BigDecimal("1.80"),5);
    Candy B2 = new Candy("B2", "Cowtales", new BigDecimal("1.50"), 5);
    Candy B3 = new Candy("B3", "Wonka Bar", new BigDecimal("1.50"), 5);
    Candy B4 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), 5);

    Beverages C1 = new Beverages("C1", "Cola", new BigDecimal("1.25"), 5);
    Beverages C2 = new Beverages("C2", "Dr. Salt", new BigDecimal("1.50"), 5);
    Beverages C3 = new Beverages("C3", "Mountain Melter", new BigDecimal("1.50"), 5);
    Beverages C4 = new Beverages("C4", "Heavy", new BigDecimal("1.50"), 5);

    Gum D1 = new Gum("D1", "U-Chews", new BigDecimal("0.85"), 5);
    Gum D2 = new Gum("D2", "Little League Chew", new BigDecimal("0.95"), 5);
    Gum D3 = new Gum("D3", "Chiclets", new BigDecimal("0.95"), 5);
    Gum D4 = new Gum("D4", "Triplemint", new BigDecimal("0.75"), 5);

    List<Arrays> inventory = new ArrayList<>();



    public void selectProduct(){
        //show list of prods available, and allow customer to enter corresponding code.

   }
   public void getMoney(){       //requires user input
   }

   public void feedMoney(){
       System.out.println("Current balance: $" + machineBalance);
       System.out.println("");
       System.out.println("Please add funds>>>");
       System.out.println("");
        Scanner getInput = new Scanner(System.in);
        String moneyInput = getInput.nextLine();

        BigDecimal money = new BigDecimal(moneyInput); // requires user input get money method
        machineBalance = machineBalance.add(money);
        // Needs to update balance
        // Need to stay on this sub-menu until exit
   }
    public void giveChange(){
        Change change = new Change();

    }
}