import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email + "\n";
    }
}

public class ContactManagementSystem {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contactList.add(contact);
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println("Contact found:\n" + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found with name " + name);
        }
    }

    static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        boolean removed = contactList.removeIf(contact -> contact.name.equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("No contact found with that name.");
        }
    }
}

