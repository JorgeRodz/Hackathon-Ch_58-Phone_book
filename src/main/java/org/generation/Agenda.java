package org.generation;

import java.util.List;

public class Agenda {
	private int maximumCapacity;
	private List<Contact> contacts;

	public Agenda(int maximumCapacity, List<Contact> contacts) {
		super();
		this.maximumCapacity = maximumCapacity;
		this.contacts = contacts;
	}

	public int getMaximunCapacity() {
		return maximumCapacity;
	}

	public void setMaximunCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String addContact(Contact contact) {
		if (contact == null)
			return "Invalid Contact.";
		if (contacts.size() >= maximumCapacity)
			return "The agenda is full.";
		contacts.add(contact);
		return "Contact added successfully.";
	}

	public void thereIsContact(Contact contact) {
		if (contacts.contains(contact))
			System.out.println("The contact name already exists.");
		else {
			contacts.add(contact);
			System.out.println("Enter the contact's name.");
		}
	}

	public void listContact() {
		boolean emptyAgenda = true;
		System.out.println("Contact list");
		for (Contact contact : contacts) {
			if (contact != null) {
				System.out.println(contact.toString());
				emptyAgenda = false;
			}
		}
		if (emptyAgenda) {
			System.out.println("The agenda is empty");
		}
	}

	public Contact searchContact(Contact contact) {
		for (Contact contactList : contacts) {
			if (contactList.getName().equals(contact.getName()) && contactList.getLast_name().equals(contact.getLast_name())) {
				return contactList;
			}
		}
		return null;
	}

	public void deleteContact(String name, String last_name) {
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getName().equals(name) && contact.getLast_name().equals(last_name)) {
				contacts.remove(i);
				System.out.println("Contact removed successfully.");
			}
		}
	}

	public String modifyContact(Contact contact) {
		Contact contactHome = searchContact(Contact contact);
		if (contactHome != null) {
			contact.setNumber(newNumber);
			System.out.println("Number of" + name + "modified by " + newNumber + "successfully.");
		} else {
			System.out.println("No se puede modificar. El contacto " + name + "no exist in the agenda.");
		}
	}

	public String freeSpaces() {
		int busy
	}

}
