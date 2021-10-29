package lesson3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitToAdd = new ArrayList<>();

    public Box() {
    }

    public void boxFilling(T someFruit) {
        fruitToAdd.add(someFruit);
        System.out.println("Вы положили в корзину 1 фрукт");
    }

    public void getWeight() {
        float fruitInBoxWeight = fruitToAdd.size() * fruitToAdd.get(0).getFruitWeight();
        System.out.println("Вес фруктов в корзине: " + fruitInBoxWeight + "кг.");
        }

    public void fromOneToEnother (Box<T> box) {
        box.getFruitList().addAll(fruitToAdd);
        fruitToAdd.clear();
        System.out.println("Вы пересыпали фрукты из одной коробки в другую");
    }

    public boolean compareTwoBoxes(Box<?> box){
        return fruitToAdd.size() * fruitToAdd.get(0).getFruitWeight() == box.fruitToAdd.size() * box.fruitToAdd.get(0).getFruitWeight();
    }

    public ArrayList<T> getFruitList() {
        return fruitToAdd;
    }
}


// Первый вариант кода
//public class Box <T extends Fruit>{
//    protected Double boxVolume = 0.03;
//    protected Double emptyVolume = 0.03;
//    protected Double fruitInBoxWeight = 0.0;
//    protected Double possibleFruitQuantity = 0.0;
//    protected int fruitInBoxQuantity = 0;
//
//    public Box (){
//        this.boxVolume = boxVolume;
//        this.emptyVolume = emptyVolume;
//        this.fruitInBoxWeight = fruitInBoxWeight;
//        this.possibleFruitQuantity = possibleFruitQuantity;
//        this.fruitInBoxQuantity = fruitInBoxQuantity;
//    }
//
//    public void boxFilling (Fruit fruit, int fruitQuantity){
//        possibleFruitQuantity = emptyVolume / fruit.getFruitVolume();
//        if ( possibleFruitQuantity >= fruitQuantity ){
//            emptyVolume -= ( fruitQuantity * fruit.getFruitVolume() );
//            fruitInBoxQuantity += fruitQuantity;
//            fruitInBoxWeight += ( fruitQuantity * fruit.getFruitWeight() );
//            System.out.println("Вы насыпали в коробку " + fruitQuantity + " фруктов. Теперь в ней находится " + fruitInBoxQuantity + " фруктов, и их вес составляет: " + fruitInBoxWeight + " кг.");
//        } else {
//            Double fruitLost = fruitQuantity - possibleFruitQuantity;
//            System.out.println("Вы попытались насыпать в коробку больше фруктов чем в нее помещается, поэтому в коробку попало только " + fruitQuantity + " фруктов, а остальные " + fruitLost + " укатились, и их погрызли мышки )))");
//        }
//
//    }
//
//    public Double getBoxVolume() {
//        return boxVolume;
//    }
//
//    public void setBoxVolume(Double boxVolume) {
//        this.boxVolume = boxVolume;
//    }
//
//    public Double getEmptyVolume() {
//        return emptyVolume;
//    }
//
//    public void setEmptyVolume(Double emptyVolume) {
//        this.emptyVolume = emptyVolume;
//    }
//
//    public Double getFruitInBoxWeight() {
//        return fruitInBoxWeight;
//    }
//
//    public void setFruitInBoxWeight(Double fruitInBoxWeight) {
//        this.fruitInBoxWeight = fruitInBoxWeight;
//    }
//
//    public Double getPossibleFruitQuantity() {
//        return possibleFruitQuantity;
//    }
//
//    public void setPossibleFruitQuantity(Double possibleFruitQuantity) {
//        this.possibleFruitQuantity = possibleFruitQuantity;
//    }
//
//    public int getFruitInBoxQuantity() {
//        return fruitInBoxQuantity;
//    }
//
//    public void setFruitInBoxQuantity(int fruitInBoxQuantity) {
//        this.fruitInBoxQuantity = fruitInBoxQuantity;
//    }
//}