package lesson3;

public class Main1 {

    public static void main(String[] args) {
        String[] myArray = {"one","two"};
        System.out.println("Массив до обработки: " + myArray[0] + " ," + myArray[1]);
        replacement(myArray);
        System.out.println("Массив после обработки: " + myArray[0] + " ," + myArray[1]);


    }

    private static void replacement(String[] incomingArray) {
        String temp = incomingArray[0];
        incomingArray[0] = incomingArray[1];
        incomingArray[1] = temp;
    }
}
