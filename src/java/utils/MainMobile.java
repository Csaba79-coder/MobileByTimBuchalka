package utils;

import contact.Contact;
import contact.MobilePhone;

import java.util.Scanner;

public class MainMobile {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
       /* Contact.createContact("Dávid", "1234");

        Contact contact1 = new Contact();
        contact1.createNewContact("Dávidka", "2345");

        Contact contact2 = new Contact("Dévid", "6654");
        contact2.getMobileNumber();
        System.out.println("The mobile number of " +  contact2.getName() + " is " + contact2.getMobileNumber());
        contact2.setMobileNumber("124");
        System.out.println("The mobile number of " +  contact2.getName() + " is " + contact2.getMobileNumber());*/

        boolean quit = false; // boolean quit;

        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter an action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Good bye!\nShutting down ...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
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
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone ...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shut down\n" +
                           "1  - to print contacts\n" +
                           "2  - to add a new contact\n" +
                           "3  - to update existing contact\n" +
                           "4  - to remove an existing contact\n" +
                           "5  - to query if an existing contact exist\n" +
                           "6  - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a phone number: ");
        String mobileNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, mobileNumber);
        // Contact newContact = new Contact(name, mobileNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added as follows, name: " +  name + ", phone: " + mobileNumber);
        } else {
            System.out.println("Cannot add, " + name + " already on file.");
        }
    }

    /*public static void addNewCont() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a phone number: ");
        String mobileNumber = scanner.nextLine();
        Contact contact = new Contact(); // példányosítasz! majd setterek már alkalmazhatóak!
        contact.setName(name);
        contact.setMobileNumber(mobileNumber);
    }*/

    private static void updateContact() {
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter a new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter a new mobile number: ");
        String newMobileNumber = scanner.next();
        Contact newContact = Contact.createContact(newName, newMobileNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record!");
        } else {
            System.out.println("Error updating record!");
        }
    }

    private static void removeContact() {
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found!");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Error deleting record!"); // or contact ...
        }
    }

    private static void queryContact() {
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() +
                " phone number is " + existingContactRecord.getMobileNumber());
    }
}
