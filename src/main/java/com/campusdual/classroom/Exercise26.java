package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Phonebook myPhonebook = new Phonebook();

        Contact c1 = new Contact("Javier", "López", "654321321");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "654321321");
        Contact c3 = new Contact("Jose Manuel", "Soria", "654321321");
        Contact c4 = new Contact("Santiago", "Fernández Rocha", "654321321");
        Contact c5 = new Contact("Esteban", "Serrano del Río", "654321321");
        Contact c6 = new Contact("Fernando Miguel", "Juan de los Santos Requejo León", "654321321");

        myPhonebook.addContact(c1);
        myPhonebook.addContact(c2);
        myPhonebook.addContact(c3);
        myPhonebook.addContact(c4);
        myPhonebook.addContact(c5);
        myPhonebook.addContact(c6);

        myPhonebook.showMenu();

    }
}
