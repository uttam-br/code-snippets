package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private double pressure;
    private double temperature;
    private double humidity;

    public double getPressure() {
        return pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setMeasurements(double pressure, double temperature, double humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pressure=" + pressure + ", temperature=" + temperature + ", humidity=" + humidity;
    }

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            System.out.println("Notifying observer " + observer.getName());
            observer.update(this);
        }
    }
}
