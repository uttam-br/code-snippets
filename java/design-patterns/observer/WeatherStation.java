package observer;

public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentStateDisplay currentStateDisplay = new CurrentStateDisplay();
        weatherData.registerObserver(currentStateDisplay);

        weatherData.setMeasurements(80, 90, 100);

        weatherData.setMeasurements(50, 50, 50);
    }

}
