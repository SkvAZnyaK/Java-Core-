package lesson7.project;

import lesson7.project.entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String insertWeather = "insert into weather (city, dayWeatherText, nightWeatherText, localDate, minTemperature, maxTemperature, temperatureUnit)" +
            " values (?, ?, ?, ?, ?, ?, ?)";
    private static final String getWeather = "select * from weather"; // where city = " + "'" + UserInterfaceView.city + "'"; ((( не вышел каменный цветок...
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection saveConnection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = saveConnection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getDayWeatherText());
            saveWeather.setString(3, weather.getNightWeatherText());
            saveWeather.setString(4, weather.getLocalDate());
            saveWeather.setDouble(5, weather.getMinTemperature());
            saveWeather.setDouble(6, weather.getMaxTemperature());
            saveWeather.setString(7, weather.getTemperatureUnit());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public List<Weather> getSavedToDBWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection getConnection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = getConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                System.out.println("В городе " + resultSet.getString("city") + " " + resultSet.getString("localDate") +
                        " днём ожидается " + resultSet.getString("dayWeatherText") + ", ночью ожидается " + resultSet.getString("nightWeatherText") +
                        ", температура: от " + resultSet.getDouble("minTemperature") + resultSet.getString("temperatureUnit") +
                        ", до " + resultSet.getDouble("maxTemperature") +
                        resultSet.getString("temperatureUnit") + ".");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }

    //    Этот метод больше не нужен, т.к. сохранение прогнозов более чем на один день происходит в конце каждой итерации цикла в простой объект Weather, а не в List.
    //    Таким образом List из Weather в данном случае больше не нужен.

//    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
//        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
//            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
//            for (Weather weather : weatherList) {
//                saveWeather.setString(1, weather.getCity());
//                saveWeather.setString(2, weather.getDayWeatherText());
//                saveWeather.setString(3, weather.getNightWeatherText());
//                saveWeather.setString(4, weather.getLocalDate());
//                saveWeather.setDouble(5, weather.getMinTemperature());
//                saveWeather.setDouble(6, weather.getMaxTemperature());
//                saveWeather.setString(7, weather.getTemperatureUnit());
//                saveWeather.addBatch();
//            }
//            saveWeather.executeBatch();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
