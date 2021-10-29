package lesson4;

public class Main2 {
    public static void main(String[] args) {

        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.add("Карпухин", 9001213);
        phoneBook1.add("Карпухин", 9992021);
        phoneBook1.add("Гагарин", 6355657);
        phoneBook1.add("Полетаев", 5895455);
        phoneBook1.get("Карпухин");
    }
}
