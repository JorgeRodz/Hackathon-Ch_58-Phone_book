package org.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {

	private final List<Contact> contacts;
	private final int maximunCapacity;

	public PhoneBook() {
		this(10); // Capacidad por default cuando se crear un Objecto PhoneBook sin especificar la capacidad maxima
	}

	// method overlad del constructor, para crear un nuevo objeto ->
	// -> PhoneBook con una capacidad setea desde la creacion de la instancia
	// Agregamos una validacion para 'capacity' en dado caso de numero negativos
	public PhoneBook(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("----> Capacity must be greater than 0.");
		}
		this.maximunCapacity = capacity;
		this.contacts = new ArrayList<>();
	}

	public boolean addContact(Contact contact) {

		// validacion de lista llena
		if (contacts.size() >= maximunCapacity) {
			System.out.println("----> ⚠️ PhoneBook is full. Cannot add more contacts.");
			return false;
		}
		
		// validacion para contacto duplicado
		if (contacts.contains(contact)) {
			System.out.println("----> ⚠️ Contact already exists: " + contact);
			return false;
		}
		
		// Si pasa las validaciones se agrega el nuevo contacto
		contacts.add(contact);
		System.out.println("----> ✅ Contact added successfully: " + contact);
		return true;
	}

	public boolean removeContact(String firstName, String lastName) {

		// Cramos un objeto Contacto dummy solo con nombre y apellido
		// El metodo equals() de contacto solo toma en cuenta el nombre y apellido, el numero es irrelvante aqui
		Contact dummy = new Contact(firstName, lastName, "");

		// El metodo List.remove() hace uso interno de equals()
		// El metodo List.remove() recorre la lista en busquedo del objeto, si encuentra un objeto igual lo elimina.
		if (contacts.remove(dummy)) {
			System.out.println("----> 🗑️ Contact removed successfully: " + firstName + " " + lastName);
			return true;
		} else {
			System.out.println("----> ⚠️ Contact not found: " + firstName + " " + lastName);
			return false;
		}
	}

	public Contact searchContact(String firstName, String lastName) {

		// Creamos un objeto Contacto dummy solo con nombre y apellido
		// El metodo equals() de contacto solo toma en cuenta el nombre y apellido, el numero es irrelvante aqui
		Contact dummy = new Contact(firstName, lastName, "");
		
		// Buscamos en la lista de contactos un contacto igual al 'dummy'
		// - Si -> lo encuentra devuelve el valor del index(ej. 0, 1, 2, 3, ...)
		// - No -> lo encuentra devulve un -1
		int index = contacts.indexOf(dummy);
		
		// Si -> el index es mayor o igual a 0 -> retornasmos el objeto Contacto de la lista
		//   - Con el metodo List.get() obteneos el objeto de la lista
		// No -> lo encontramos, solo retornamos -> null
		return index >= 0 ? contacts.get(index) : null;
	}

	public boolean updatePhoneNumber(String firstName, String lastName, String newPhone) {
		Contact found = searchContact(firstName, lastName);

		// if guard -> si lo encuentra procedemos a actulizar el numero
		// y retornamos true
		if (found != null) {
			found.setPhoneNumber(newPhone);
			System.out.println("----> 📞 Phone number updated successfully: " + found);
			return true;
		}
		
		// si no se cumple el 'if guard' imprimimos el mensaje 
		System.out.println("----> ⚠️ Contact not found.");
		// retornamos false
		return false;
	}

	public void listContacts() {

		// if guard -> usamos el metodo List.isEmpty para saber si la lista esta vacia
		if (contacts.isEmpty()) {
			System.out.println("----> 📭 PhoneBook is empty.");
			return;
		}
		
		// sino entra en el 'if guard' de arriba se sigue el flujo de la aplicacion
		
		// Cramos una copia de lista solo para no reordenar el array original
		List<Contact> sorted = new ArrayList<>(contacts);
	
		// Ordenamos la copia de la lista
		Collections.sort(sorted);
		
		System.out.println("----- 📖 Contact list -----:");
		sorted.forEach(System.out::println);
	}

	public int freeSlots() {
		return maximunCapacity - contacts.size();
	}

	public boolean isFull() {
		return contacts.size() >= maximunCapacity;
	}

}
