package org.generation;

import java.util.Scanner;

/**
 * Console menu to interact with the PhoneBook.
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneBook phoneBook = new PhoneBook();

		phoneBook.addContact(new Contact("Pedro", "Paramo", "555-1234"));
		phoneBook.addContact(new Contact("Luis", "Pérez", "555-5678"));
		phoneBook.addContact(new Contact("Carla", "Ramírez", "555-8765"));
		phoneBook.addContact(new Contact("Ana", "Torres", "555-4321"));
		phoneBook.addContact(new Contact("Marta", "García", "555-9999"));

		int option;
		do {
			System.out.println("\n==================== PHONEBOOK MENU ====================");
			System.out.println("1. Add contact");
			System.out.println("2. Search contact");
			System.out.println("3. Remove contact");
			System.out.println("4. Update phone number");
			System.out.println("5. List all contacts");
			System.out.println("6. Show free slots");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");

			while (!scanner.hasNextInt()) {
				System.out.println("----> ⚠️ Please enter a valid number.");
				scanner.next();
			}
			option = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (option) {
			case 1 -> {
				System.out.println("*".repeat(20));

				if (phoneBook.isFull()) {
					System.out.println("----> ⚠️ PhoneBook is full. Cannot add more contacts.");
					break;
				}

				System.out.print("First name: ");
				String firstName = scanner.nextLine();
				System.out.print("Last name: ");
				String lastName = scanner.nextLine();
				System.out.print("Phone number: ");
				String phone = scanner.nextLine();

				try {
					boolean added = phoneBook.addContact(new Contact(firstName, lastName, phone));
					if (added) {
						System.out.println("----> ✅ Remaining free slots: " + phoneBook.freeSlots());
					}
				} catch (IllegalArgumentException ex) {
					System.out.println("❌ " + ex.getMessage());
				}
			}

			case 2 -> {
				System.out.print("First name: ");
				String firstName = scanner.nextLine();
				System.out.print("Last name: ");
				String lastName = scanner.nextLine();
				Contact found = phoneBook.searchContact(firstName, lastName);
				System.out.println(found != null ? "----> ✅ Found: " + found : "----> ⚠️ Contact not found.");
			}
			case 3 -> {
				System.out.print("First name: ");
				String firstName = scanner.nextLine();
				System.out.print("Last name: ");
				String lastName = scanner.nextLine();
				phoneBook.removeContact(firstName, lastName);
			}
			case 4 -> {
				System.out.print("First name: ");
				String firstName = scanner.nextLine();
				System.out.print("Last name: ");
				String lastName = scanner.nextLine();
				System.out.print("New phone number: ");
				String phone = scanner.nextLine();
				phoneBook.updatePhoneNumber(firstName, lastName, phone);
			}
			case 5 -> phoneBook.listContacts();
			case 6 -> System.out.println("----> 📌 Free slots: " + phoneBook.freeSlots());
			case 0 -> System.out.println("----> 👋 Exiting PhoneBook. Goodbye!");
			default -> System.out.println("----> ⚠️ Invalid option, please try again.");
			}
		} while (option != 0);

		scanner.close();
	}
}
