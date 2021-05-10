package com.tts;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Entry> entries;

    public AddressBook() {
        entries = new ArrayList<Entry>();
    }
    Scanner scanner = new Scanner(System.in);

    public void addNewEntry() {


        System.out.println("Enter First Name: ");
        String firstName = scanner.next();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();

        System.out.println("Enter Phone Number: ");
        String phoneNum = scanner.next();

        System.out.println("Enter Email: ");
        String email = scanner.next();

        int validEmail = email.indexOf("@");
        int validEmail1 = email.indexOf(".");

        if(validEmail == -1 || validEmail1 == -1){
            System.out.println("You entered an invalid email address!");
        }else{

            Entry e = new Entry(firstName, lastName, phoneNum, email);
            entries.add(e);
            System.out.println(e.toString());
            System.out.print("Added new entry!");
            System.out.println();
        }

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
        int searchType = 0;
        try{
            searchType = Integer.parseInt(searchOption);
        }catch(Exception e){
            System.out.println("\nInvalid search option.\n");

        }


        if(searchType < 1 || searchType > 4){
            System.out.println("Please enter a valid number (1 - 4).");
        }else {
            System.out.println("Enter your search: ");
            String search = scanner.next();

            switch (searchType) {
                case 1:
                    searchByFirstName(search);
                    break;
                case 2:
                    searchByLastName(search);
                    break;
                case 3:
                    searchByPhoneNum(search);
                    break;
                case 4:
                    searchByEmail(search);
                    break;
                default:
                    System.out.println("Error! Address not found!\n");
            }
        }
    }

    private void searchByEmail(String search) {
        for(Entry e : entries){
            if(e.getEmail().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
            }else{
                System.out.println("No results found!\n");
            }
        }
    }

    private void searchByPhoneNum(String search) {
        for(Entry e : entries){
            if(e.getPhoneNum().startsWith(search)){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
            }else{
                System.out.println("No results found!\n");
            }
        }
    }

    private void searchByLastName(String search) {
        for(Entry e : entries){
            if(e.getLastName().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
            }else{
                System.out.println("No results found!\n");
            }
        }
    }

    private void searchByFirstName(String search) {
        for(Entry e : entries){
            if(e.getFirstName().toUpperCase().startsWith(search.toUpperCase())){
                System.out.println("*********");
                System.out.println(e.toString());
                System.out.println("*********");
            }else{
                System.out.println("No results found!\n");
            }
        }
    }

    public void removeEntry() {
        System.out.println("Enter an entry's email to remove: ");
        String email = scanner.next();
        int validEmail = email.indexOf("@");
        int validEmail1 = email.indexOf(".");

        if(validEmail == -1 || validEmail1 == -1){
            System.out.println("You entered an invalid email address!");
        }else{
            Entry eRemoved = null;
            for(Entry e : entries){
                if(e.getEmail().equalsIgnoreCase(email)){
                    eRemoved = e;
                    System.out.println("Deleted the following entry:\n");
                    System.out.println("**************");
                    System.out.println(e.toString());
                    System.out.println("**************");
                }
            }
            if(eRemoved != null){
                entries.remove(eRemoved);
            }else{
                System.out.println("Error! Email address not found!");
            }

        }
    }

    public void deleteAddressBook(){
        entries.clear();
        System.out.println("Address book cleared!");
    }
}