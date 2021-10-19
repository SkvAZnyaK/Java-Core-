package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ALotOfExceptions {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("sdafgdsaf");
        } catch (FileNotFoundException | ArithmeticException exception) { // Throwable - плохая практика!
            exception.printStackTrace();
        } catch (StackOverflowError error) { //error-ы также не принято обрабатывать
            System.out.println("asdfasdfdsa");
        } finally {
            System.out.println("Я все равно выполнился!");
        }

        System.out.println("Я жив!");
    }

    public static void test() {
        test();
    }
}
