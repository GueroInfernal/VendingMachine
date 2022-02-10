package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {


    private int stock=5;



    VendingMachine() {

    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getSpiltArray() {
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
    }

   public void purchase(){

   }

}