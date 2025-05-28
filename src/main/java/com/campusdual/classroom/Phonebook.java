package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, Contact> phonebook = new HashMap<>();

    public void addContact(Contact contact) {
        phonebook.put(contact.getCode(), contact);
    }


    public void showPhonebook() {
        if (phonebook.isEmpty()) {
            System.out.println("The phonebook is empty.");
        } else {
            System.out.println("Contacts in the phonebook:");
            for (Map.Entry<String, Contact> entry : phonebook.entrySet()) {
                Contact contact = entry.getValue();
                System.out.println("Code: " + entry.getKey() + " -> Name: " + contact.getName() +
                        " Surname: " + contact.getSurnames() +
                        " Phone Numbers: " + String.join(", ", contact.getPhone()));
            }
        }
    }

    public void showMenu() {
        int number;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Add a contact to the phonebook");
            System.out.println("2. Show the phonebook");
            System.out.println("3. Select a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            number = Utils.integer("Choose a number: ");

            switch (number) {
                case 1: {
                    String name = Utils.string("What is your name?");
                    String surname = Utils.string("What is your surname?");
                    String phoneNumber = Utils.string("Enter a phone number:");

                    Contact newContact = new Contact(name, surname, phoneNumber);
                    addContact(newContact);
                }
                case 2: {
                    showPhonebook();
                }
                case 3: {
                    selectContact();
                }
                case 4: {
                    String code = Utils.string("Enter the code: ");
                    deleteContact(code);

                }
                case 5: {
                    System.out.println("Exiting...");
                }
            }
        } while (number != 5);
    }

    public void deleteContact(String code) {
        if (phonebook.containsKey(code)) {
            phonebook.remove(code);
        } else {
            System.out.println("No contact found with that code.");
        }
    }

    public void showContactMenu(String code) {
        code = Utils.string("Enter the contact code: ");
        if (!phonebook.containsKey(code)) {
            System.out.println("No contact found with that code.");
            return;
        }
        Contact contact = phonebook.get(code);
        int option;
        do {
            System.out.println("Contact Menu for " + contact.getName() + " " + contact.getSurnames());
            System.out.println("1. Call my number");
            System.out.println("2. Call another number");
            System.out.println("3. Show contact details");
            System.out.println("4. Exit");

            option = Utils.integer("Choose an option: ");
            switch (option) {
                case 1: {
                    contact.callMyNumber();
                }
                case 2: {
                    String phone = Utils.string("Enter the number to call: ");
                    contact.callOtherNumber(phone);
                }
                case 3: {
                    contact.showContactDetails();
                }
                case 4: {
                    System.out.println("Exiting contact menu...");
                }
            }
        } while (option != 4);
    }

    public void selectContact() {
        String code = Utils.string("Enter the contact code: ");
        if (phonebook.containsKey(code)) {
            showContactMenu(code);
        } else {
            System.out.println("No contact found with that code.");
        }
    }

    public Map<String, Contact> getData() {
        return phonebook;
    }

}


