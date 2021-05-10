package com.tts;

import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while(option != 6){
            System.out.println();
            System.out.println("1) Add an Entry\n");
            System.out.println("2) Remove an Entry\n");
            System.out.println("3) Search for a Specific Entry\n");
            System.out.println("4) Print Address Book\n");
            System.out.println("5) Delete Book\n");
            System.out.println("6) Quit\n");
            System.out.println("Please choose what you'd like to do with the database: ");
//            System.out.println();

            option = scanner.nextInt();

            if(option < 1 || option > 6 ){
                System.out.println("Please enter a valid number (1 - 6).");
            }else {

                switch (option) {
                    case 1:
                        book.addNewEntry();
                        break;
                    case 2:
                        book.removeEntry();
                        break;
                    case 3:
                        book.searchEntry();
                        break;
                    case 4:
                        book.printAllEntries();
                        break;
                    case 5:
                        book.deleteAddressBook();
                        break;
                    default:
                        System.out.println("Please enter a valid number (1 - 5).");
                }
            }

        }
    }
}
