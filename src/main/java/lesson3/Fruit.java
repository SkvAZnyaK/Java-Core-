package lesson3;

public class Fruit {
    private float fruitWeight;

    public Fruit(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }
}



// Первый вариант кода
//public class Fruit {
//    protected Double fruitWeight;
//    protected Double fruitVolume;
//
//    public Fruit (){
//        this.fruitWeight = fruitWeight;
//        this.fruitVolume = fruitVolume;
//    }
//
//
//    public Double getFruitWeight() {
//        return fruitWeight;
//    }
//
//    public void setFruitWeight(Double fruitWeight) {
//        this.fruitWeight = fruitWeight;
//    }
//
//    public Double getFruitVolume() {
//        return fruitVolume;
//    }
//
//    public void setFruitVolume(Double fruitVolume) {
//        this.fruitVolume = fruitVolume;
//    }
//}