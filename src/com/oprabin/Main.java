package com.oprabin;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean quit = false;
    public static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        while (!quit) {
            starActions();
            printOptions();

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printOptions();
                    break;

            }


        }


    }

    public static void printOptions() {

        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");

    }

    public static void starActions() {
        System.out.println("Loading Contacts...");
    }


    public static void addContact(){
        System.out.println("Enter name: ");
        String name = scanner.next();
        if(mobilePhone.findContact(name) < 0){
            System.out.println("Enter the phone number: ");
            String phoneNumber = scanner.next();

            if(mobilePhone.addContact(name, phoneNumber)){
                System.out.println("Added successfully...");
            }
        }

        else
            System.out.println("Error in adding contact...");

    }

    public static void printContacts(){
        mobilePhone.printContacts();
    }


    public static void updateContact(){
        System.out.println("Enter the name: ");
        String name = scanner.next();
        if(mobilePhone.updateContact(name)){
            System.out.println("Successfully updated.");
        }

        else System.out.println("No such entry was found.");

    }


    public static void removeContact(){
        System.out.println("Enter the name: ");
        String name = scanner.next();

        if(mobilePhone.removeContact(name))
            System.out.println("Successfully deleted.");

        else System.out.println("No such entry was found.");

    }


    public static void queryContact(){
        System.out.println("Enter the name: ");
        String name = scanner.next();

        if(mobilePhone.queryContact(name)){
            System.out.println("Successfully terminated.");
        }
        else System.out.println("No such entry was found.");
    }



}
