package lesson2;

public class CalculateSquare {
    public static void main(String[] args) {
        calcRectangleSquare(-1, 9);

        System.out.println("Я жив!");
    }

    public static int calcRectangleSquare(int sideA, int sideB) throws OneOrBothRectangleSideIsNegativeException {

        if (sideA <= 0 || sideB <= 0) {
            //System.out.println("Одна из сторон отрицательная!");
            //return -1;
            throw new OneOrBothRectangleSideIsNegativeException("Одна из сторон отрицательная: " + sideA + "," + sideB);
        }
        return sideA * sideB;
    }
}
