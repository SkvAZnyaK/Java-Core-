package lesson1;

public class Course {
    protected String courseName;
    protected Pool obstacle1;
    protected Treadmill obstacle2;
    protected Tube obstacle3;

    public Course( String courseName, Pool obstacle1, Treadmill obstacle2, Tube obstacle3){
        this.courseName = courseName;
        this.obstacle1 = obstacle1;
        this.obstacle2 = obstacle2;
        this.obstacle3 = obstacle3;
    }


    public void doIt (Team team){
        team.tm1Res = obstacle1.length / team.teamMate1.swimmingSpeed;
        team.tm1Res = team.tm1Res + (obstacle2.length / team.teamMate1.runningSpeed);
        team.tm1Res = team.tm1Res + (obstacle3.length / team.teamMate1.crawlingSpeed);
        System.out.println("Участник номер один " + team.teamMate1.name + " прошел дистанцию за " + team.tm1Res + " секунд.");
        team.tm2Res = obstacle1.length / team.teamMate2.swimmingSpeed;
        team.tm2Res = team.tm2Res + (obstacle2.length / team.teamMate2.runningSpeed);
        team.tm2Res = team.tm2Res + (obstacle3.length / team.teamMate2.crawlingSpeed);
        System.out.println("Участник номер два " + team.teamMate2.name + " прошел дистанцию за " + team.tm2Res + " секунд.");
        team.tm3Res = obstacle1.length / team.teamMate3.swimmingSpeed;
        team.tm3Res = team.tm3Res + (obstacle2.length / team.teamMate3.runningSpeed);
        team.tm3Res = team.tm3Res + (obstacle3.length / team.teamMate3.crawlingSpeed);
        System.out.println("Участник номер три " + team.teamMate3.name + " прошел дистанцию за " + team.tm3Res + " секунд.");
        team.tm4Res = obstacle1.length / team.teamMate4.swimmingSpeed;
        team.tm4Res = team.tm4Res + (obstacle2.length / team.teamMate4.runningSpeed);
        team.tm4Res = team.tm4Res + (obstacle3.length / team.teamMate4.crawlingSpeed);
        System.out.println("Участник номер четыре " + team.teamMate4.name + " прошел дистанцию за " + team.tm4Res + " секунд.");
        System.out.println();
    }


}
