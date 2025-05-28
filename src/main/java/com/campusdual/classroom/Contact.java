package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.Arrays;

public class Contact implements ICallActions {

    private String name;
    private String surname;
    private String phoneNumber;
    private String code;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = createCode(name, surname);
    }

    public static String createCode(String name, String surname) {
        String normalizedSurname = Normalizer.normalize(surname.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        String[] parts = normalizedSurname.split(" ");
        String surnameCode;

        if (parts.length > 2) {
            String[] partsWithoutFirstPart = Arrays.copyOfRange(parts, 1, parts.length);
            surnameCode = parts[0].charAt(0) + String.join("", partsWithoutFirstPart);
        }
        else if (parts.length > 1) {
            surnameCode = parts[0].charAt(0) + parts[parts.length - 1];
        } else {
            surnameCode = normalizedSurname;
        }

        return (name.toLowerCase().charAt(0) + surnameCode).replaceAll(" ", "");
    }


    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surname;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Calling " + name + " " + surname + " at " + phoneNumber);
    }

    @Override
    public void callOtherNumber(String phone) {
        System.out.println("Calling " + name + " " + surname + " at " + phone);
    }

    public void showContactDetails() {
        System.out.println("Contact Code: " + createCode(name, surname));
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Phone Numbers: " + String.join(", ", phoneNumber));
    }

}
