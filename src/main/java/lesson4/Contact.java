package lesson4;

public class Contact {
    private  String surname;
    private long phoneNumber;

    public Contact(String surname, long phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return surname +
                ", телефон: " + phoneNumber +
                ".  ";
    }
}
