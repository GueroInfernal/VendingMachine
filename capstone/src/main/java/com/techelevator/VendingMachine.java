package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingMachine {

    private static final int INITIAL_STOCK = 5;
    private static int currentStock;
    private BigDecimal machineBalance = new BigDecimal("0.00");
    private BigDecimal remainingBalance = new BigDecimal("0.00");
    private BigDecimal change = new BigDecimal("0.00");

    List<ItemsForSale> inventory = new ArrayList<>();


    public BigDecimal getMachineBalance() {
        return this.machineBalance;
    }

    public BigDecimal getRemainingBalance(){
        return this.machineBalance;
    }

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
        //rounds value up to the nearest whole number.
        amountToDeposit = amountToDeposit.setScale(0, RoundingMode.UP);

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


        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();
        String userResponseToUpper=userResponse.toUpperCase();

        String result = "Invalid input";
        String name="";
        BigDecimal price= new BigDecimal("0.00");

        for (ItemsForSale item : inventory) {
            if (item.getLocation().equals(userResponseToUpper)) { //make case-insensitive

                //If code doesn't exist return to purchase menu, If sold out notify, and return to purchase menu *done in CLI

                this.remainingBalance= getMachineBalance().subtract(item.getPrice()); //subtract item price from balance
                this.machineBalance= remainingBalance;

                result = item.getSound();//return name of item and its price
                name= item.getName();
                price=item.getPrice();

            }
        }

        System.out.println(name);
        System.out.println(price);
        System.out.println(result);
        System.out.println(this.remainingBalance);
    }

    public void getRemainingBalance(BigDecimal remainingBalance){

        remainingBalance= this.remainingBalance;

    }

    public String returnChange(){
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");

        BigDecimal quarters = remainingBalance.divide(quarter).setScale(0, RoundingMode.FLOOR);
        change = remainingBalance.remainder(quarter);
        BigDecimal dimes = remainingBalance.divide(dime).setScale(0, RoundingMode.FLOOR);
        change = remainingBalance.remainder(dime);
        BigDecimal nickels = remainingBalance.divide(nickel).setScale(0, RoundingMode.FLOOR);

        return "Your change is: " + quarters + " quarter(s), " + dimes + " dime(s), and " + nickels + " nickel(s).  Have a nice day!";
    }



    public void removeStock(int number) {
        number = 1;
        currentStock = INITIAL_STOCK - number;
    }



//    public void giveChange() {
//        Change change = new Change();
//
//    }
}