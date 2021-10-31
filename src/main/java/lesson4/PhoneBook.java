package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook extends ArrayList<Contact> {

    public PhoneBook() {
    }

    public void add (String surname, long phoneNumber){
        add(new Contact(surname, phoneNumber));
    }

    public void get (String surname) {
        for (int i = 0 ; i < size() ; i++){
            if (surname == getSurname(get(i))){
                System.out.println(get(i));
            }
        }
    }

    public String getSurname (Contact currentContact){
        return currentContact.getSurname();
    }

}
