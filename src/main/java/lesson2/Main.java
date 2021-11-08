package lesson2;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        //{{"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"}}
        //{{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4","5"}}
        //{{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}}
        //{{"1","2","3","4"},{"1","re","3","4"},{"1","2","3","4"},{"1","2","3","4"}}
        String[][] someArray = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        myArray(someArray);
        stringToIntConvert(someArray);
    }

    public static void myArray(String[][] array4x4) throws MyArraySizeException {
            if (array4x4.length != 4) {
                throw new MyArraySizeException("Массив первого уровня имеет размер " + array4x4.length + " вместо 4");
            }
                for (int i = 0 ; i < array4x4.length ; i++){
                    if (array4x4[i].length != 4){
                        throw new MyArraySizeException("Массив " + (i+1) + "-ого уровня имеет размер " + array4x4[i].length + " вместо 4");
                    }
                    }
        }

    public static void stringToIntConvert(String[][] arrayToConvert) throws MyArrayDataException {
        int arraySumm = 0;
        for(int i = 0; i < arrayToConvert.length ; i++ ){
            for(int j = 0; j < arrayToConvert[i].length ; j++ ){
                try {
                    arraySumm += Integer.parseInt (arrayToConvert[i][j]);
                } catch (NumberFormatException stringToInt) {
                    throw new MyArrayDataException("Не верный формат данных в массиве, в ячейке " + i + "." + j );
                }
            }
        }
        System.out.println("Сумма всех чисел в массиве равна " + arraySumm);
    }
}
