package lesson5;

import java.io.Serializable;
import java.util.Arrays;

public class SomeData implements Serializable {
    private String[] header;
    private int[][] data;

    public SomeData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(header) + " [" + data[0][0] + "." + data[0][1] + "." + data[0][2] + "] [" + data[1][0] + "." + data[1][1] + "." + data[1][2] + "]";
    }
}
