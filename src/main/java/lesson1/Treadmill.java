package lesson1;

public class Treadmill extends Obstacle{

    public Treadmill(double length) {
        super (length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTimeToOvercomeTreadmill(CanRun runner) {
        return runner.run(this);
    }
}
