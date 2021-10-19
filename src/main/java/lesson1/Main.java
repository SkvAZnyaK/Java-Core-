package lesson1;

import static lesson1.Utils.makeAnimalOlder;

public class Main {
    public static void main(String[] args) {

        Course course1 = new Course( "Полоса препядствий 1" , new Pool(75), new Treadmill(200), new Tube(30) );

        Team team1 = new Team("Побеждаторы", new Cat("Мурка", "Черный", 10, 1, 5, 3, false),
                new Wolf("Василий", "серый", 12, 3, 5, 1, false),
                new Turtle("Тартила", "зеленая", 100, 5, 1, 1, true),
                new Cat("Дикарь", "Полосатый", 5, 1, 5, 3, true));

        team1.showTeamInfo();
        course1.doIt(team1);
        team1.showResults();



// Первый вариант кода
       // Cat catCompetitor1 = new Cat("Морис", "Черный", 10, 1, 5, 3, false);
       // Wolf wolfCompetitor1 = new Wolf("Василий", "серый", 12, 3, 5, 1, false);
        //Turtle turtleCompetitor1 = new Turtle("Тартила", "зеленая", 100, 5, 1, 1, true);

       // Pool[] pools = {new Pool(25), new Pool(50), new Pool(75)};
       // Treadmill[] treadmills = {new Treadmill(60), new Treadmill(100), new Treadmill(200)};
       // Tube[] tubes = {new Tube(10), new Tube(20), new Tube(30)};
//
       // for (Pool pool : pools) {
        //    pool.getTimeToOvercomePool(catCompetitor1);
        //    pool.getTimeToOvercomePool(wolfCompetitor1);
        //    pool.getTimeToOvercomePool(turtleCompetitor1);
        //}
//
       //for (Treadmill treadmill : treadmills) {
        //    treadmill.getTimeToOvercomeTreadmill(catCompetitor1);
        //    treadmill.getTimeToOvercomeTreadmill(wolfCompetitor1);
        //    treadmill.getTimeToOvercomeTreadmill(turtleCompetitor1);
       // }
//
        //for (Tube tube : tubes) {
        //    tube.getTimeToOvercomeTube(catCompetitor1);
        //    tube.getTimeToOvercomeTube(wolfCompetitor1);
        //    tube.getTimeToOvercomeTube(turtleCompetitor1);
        //}

    }
}
