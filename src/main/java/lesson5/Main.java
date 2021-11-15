package lesson5;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        SomeData data1 = new SomeData(new String[]{"Значение 1", "Значение 2", "Значение 3"}, new int[][]{{11,12,13},{21,22,23}});
        File someDataFile = new File("MyFileForSomeData.csv");
        try {
            someDataFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (PrintWriter fileWriter = new PrintWriter(someDataFile)) {
            for (int i = 0; i < data1.getHeader().length; i++) {
                    fileWriter.print(data1.getHeader()[i] + ";");
                }
                fileWriter.println();
            for (int j = 0; j < data1.getData().length; j++) {
                for (int k = 0; k < data1.getData()[j].length; k++) {
                        fileWriter.print(data1.getData()[j][k] + ";");
                    }
                    fileWriter.println();
                }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

        String[][] incomingArray = new String[3][3];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(someDataFile))){
            String tempData;
            int l = 0;
            while ((tempData = fileReader.readLine()) != null){
                String[] tempArray = tempData.split(";");
                incomingArray[l][0] = tempArray[0];
                incomingArray[l][1] = tempArray[1];
                incomingArray[l][2] = tempArray[2];
                l++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] tempHeaderArray = new String[3];
        int[][] tempDataArray = new int[2][3];

        for (int m = 0 ; m < 3 ; m++){
            tempHeaderArray[m] = incomingArray[0][m];
        }

       for (int n = 0 ; n < 2 ; n++){
           for (int o = 0 ; o < 3 ; o++){
               tempDataArray[n][o] = Integer.parseInt(incomingArray[n+1][o]);
            }
        }
        SomeData data2 = new SomeData(tempHeaderArray, tempDataArray);
        System.out.println("данные из файла загружены в новый объект. Содержимое объекта: " + data2);

    }
}
