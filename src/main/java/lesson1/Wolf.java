package lesson1;

public class Wolf extends Animal implements CanSwim, CanRun, CanCrawl {
    private boolean isHungry;

    public Wolf(String name, String color, int age, double swimmingSpeed, double runningSpeed, double crawlingSpeed, boolean isHungry) {
        super(name, color, age, swimmingSpeed, runningSpeed, crawlingSpeed);
        this.isHungry = isHungry;
    }

    public boolean getIsHungry() {
        return isHungry;
    }

    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public void voice() {
        System.out.println("Волк воет!");
    }

    public double swim(Pool pool) {
        System.out.println("Я волчара, я плыву!");
        if (isHungry){
            System.out.println("Проплыл за " + pool.getLength() / (swimmingSpeed * 2) + "сек");
        } else {
            System.out.println("Проплыл за " + pool.getLength() / swimmingSpeed + "сек");
        }
        return pool.getLength() / swimmingSpeed;
    }

    public double run(Treadmill treadmill) {
        System.out.println("Я волчара, я бегу!");
        if (isHungry){
            System.out.println("Пробежал за " + treadmill.getLength() / (runningSpeed * 2) + "сек");
        } else {
            System.out.println("Пробежал за " + treadmill.getLength() / runningSpeed + "сек");
        }
        return treadmill.getLength() / runningSpeed;
    }

    public double crawl(Tube tube) {
        System.out.println("Я волчара, я ползу!");
        if (isHungry){
            System.out.println("Прополз за " + tube.getLength() / (crawlingSpeed * 2) + "сек");
        } else {
            System.out.println("Прополз за " + tube.getLength() / crawlingSpeed + "сек");
        }
        return tube.getLength() / crawlingSpeed;
    }

    public String toString () {
        return "Я " + color + " волк, меня зовут " + name + ", мне " + age + " лет";
    }
}
