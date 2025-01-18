package observer;

public class CurrentStateDisplay implements Observer, Display {

    private WeatherData weatherData;

    @Override
    public void display() {
        System.out.println("Current State : " + weatherData);
    }

    @Override
    public String getName() {
        return "CurrentStateDisplay";
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }
}
