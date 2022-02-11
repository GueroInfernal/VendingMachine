package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private static final int INITIAL_STOCK = 5;
    private BigDecimal machineBalance = new BigDecimal("0.00");
    List<ItemsForSale> inventory = new ArrayList<>();

    public BigDecimal getMachineBalance() {
        return machineBalance;
    }

    public void setMachineBalance(BigDecimal machineBalance) {
        this.machineBalance = machineBalance;
    }
    public List<ItemsForSale> getInventory(){
        return this.inventory;

    }

    VendingMachine() {
        loadInventory();
    }

    private void  loadInventory() {

        File inputFile = new File("C:\\Users\\Student\\workspace\\capstone-1-team-4\\capstone\\vendingmachine.csv");
        try (Scanner fileToRead = new Scanner(inputFile)) {
            while (fileToRead.hasNextLine()) {
                String line = fileToRead.nextLine();
                 String[] parts = line.split("\\|");
                 if (parts[3].equals("Chip")){
                     Chips chip = new Chips(parts[0], parts[1], new BigDecimal(parts[2]), INITIAL_STOCK);
                     inventory.add(chip);
                     //TODO add else ifs for other types
                 }



            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


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