package com.oprabin;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Contacts> myPhoneBook = new ArrayList<Contacts>();




  /*  public static int findContact(String name){
        return myPhoneBook.indexOf(name);
    }*/


    public static int findContact(String name){
        for(int i = 0; i<myPhoneBook.size(); i++){
            if(name.equals(myPhoneBook.get(i).getName()))
                return i;

        }
        return -1;
    }

    public static boolean addContact(String name, String phoneNumber){
        Contacts contacts = new Contacts(name, phoneNumber);
        if(myPhoneBook.add(contacts)) return true;
        else
            return false;
    }


    public static void printContacts() {
        for(int i=0; i<myPhoneBook.size(); i++){
            System.out.println(i+1 + ". " + myPhoneBook.get(i).getName() + " --> " + myPhoneBook.get(i).getPhoneNumber());

        }

    }


    public static boolean updateContact(String name){
        int position = findContact(name);
    //    System.out.println(position);

        if(position>=0){
            Contacts oldContacts = myPhoneBook.get(position) ;
            System.out.println("Enter new name: ");
            String newName = scanner.next();

            System.out.println("Enter new phone number: ");
            String newNumber = scanner.next();

            Contacts newContact = new Contacts(newName, newNumber);

            myPhoneBook.set(position, newContact);

            System.out.println(oldContacts.getName() + " --> " + oldContacts.getPhoneNumber() + " was changed into " + newContact.getName() + " --> " + newContact.getPhoneNumber());
            return true;

        }
        else
            return false;

    }



    public static boolean removeContact(String name){
        int position = findContact(name);

        if (findContact(name)>=0) {
            Contacts contacts = myPhoneBook.get(position);

            /*System.out.println("Enter new name: ");
            String newName = scanner.next();

            System.out.println("Enter the phone number: ");
            String phoneNumber = scanner.next();
*/


            myPhoneBook.remove(position);
            System.out.println(contacts.getName() + " --> " + contacts.getPhoneNumber() + " was deleted.");
            return true;
        }

        return false;
    }


    public static boolean queryContact(String name){
        int position = findContact(name);

        if(position>=0){
            Contacts contacts = myPhoneBook.get(position);
            System.out.println(contacts.getName() + " --> " + contacts.getPhoneNumber());
            return true;
        }

        return false;
    }











}
