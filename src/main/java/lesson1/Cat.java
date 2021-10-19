package lesson1;

import java.util.Objects;

public class Cat extends Animal implements CanSwim, CanRun, CanCrawl {
    private boolean isWild;

    public Cat(String name, String color, int age, double swimmingSpeed, double runningSpeed, double crawlingSpeed, boolean isWild) {
        super(name, color, age, swimmingSpeed, runningSpeed, crawlingSpeed);
        this.isWild = isWild;
    }

    public boolean getIsWild() {
        return isWild;
    }

    public void setIsWild(boolean wild) {
        isWild = wild;
    }

    public void voice() {
        System.out.println("Кот мяукает!");
    }

    public double swim(Pool pool) {
        System.out.println("Я котейка, я плыву!");
        if (isWild){
            System.out.println("Проплыл за " + pool.getLength() / (swimmingSpeed * 2) + "сек");
        } else {
            System.out.println("Проплыл за " + pool.getLength() / swimmingSpeed + "сек");
        }
        return pool.getLength() / swimmingSpeed;
    }

    public double run(Treadmill treadmill) {
        System.out.println("Я котейка, я бегу!");
        if (isWild){
            System.out.println("Пробежал за " + treadmill.getLength() / (runningSpeed * 2) + "сек");
        } else {
            System.out.println("Пробежал за " + treadmill.getLength() / runningSpeed + "сек");
        }
        return treadmill.getLength() / runningSpeed;
    }

    public double crawl(Tube tube) {
        System.out.println("Я котейка, я ползу!");
        if (isWild){
            System.out.println("Проползл за " + tube.getLength() / (crawlingSpeed * 2) + "сек");
        } else {
            System.out.println("Прополз за " + tube.getLength() / crawlingSpeed + "сек");
        }
        return tube.getLength() / crawlingSpeed;
    }

    public String toString () {
        return "Я " + color + " кот, меня зовут " + name + ", мне " + age + " лет";
    }
}