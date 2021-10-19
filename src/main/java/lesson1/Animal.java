package lesson1;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;
    protected double swimmingSpeed;
    protected double runningSpeed;
    protected double crawlingSpeed;


    public Animal(String name, String color, int age, double swimmingSpeed, double runningSpeed, double crawlingSpeed) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.swimmingSpeed = swimmingSpeed;
        this.runningSpeed = runningSpeed;
        this.crawlingSpeed = crawlingSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public double getCrawlingSpeed() {
        return crawlingSpeed;
    }

    public void setCrawlingSpeed(double crawlingSpeed) {
        this.crawlingSpeed = crawlingSpeed;
    }

    public abstract void voice();
}
