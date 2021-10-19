package lesson2;

public class UncheckedExceptions {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        //Обрабатывать Unchecked - не рекомендуется
        try {
            int c = a / b;
        } catch (Exception e) {
            System.out.println("Исключение");
        }

        //Нужно писать код так, чтобы они были невозможны
        if (b != 0) {
            int c = a / b;
        }


        String[] strings = {"asdf", "asdf"};
        String strings1 = strings[2];
    }
}
