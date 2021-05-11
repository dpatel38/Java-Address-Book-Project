package com.tts;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Entry> entries;

    public AddressBook() {

        entries = new ArrayList<>();
    }
    Scanner scanner = new Scanner(System.in);

    public void addNewEntry() {


        System.out.println("Enter First Name: ");
        String firstName = scanner.next();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();

        System.out.println("Enter Phone Number: ");
        String phoneNum = scanner.next();

        while (!(phoneNum.matches("\\d{10}"))){
            System.out.println("Invalid phone number! Please enter 10 digit number.");
            phoneNum = scanner.next();
        }


        System.out.println("Enter Email: ");
        String email = scanner.next();

        while(!(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
            System.out.println("You entered an invalid email address!");
            email = scanner.next();
        }

        Entry e = new Entry(firstName, lastName, phoneNum, email);
        entries.add(e);
        System.out.println();
        System.out.println("Added new entry!\n\n");
        System.out.println(e.toString());
        System.out.println();

    }

    public void printAllEntries(){
        if(entries.size() == 0){
            System.out.println("Address Book is empty!");
        }else {
            for (Entry e : entries) {
                System.out.println("**************");
                System.out.println(e.toString());
                System.out.println("**************");
            }
        }
    }

    public void searchEntry() {

        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Phone Number");
        System.out.println("4) Email address");
        System.out.println("Chose a search type: ");
        String searchOption = scanner.next();
        int searchType = Integer.parseInt(searchOption);


        if(searchType < 1 || searchType > 4){
            System.out.println("Invalid search option! Please enter a valid number (1 - 4).");
        }else {
            System.out.println("Enter your search: ");
            String search = scanner.next();

            switch (searchType) {
                case 1 -> searchByFirstName(search);
                case 2 -> searchByLastName(search);
                case 3 -> searchByPhoneNum(search);
                case 4 -> searchByEmail(search);
                default -> System.out.println("Error! Address not found!\n");
            }
        }
    }

    public void searchByEmail(String search) {
        boolean findSearchValue = false;
        for(Entry e : entries){
            if(e.getEmail().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
                findSearchValue = true;
            }
        }
        if(!findSearchValue){
            System.out.println("No results found!\n");
        }
    }

    public void searchByPhoneNum(String search) {
        boolean findSearchValue = false;
        for (Entry e : entries) {
            if (e.getPhoneNum().startsWith(search)) {
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
                findSearchValue = true;
            }
        }
        if(!findSearchValue){
            System.out.println("No results found!\n");
        }
    }

    public void searchByLastName(String search) {
        boolean findSearchValue = false;
        for(Entry e : entries){
            if(e.getLastName().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
                findSearchValue = true;
            }
        }
        if(!findSearchValue){
            System.out.println("No results found!\n");
        }
    }

    public void searchByFirstName(String search) {
        boolean findSearchValue = false;
        for(Entry e : entries){
            if(e.getFirstName().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
                findSearchValue = true;
            }
        }
        if(!findSearchValue){
            System.out.println("No results found!\n");
        }
    }


    public void removeEntry() {
        System.out.println("Enter an entry's email to remove: ");
        String email = scanner.next();

        while(!(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
            System.out.println("You entered an invalid email address!");
            email = scanner.next();
        }
            Entry eRemoved = null;
            for(Entry e : entries){
                if(e.getEmail().equalsIgnoreCase(email)){
                    eRemoved = e;
                    System.out.println("Deleted the following entry:\n");
                    System.out.println("**************");
                    System.out.println(eRemoved.toString());
                    System.out.println("**************");
                }
            }
            if(eRemoved != null){
                entries.remove(eRemoved);
            }else{
                System.out.println("Error! Email address not found!");
            }


    }

    public void deleteAddressBook(){
        entries.clear();
        System.out.println("Address book cleared!");
    }
}
