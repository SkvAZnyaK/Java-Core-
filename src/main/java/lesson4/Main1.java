package lesson4;

import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {

        ArrayList<String> wordArray = new ArrayList<>(20);
        wordArray.add("Аптека");
        wordArray.add("Улица");
        wordArray.add("Фонарь");
        wordArray.add("Подоконник");
        wordArray.add("Сол");
        wordArray.add("Фасол");
        wordArray.add("Антресол");
        wordArray.add("Подоконник");
        wordArray.add("Лёшка");
        wordArray.add("Вилька");
        wordArray.add("Бутилька");
        wordArray.add("Подоконник");
        wordArray.add("Яуза-Яуза-Яуза");
        wordArray.add("Яуза-Яуза-Яуза");
        wordArray.add("Яуза-Яуза-Яуза");
        wordArray.add("Подоконник");
        wordArray.add("Три");
        wordArray.add("Семнадцать");
        wordArray.add("Десять");
        wordArray.add("Двадцать");

        ArrayList<String> repeats = new ArrayList<>();

        for (int i = 0; i < wordArray.size() ; i++){
            String currentWord = wordArray.get(i);
            if (wordArray.contains(String.valueOf(currentWord)) && !repeats.contains(String.valueOf(currentWord))){
                repeats.add(String.valueOf(currentWord));
            }
        }
        System.out.println("Список уникальных слов в коллекции: " + repeats);

        int wordCount;
        for (int i = 0 ; i < repeats.size() ; i++){
            wordCount = 0;
            for ( int j = 0 ; j < wordArray.size() ; j++){
                if (repeats.get(i) == wordArray.get(j)){
                    wordCount++;
                }
            }
            System.out.println("Слово " + repeats.get(i) + " содержится в коллекции " + wordCount + " раз." );
        }
        wordArray.clear();
        repeats.clear();
    }
}
