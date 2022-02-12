package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private static final int INITIAL_STOCK = 5;
    private static int currentStock;
    private BigDecimal machineBalance = new BigDecimal("0.00");
    List<ItemsForSale> inventory = new ArrayList<>();


    public BigDecimal getMachineBalance() {
        return this.machineBalance;
    }

/*
    public void setMachineBalance(BigDecimal machineBalance) { // machine balance does not need a setter just like how you cant set your bank account balance to what ever you want!
        this.machineBalance = machineBalance;
    }*/


    public int getCurrentStock() {
        return this.getCurrentStock();
    }

    public List<ItemsForSale> getInventory() {
        return this.inventory;

    }

    VendingMachine() {
        loadInventory();

    }

    private void loadInventory() {

        File inputFile = new File("C:\\Users\\Student\\workspace\\capstone-1-team-4\\capstone\\vendingmachine.csv");
        try (Scanner fileToRead = new Scanner(inputFile)) {
            while (fileToRead.hasNextLine()) {
                String line = fileToRead.nextLine();
                String[] parts = line.split("\\|");
                if (parts[3].equals("Chip")) {
                    Chips chip = new Chips(parts[0], parts[1], new BigDecimal(parts[2]), INITIAL_STOCK);
                    inventory.add(chip);
                    //TODO add else ifs for other types
                } else if (parts[3].equals("Candy")) {
                    Candy candy = new Candy(parts[0], parts[1], new BigDecimal(parts[2]), INITIAL_STOCK);
                    inventory.add(candy);
                } else if (parts[3].equals("Drink")) {
                    Beverages drink = new Beverages(parts[0], parts[1], new BigDecimal(parts[2]), INITIAL_STOCK);
                    inventory.add(drink);
                } else {
                    Gum gum = new Gum(parts[0], parts[1], new BigDecimal(parts[2]), INITIAL_STOCK);
                    inventory.add(gum);
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


    public BigDecimal feedMoney() { //fixed feed money to update the current balance everytime funds are added.

        Scanner userInput = new Scanner(System.in);
        String amount = userInput.nextLine();

        BigDecimal amountToDeposit = new BigDecimal(amount);
        return this.machineBalance = machineBalance.add(amountToDeposit);

//       System.out.println("Current balance: $" + machineBalance);
//       System.out.println("");
//       System.out.println("Please add funds>>>");
//       System.out.println("");
//        Scanner getInput = new Scanner(System.in);
//        String moneyInput = getInput.nextLine();
//
//        BigDecimal money = new BigDecimal(moneyInput); // requires user input get money method
//        machineBalance = machineBalance.add(money);
//        // Needs to update balance
//        // Need to stay on this sub-menu until exit
    }


    public void selectProduct() { //TODO Left of here how can I access a certain object constructor value from array list?
        //show list of prods available, and allow customer to enter corresponding code.
        loadInventory();
        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();

        String result = "";

        for (ItemsForSale item : inventory) {
            if (item.getLocation().equals(userResponse)) {
                result = item.getSound();
            }
        }

        System.out.println(result);
    }

    public void calculateChange() {

        int quarter = 25;
        int dime = 10;
        int nickle = 5;

    }

    public void removeStock(int number) {
        number = 1;
        currentStock = INITIAL_STOCK - number;
    }

    public void giveChange() {
        Change change = new Change();

    }
}