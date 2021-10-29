package lesson3;

public class Main2 {

    public static void main(String[] args) {
//Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
// равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
// Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

        Box <Apple> applesBox1 = new Box<>();
        Box <Apple> applesBox2 = new Box<>();
        Box <Orange> orangesBox1 = new Box<>();
        Box <Orange> orangesBox2 = new Box<>();

        applesBox1.boxFilling(new Apple());
        orangesBox1.boxFilling(new Orange());
        applesBox2.boxFilling(new Apple());
        orangesBox2.boxFilling(new Orange());

        applesBox1.getWeight();
        applesBox2.getWeight();
        orangesBox1.getWeight();
        orangesBox1.getWeight();

        applesBox1.fromOneToEnother(applesBox2);
        orangesBox1.fromOneToEnother(orangesBox2);

        applesBox1.getWeight();
        applesBox2.getWeight();
        orangesBox1.getWeight();
        orangesBox1.getWeight();

        System.out.println("Результат сравнения двух коробок: " + applesBox2.compareTwoBoxes(orangesBox2));


        // Первый вариант кода
        //Apple oneApple = new Apple();
        //Orange oneOrange = new Orange();
        //Box applesBox1 = new Box();
        //Box applesBox2 = new Box();
        //Box orangesBox1 = new Box();
        //Box orangesBox2 = new Box();
        //applesBox1.boxFilling(oneApple, 700);
        //applesBox2.boxFilling(oneApple, 200);
        //orangesBox1.boxFilling(oneOrange, 500);
        //orangesBox2.boxFilling(oneOrange, 200);



    }
}