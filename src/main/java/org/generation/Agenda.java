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
		this.maximumCapacity = maximunCapacity;
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

}
