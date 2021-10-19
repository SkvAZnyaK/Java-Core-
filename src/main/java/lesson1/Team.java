package lesson1;

public class Team {
    protected String teamName;
    protected Cat teamMate1;
    protected Wolf teamMate2;
    protected Turtle teamMate3;
    protected Cat teamMate4;
    protected double tm1Res;
    protected double tm2Res;
    protected double tm3Res;
    protected double tm4Res;

    public Team ( String teamName, Cat teamMate1, Wolf teamMate2, Turtle teamMate3, Cat teamMate4) {
        this.teamName = teamName;
        this.teamMate1 = teamMate1;
        this.teamMate2 = teamMate2;
        this.teamMate3 = teamMate3;
        this.teamMate4 = teamMate4;
    }

    public void showResults(){
        double teamRes = tm1Res + tm2Res + tm3Res + tm4Res;
        System.out.println("Команда " + teamName + " прошла полосу препядствий за " + teamRes + " секунд." );
        System.out.println();
    }

    public void showTeamInfo(){
        System.out.println("Представляем вам команду " + teamName + ". А вот и участники команды:");
        System.out.println(teamMate1);
        System.out.println(teamMate2);
        System.out.println(teamMate3);
        System.out.println(teamMate4);
        System.out.println();
    }

}
