package lesson7.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.project.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
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

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException {
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

                //dataBaseRepository.saveWeatherToDataBase(new Weather()) - тут после парсинга добавляем данные в БД
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

    //http://dataservice.accuweather.com/locations/v1/295212?apikey=IJBBWkRUFc5GZt0gOhpm1BjG6k2VUDfu&language=ru


    public void weatherResponseOne(String response) throws JsonProcessingException {
        JsonNode dayCast = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Day/IconPhrase");
        JsonNode nightCast = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Night/IconPhrase");
        JsonNode date = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Date");
        JsonNode minTemp = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Temperature/Minimum/Value");
        JsonNode maxTemp = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Temperature/Maximum/Value");
        JsonNode tempUnit = objectMapper
                .readTree(response)
                .at("/DailyForecasts/Temperature/Minimum/Unit");
        System.out.println(date + "в городе " + UserInterfaceView.city + " днем ожидается " + dayCast + ", ночью ожидается " + nightCast +
                ", температура: от " + minTemp + tempUnit + " до " + maxTemp + tempUnit + ".");
    }

        public void weatherResponseFive(String response5) throws JsonProcessingException {
//            JsonNode firstDayCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Day/IconPhrase");
//            JsonNode firstNightCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Night/IconPhrase");
//            JsonNode firstDayDate = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Date");
//            JsonNode firstDayMinTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Value");
//            JsonNode firstDayMaxTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Maximum/Value");
//            JsonNode tempUnit = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Unit");
//
//            JsonNode secondDayCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Day/IconPhrase");
//            JsonNode secondNightCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Night/IconPhrase");
//            JsonNode secondDayDate = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Date");
//            JsonNode secondDayMinTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Value");
//            JsonNode secondDayMaxTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Maximum/Value");
//
//            JsonNode thirdDayCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Day/IconPhrase");
//            JsonNode thirdNightCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Night/IconPhrase");
//            JsonNode thirdDayDate = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Date");
//            JsonNode thirdDayMinTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Value");
//            JsonNode thirdDayMaxTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Maximum/Value");
//
//            JsonNode fourthDayCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Day/IconPhrase");
//            JsonNode fourthNightCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Night/IconPhrase");
//            JsonNode fourthDayDate = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Date");
//            JsonNode fourthDayMinTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Value");
//            JsonNode fourthDayMaxTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Maximum/Value");
//
//            JsonNode fifthDayCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Day/IconPhrase");
//            JsonNode fifthNightCast = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Night/IconPhrase");
//            JsonNode fifthDayDate = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Date");
//            JsonNode fifthDayMinTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Minimum/Value");
//            JsonNode fifthDayMaxTemp = objectMapper
//                    .readTree(response5)
//                    .at("/DailyForecasts/Temperature/Maximum/Value");
//
//            System.out.println("Прогноз на 5 дней для города: " + UserInterfaceView.city + ".");
//            System.out.println(firstDayDate + " днем ожидается " + firstDayCast + ", ночью ожидается " + firstNightCast +
//                    ", температура: от " + firstDayMinTemp + tempUnit + ", до " + firstDayMaxTemp + tempUnit + ".");
//            System.out.println(secondDayDate + " днем ожидается " + secondDayCast + ", ночью ожидается " + secondNightCast +
//                    ", температура: от " + secondDayMinTemp + tempUnit + ", до " + secondDayMaxTemp + tempUnit + ".");
//            System.out.println(thirdDayDate + " днем ожидается " + thirdDayCast + ", ночью ожидается " + thirdNightCast +
//                    ", температура: от " + thirdDayMinTemp + tempUnit + ", до " + thirdDayMaxTemp + tempUnit + ".");
//            System.out.println(fourthDayDate + " днем ожидается " + fourthDayCast + ", ночью ожидается " + fourthNightCast +
//                    ", температура: от " + fourthDayMinTemp + tempUnit + ", до " + fourthDayMaxTemp + tempUnit + ".");
//            System.out.println(fifthDayDate + " днем ожидается " + fifthDayCast + ", ночью ожидается " + fifthNightCast +
//                    ", температура: от " + fifthDayMinTemp + tempUnit + ", до " + fifthDayMaxTemp + tempUnit + ".");


            System.out.println("Метод еще не реализован");
        }

        public void weatherResponseTen(String response10){
            System.out.println("Метод еще не реализован");
        }

        public void weatherResponseFifteen(String response15){
            System.out.println("Метод еще не реализован");
        }


    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
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
    //Responce от акку прогноз на 1 день
    //{
    //  "Headline": {
    //    "EffectiveDate": "2021-11-05T01:00:00+03:00",
    //    "EffectiveEpochDate": 1636063200,
    //    "Severity": 3,
    //    "Text": "Четверг, поздняя ночь - Пятница, поздняя ночь: ожидается ливень",
    //    "Category": "rain",
    //    "EndDate": "2021-11-06T07:00:00+03:00",
    //    "EndEpochDate": 1636171200,
    //    "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c",
    //    "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c"
    //  },
    //  "DailyForecasts": [
    //    {
    //      "Date": "2021-11-04T07:00:00+03:00",
    //      "EpochDate": 1635998400,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": 5,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": 8.5,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 12,
    //        "IconPhrase": "Ливни",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Night": {
    //        "Icon": 40,
    //        "IconPhrase": "Преимущественно облачно с ливнями",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c"
    //    }
    //  ]
    //}


    //Responce от акку прогноз на 5 дней
    //{
    //  "Headline": {
    //    "EffectiveDate": "2021-11-10T01:00:00+03:00",
    //    "EffectiveEpochDate": 1636495200,
    //    "Severity": 2,
    //    "Text": "Вторник, поздняя ночь - Среда, утро: снег и изморозь с общим уровнем 1–3 см",
    //    "Category": "snow/ice",
    //    "EndDate": "2021-11-10T13:00:00+03:00",
    //    "EndEpochDate": 1636538400,
    //    "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c",
    //    "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c"
    //  },
    //  "DailyForecasts": [
    //    {
    //      "Date": "2021-11-05T07:00:00+03:00",
    //      "EpochDate": 1636084800,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": 3.8,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": 9.3,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 18,
    //        "IconPhrase": "Дождь",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Night": {
    //        "Icon": 18,
    //        "IconPhrase": "Дождь",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c"
    //    },
    //    {
    //      "Date": "2021-11-06T07:00:00+03:00",
    //      "EpochDate": 1636171200,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": 0.9,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": 5.3,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 12,
    //        "IconPhrase": "Ливни",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Moderate"
    //      },
    //      "Night": {
    //        "Icon": 12,
    //        "IconPhrase": "Ливни",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c"
    //    },
    //    {
    //      "Date": "2021-11-07T07:00:00+03:00",
    //      "EpochDate": 1636257600,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": 1.3,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": 4.4,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 6,
    //        "IconPhrase": "Преимущественно облачно",
    //        "HasPrecipitation": false
    //      },
    //      "Night": {
    //        "Icon": 29,
    //        "IconPhrase": "Снег с дождем",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Mixed",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c"
    //    },
    //    {
    //      "Date": "2021-11-08T07:00:00+03:00",
    //      "EpochDate": 1636344000,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": -3.2,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": 3.3,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 29,
    //        "IconPhrase": "Снег с дождем",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Mixed",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Night": {
    //        "Icon": 38,
    //        "IconPhrase": "Преимущественно облачно",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Rain",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c"
    //    },
    //    {
    //      "Date": "2021-11-09T07:00:00+03:00",
    //      "EpochDate": 1636430400,
    //      "Temperature": {
    //        "Minimum": {
    //          "Value": -3.4,
    //          "Unit": "C",
    //          "UnitType": 17
    //        },
    //        "Maximum": {
    //          "Value": -1.1,
    //          "Unit": "C",
    //          "UnitType": 17
    //        }
    //      },
    //      "Day": {
    //        "Icon": 4,
    //        "IconPhrase": "Переменная облачность",
    //        "HasPrecipitation": false
    //      },
    //      "Night": {
    //        "Icon": 19,
    //        "IconPhrase": "Небольшой снег",
    //        "HasPrecipitation": true,
    //        "PrecipitationType": "Snow",
    //        "PrecipitationIntensity": "Light"
    //      },
    //      "Sources": [
    //        "AccuWeather"
    //      ],
    //      "MobileLink": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c",
    //      "Link": "http://www.accuweather.com/ru/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c"
    //    }
    //  ]
    //}

    //Responce от акку прогноз на 10 дней
    //


    //Responce от акку прогноз на 15 дней
    //
}