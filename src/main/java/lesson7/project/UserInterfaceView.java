package lesson7.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public static String city;

    public String getCity() {
        return city;
    }

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите наименование города: ");
            city = scanner.nextLine();

            System.out.println("Введите: 1 для получения погоды на сегодня, 5 для получения прогноза на 5 дней, " +
                    "10 для получения прогноза на 10 дней, 15 для получения прогноза на 15 дней. " +
                    "Введите 2 для получения данных из базы. Для выхода введите 0:");

            String command = scanner.nextLine();
            // Сделал подобие валидации вводимых команд ))
            if (!command.equals("1")){
                if (!command.equals("2")){
                    if (!command.equals("5")){
                        if (!command.equals("10")){
                            if (!command.equals("15")){
                                System.out.println("Введена неверная команда!");
                                break;
                            }
                        }
                    }
                }
            }

            try {
                controller.getWeather(command, city);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
