package lesson7.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
        variants.put(10, Period.TEN_DAYS);
        variants.put(15, Period.FIFTEEN_DAYS);
        variants.put(2, Period.DB);
    }
    public static String cityName;

    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                cityName = selectedCity;
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                cityName = selectedCity;
                break;
            case TEN_DAYS:
                weatherModel.getWeather(selectedCity, Period.TEN_DAYS);
                cityName = selectedCity;
                break;
            case FIFTEEN_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIFTEEN_DAYS);
                cityName = selectedCity;
                break;
            case DB:
                weatherModel.getSavedToDBWeather();
        }
    }
}
