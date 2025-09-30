# 📒 Hackathon CH_58 – Agenda Telefónica

Este proyecto fue desarrollado como parte del **Hackathon de la generación 58**, cuyo objetivo fue implementar una **Agenda Telefónica** en Java aplicando los principios de la programación orientada a objetos (POO).

---

## 📝 Descripción del proyecto

La aplicación es una agenda que permite **gestionar contactos** desde un menú en consola.
Cada contacto tiene:

* Nombre
* Apellido
* Número de teléfono

La agenda cuenta con una capacidad máxima configurable (por defecto **10 contactos**) y evita la duplicidad de contactos (mismo nombre y apellido).

---

## ⚙️ Funcionalidades

* ➕ **Añadir contacto** (validando nombre, apellido y teléfono).
* 🔍 **Buscar contacto** por nombre y apellido.
* 🗑️ **Eliminar contacto** existente.
* ✏️ **Actualizar número telefónico** de un contacto.
* 📖 **Listar todos los contactos** ordenados alfabéticamente.
* 📌 **Consultar espacios libres** en la agenda.
* 🚪 **Salir del programa**.

---

## 🧩 Estructura del código

* **`Contact.java`** → Clase que modela un contacto con validaciones y métodos sobrescritos (`equals`, `hashCode`, `compareTo`, `toString`).
* **`PhoneBook.java`** → Clase que gestiona la lista de contactos (alta, baja, búsqueda, actualización, listado y capacidad).
* **`Main.java`** → Clase con el menú de consola para interactuar con la agenda.

---

## ▶️ Ejecución

1. Compilar los archivos:

   ```bash
   javac org/generation/*.java
   ```

2. Ejecutar el programa:

   ```bash
   java org.generation.Main
   ```

---

## ✅ Ejemplo de uso

```
==================== PHONEBOOK MENU ====================
1. Add contact
2. Search contact
3. Remove contact
4. Update phone number
5. List all contacts
6. Show free slots
0. Exit
Choose an option:
```

---

## 🧪 Criterios de evaluación (rúbrica)

* Los contactos se consideran iguales si tienen el mismo **nombre y apellido**.
* Los nombres y apellidos no pueden estar vacíos.
* El teléfono no requiere un formato específico, pero **no puede estar vacío**.
* La agenda muestra un límite de contactos y no permite duplicados.

---

## 👨‍💻 Autores

Proyecto realizado por:
- **Jorge Rodríguez**

Este proyecto forma parte del Hackathon de la generación 58.


