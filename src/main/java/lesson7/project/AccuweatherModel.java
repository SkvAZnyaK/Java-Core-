package lesson7.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.project.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYZ = "5day";
    private static final String TEN_DAYZ = "10day";
    private static final String FIFTEEN_DAYZ = "15day";
    private static final String API_KEY = "IJBBWkRUFc5GZt0gOhpm1BjG6k2VUDfu";
    private static final String LANGUAGE = "ru";
    private static final String LANGUAGE_QUERY_PARAM = "language";
    private static final String METRIC = "true";
    private static final String METRIC_QUERY_PARAM = "metric";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException, SQLException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                weatherResponseOne(weatherResponse);
                break;
            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYZ)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5).execute();
                String weatherResponse5 = fiveDayForecastResponse.body().string();
                weatherResponseFive(weatherResponse5);
                break;
            case TEN_DAYS:
                HttpUrl httpUrl10 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(TEN_DAYZ)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request request10 = new Request.Builder()
                        .url(httpUrl10)
                        .build();

                Response tenDayForecastResponse = okHttpClient.newCall(request10).execute();
                String weatherResponse10 = tenDayForecastResponse.body().string();
                weatherResponseTen(weatherResponse10);
                break;

            case FIFTEEN_DAYS:
                HttpUrl httpUrl15 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIFTEEN_DAYZ)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request request15 = new Request.Builder()
                        .url(httpUrl15)
                        .build();

                Response fifteenDayForecastResponse = okHttpClient.newCall(request15).execute();
                String weatherResponse15 = fifteenDayForecastResponse.body().string();
                weatherResponseFifteen(weatherResponse15);
                break;
        }
    }

    public void weatherResponseOne(String response) throws JsonProcessingException, SQLException {
        String dayCast = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Day").at("/IconPhrase").asText();
        String nightCast = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Night").at("/IconPhrase").asText();
        String date = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Date").asText();
        String minTemp = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Temperature").at("/Minimum").at("/Value").asText();
        String maxTemp = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Temperature").at("/Maximum").at("/Value").asText();
        String tempUnit = objectMapper.readTree(response).at("/DailyForecasts").get(0).at("/Temperature").at("/Minimum").at("/Unit").asText();

        System.out.println(date + " в городе " + UserInterfaceView.city + ", днем ожидается: " + dayCast + ", ночью ожидается: " + nightCast +
                ". Температура: от " + minTemp + tempUnit + " до " + maxTemp + tempUnit + ".");

        dataBaseRepository.saveWeatherToDataBase(new Weather(UserInterfaceView.city, dayCast, nightCast, date, Double.parseDouble(minTemp),
                Double.parseDouble(maxTemp), tempUnit));
    }

        public void weatherResponseFive(String response5) throws JsonProcessingException, SQLException {
            System.out.println("Прогноз на 5 дней для города: " + UserInterfaceView.city + ".");
            for (int i = 0 ; i <= 4 ; i++){
                String dayCast = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Day").at("/IconPhrase").asText();
                String nightCast = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Night").at("/IconPhrase").asText();
                String dayDate = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Date").asText();
                String dayMinTemp = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Value").asText();
                String dayMaxTemp = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Temperature").at("/Maximum").at("/Value").asText();
                String tempUnit = objectMapper.readTree(response5).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Unit").asText();

                System.out.println(dayDate + " днем ожидается " + dayCast + ", ночью ожидается " + nightCast +
                        ", температура: от " + dayMinTemp + tempUnit + ", до " + dayMaxTemp + tempUnit + ".");

                dataBaseRepository.saveWeatherToDataBase(new Weather(UserInterfaceView.city, dayCast, nightCast, dayDate, Double.parseDouble(dayMinTemp),
                        Double.parseDouble(dayMaxTemp), tempUnit));
            }
        }

        public void weatherResponseTen(String response10) throws JsonProcessingException, SQLException {
            System.out.println("Прогноз на 10 дней для города: " + UserInterfaceView.city + ".");
            for (int i = 0 ; i <= 9 ; i++){
                String dayCast = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Day").at("/IconPhrase").asText();
                String nightCast = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Night").at("/IconPhrase").asText();
                String dayDate = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Date").asText();
                String dayMinTemp = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Value").asText();
                String dayMaxTemp = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Temperature").at("/Maximum").at("/Value").asText();
                String tempUnit = objectMapper.readTree(response10).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Unit").asText();

                System.out.println(dayDate + " днем ожидается " + dayCast + ", ночью ожидается " + nightCast +
                        ", температура: от " + dayMinTemp + tempUnit + ", до " + dayMaxTemp + tempUnit + ".");

                dataBaseRepository.saveWeatherToDataBase(new Weather(UserInterfaceView.city, dayCast, nightCast, dayDate, Double.parseDouble(dayMinTemp),
                        Double.parseDouble(dayMaxTemp), tempUnit));
            }
        }

        public void weatherResponseFifteen(String response15) throws JsonProcessingException, SQLException {
            System.out.println("Прогноз на 15 дней для города: " + UserInterfaceView.city + ".");
            for (int i = 0 ; i <= 14 ; i++){
                String dayCast = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Day").at("/IconPhrase").asText();
                String nightCast = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Night").at("/IconPhrase").asText();
                String dayDate = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Date").asText();
                String dayMinTemp = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Value").asText();
                String dayMaxTemp = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Temperature").at("/Maximum").at("/Value").asText();
                String tempUnit = objectMapper.readTree(response15).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Unit").asText();

                System.out.println(dayDate + " днем ожидается " + dayCast + ", ночью ожидается " + nightCast +
                        ", температура: от " + dayMinTemp + tempUnit + ", до " + dayMaxTemp + tempUnit + ".");

                dataBaseRepository.saveWeatherToDataBase(new Weather(UserInterfaceView.city, dayCast, nightCast, dayDate, Double.parseDouble(dayMinTemp),
                        Double.parseDouble(dayMaxTemp), tempUnit));
            }
        }

    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrlCity = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrlCity)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }

}