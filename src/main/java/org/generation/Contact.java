package org.generation;

public class Contact {
	private String name; // Jorge 
	private String last_name; // Rodriguez
	private String number;

	public Contact(String name, String last_name, String number) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %s", name, last_name, number);
	}
	
	
}
