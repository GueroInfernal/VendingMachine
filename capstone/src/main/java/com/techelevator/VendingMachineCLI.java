package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				//readin the csv
				//vendingma.split("|")
				//		store value =
				//split the values of the csv based on the pipe char
				//store those values in an array strings
				//put in map with key value and updated method
				//how do we update the quantity every time an item is taken out?

				//we can use the displayMenuOption method after we split and store values in variables
				//slot=menu.getChoiceFromOptions(ait)

				VendingMachine vendingMachine = new VendingMachine();
				Chips A1= new Chips("A1","Potato Crisps", new BigDecimal("3.05"),5);

				String[] value= vendingMachine.getSpiltArray();
				//menu.getChoiceFromOptions(value);




			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				//To-do
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
