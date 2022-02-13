package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String RETURN_TO_PREVIOUS_MENU = "Return to previous menu";
    private static final String FEED_MORE_MONEY = "Add more money?";
    private static final String[] FEED_MENU_OPTION = {RETURN_TO_PREVIOUS_MENU, FEED_MORE_MONEY};

    private Menu menu;
    private VendingMachine vendingMachine = new VendingMachine();

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                for (ItemsForSale item : vendingMachine.getInventory()) {
                    System.out.format("%s %-20s $%s %s %n", item.getLocation(), item.getName(),
                            item.getPrice(), "Stock: " + item.getStock());
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                String secondMenu = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                while (!secondMenu.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {//fixed issue by changing choice to secondMenu

                    if (secondMenu.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) { //add money to machine using feed money method

                        System.out.println("");
                        System.out.println("Current Money Provided: $" + vendingMachine.getMachineBalance());
                        System.out.println("");
                        System.out.println("Please enter a whole dollar value:"); //added prompt so it's a little more clear
                        vendingMachine.feedMoney();
                        System.out.println("Current Money Provided: $" + vendingMachine.getMachineBalance());
                        String feedMoneyMenu = (String) menu.getChoiceFromOptions(FEED_MENU_OPTION);

                        if (feedMoneyMenu.equals(RETURN_TO_PREVIOUS_MENU)) {
                            menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                        }

                    } else if (secondMenu.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

                        System.out.println("Current Money Provided: $" + vendingMachine.getMachineBalance());//Start by displaying balance

                        for (ItemsForSale item : vendingMachine.getInventory()) {
                            System.out.format("%s %-20s $%s %s %n", item.getLocation(), item.getName(),
                                    item.getPrice(), "Stock: " + item.getStock());
                        }

                        if (vendingMachine.getMachineBalance().compareTo(BigDecimal.ZERO) > 0) {

                            System.out.println("Make a selection");
                            vendingMachine.selectProduct();
                        }


//
//						//check balance is greater than or equal to get price
//						for(ItemsForSale item : vendingMachine.getInventory()) {
//							if (vendingMachine.getMachineBalance().compareTo(item.getPrice()) <= 0) {
//
//								System.out.println("Please add more funds");
//								menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
//							}
//
//
//							//prompts for a choice, dispenses product & returns message
//							System.out.println("Please enter this ");
//							vendingMachine.selectProduct();
//
//							break;


                    } else if (secondMenu.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        //calculates & dispenses change into Quarters, dimes and nickels, returns change,
                        //updates current balance to 0.
                        //return to main menu
                        //update log.txt
                    }

                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

                System.exit(0);
            }
        }


    }



    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}


//TODO log purchases, return change.