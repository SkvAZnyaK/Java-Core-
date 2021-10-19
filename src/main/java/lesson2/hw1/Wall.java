package lesson2.hw1;

public class Wall implements Overcomable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void overcome(Competitable competitable) {
        competitable.jump(height);
    }
}
