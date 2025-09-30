package org.generation;

import java.util.Locale;
import java.util.Objects;

// Agregamos el keyword "final" ya que es una clase que no se va a heredar
public final class Contact implements Comparable<Contact> {
	private final String firstName;
	private final String lastName;
	private String phoneNumber;

	// Antes de guardar cada dato se validan sus valores
	public Contact(String firstName, String lastName, String phoneNumber) {
		validateEmptyValues(firstName, lastName);
		this.firstName = firstName.trim();
		this.lastName = lastName.trim();
		this.phoneNumber = phoneNumber != null ? phoneNumber.trim() : "";
	}

	// Validar valores de entrada
	private void validateEmptyValues(String firstName, String lastName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("---> First name cannot be empty.");
		}
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("---> Last name cannot be empty.");
		}
	}

	// method overload -> solo para phoneNumber
	private void validateEmptyValues(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("---> Phone number cannot be empty.");
		}
	}

	// Para generar una llave unica apartir del nombre y apellido (case-insensitive)
	private String key() {
		return (firstName + "\u0000" + lastName).toLowerCase(Locale.ROOT);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Para modificar el numero de un usuario validando el nuevo valor
	public void setPhoneNumber(String phoneNumber) {
		validateEmptyValues(phoneNumber);
		this.phoneNumber = phoneNumber.trim();
	}

	// Para comparar si dos contactos son iguales, aqui use la clave..
	// ...generada por el metodo key()
	// Este metodo se usa internamente en metodos como ArraysList.contains() para
	// compara dos objetos...
	// del mismo tipo
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Contact))
			return false;
		Contact that = (Contact) o;
		return this.key().equals(that.key());
	}

	// Para definir el orden que se mostraran los nombres(primero por nombre y luego
	// por apellido)
	// por ejemplo si tenemos "Benito Arriaga" y "Benito Gonzales" se mostraran asi
	// -- Benito Arriaga
	// -- Benito Gonzales
	// Esto metodo se utilizan en Collections.sort() para ordernar los nombres como
	// anteriormente se describio
	@Override
	public int compareTo(Contact o) {
		int byFirstName = this.firstName.compareToIgnoreCase(o.firstName);
		if (byFirstName != 0)
			return byFirstName;
		return this.lastName.compareToIgnoreCase(o.lastName);
	}

	// Formato para imprimr un contacto -> "Pedro Paramo - 3124448999"
	@Override
	public String toString() {
		return firstName + " " + lastName + " - " + phoneNumber;
	}
}
