package lesson4;

import java.util.HashMap;

public class PhoneBook extends HashMap {


    public PhoneBook() {
    }

    public void add (String surname, int phoneNumber){
        put(surname, phoneNumber);
    }

    public void get (String surname) {
        get(surname);
       // System.out.println(surname + ", телефон: " + get(surname));
    }
}
