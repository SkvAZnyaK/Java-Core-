package lesson1;

public class Tube extends Obstacle{

    public Tube(double length) {
        super (length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTimeToOvercomeTube(CanCrawl crawler) {
        return crawler.crawl(this);
    }
}
