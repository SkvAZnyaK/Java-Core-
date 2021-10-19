package lesson1;

public class Turtle extends Animal implements CanSwim, CanRun, CanCrawl {
    private boolean isScared;

    public Turtle(String name, String color, int age, double swimmingSpeed, double runningSpeed, double crawlingSpeed, boolean isScared) {
        super(name, color, age, swimmingSpeed, runningSpeed, crawlingSpeed);
        this.isScared = isScared;
    }

    public boolean getIsScared() {
        return isScared;
    }

    public void setIsScared(boolean isScared) {
        this.isScared = isScared;
    }

    public void voice() {
        System.out.println("Черепаха фыркает!");
    }

    public double swim(Pool pool) {
        System.out.println("Я черепаха, я плыву!");
        if (isScared){
            System.out.println("Проплыла за " + pool.getLength() / (swimmingSpeed * 2) + "сек");
        } else {
            System.out.println("Проплыла за " + pool.getLength() / swimmingSpeed + "сек");
        }
        return pool.getLength() / swimmingSpeed;
    }

    public double run(Treadmill treadmill) {
        System.out.println("Я черепаха, я бегу!");
        if (isScared){
            System.out.println("Пробежала за " + treadmill.getLength() / (runningSpeed * 2) + "сек");
        } else {
            System.out.println("Пробежала за " + treadmill.getLength() / runningSpeed + "сек");
        }
        return treadmill.getLength() / runningSpeed;
    }

    public double crawl(Tube tube) {
        System.out.println("Я черепаха, я ползу!");
        if (isScared){
            System.out.println("Проползла за " + tube.getLength() / (crawlingSpeed * 2) + "сек");
        } else {
            System.out.println("Проползла за " + tube.getLength() / crawlingSpeed + "сек");
        }
        return tube.getLength() / crawlingSpeed;
    }

    public String toString () {
        return "Я " + color + " черепашка, меня зовут " + name + ", мне " + age + " лет";
    }
}
