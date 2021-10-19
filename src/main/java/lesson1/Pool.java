package lesson1;

public class Pool extends Obstacle{

    public Pool(double length) {
        super (length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTimeToOvercomePool(CanSwim swimmer) {
        return swimmer.swim(this);
    }
}
