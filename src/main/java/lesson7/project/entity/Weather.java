package lesson7.project.entity;

public class Weather {
    private String city;
    private String dayWeatherText;
    private String nightWeatherText;
    private String localDate;
    private double minTemperature;
    private double maxTemperature;
    private String temperatureUnit;

    public Weather(String city, String dayWeatherText, String nightWeatherText, String localDate, double minTemperature, double maxTemperature, String temperatureUnit) {
        this.city = city;
        this.dayWeatherText = dayWeatherText;
        this.nightWeatherText = nightWeatherText;
        this.localDate = localDate;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.temperatureUnit = temperatureUnit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDayWeatherText() {
        return dayWeatherText;
    }

    public void setDayWeatherText(String dayWeatherText) {
        this.dayWeatherText = dayWeatherText;
    }

    public String getNightWeatherText() {
        return nightWeatherText;
    }

    public void setNightWeatherText(String nightWeatherText) {
        this.nightWeatherText = nightWeatherText;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", dayWeatherText='" + dayWeatherText + '\'' +
                ", nightWeatherText='" + nightWeatherText + '\'' +
                ", localDate='" + localDate + '\'' +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", temperatureUnit='" + temperatureUnit + '\'' +
                '}';
    }
}