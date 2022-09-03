package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer_HeadFirst {
	public static void main(String[] args){
		WeatherData weatherData = new WeatherData();
		CurrentCondition current = new CurrentCondition(weatherData);
		EveningCondition evening = new EveningCondition(weatherData);
		weatherData.setMeasurement(10, 20, 30);
		weatherData.setMeasurement(10, 20, 50);
		weatherData.removeObserver(current);

	}
}

interface Observable{
	void update(float temp, float humidity, float pressure);
}
interface Subject{
	void registerObserver(Observable obj);
	void removeObserver(Observable obj);
	void notifyObservers();
}

class WeatherData implements Subject{
	private List<Observable> observableList = new ArrayList<>();
	private float temp;
	private float humidity;
	private float pressure;

	@Override
	public void registerObserver(Observable obj) {
		this.observableList.add(obj);
	}

	@Override
	public void removeObserver(Observable obj) {
		int index = this.observableList.indexOf(obj);
		if(index >= 0){
			this.observableList.remove(obj);
			System.out.println("Removed Observer : " + obj);
		}
	}
	public void setMeasurement(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for(Observable obj : observableList){
			obj.update(this.temp, this.humidity, this.pressure);
		}
	}
}
interface Display {
	void display();
}

class CurrentCondition implements Observable, Display {
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public CurrentCondition(Subject weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	@Override
	public void display() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "CurrentCondition{" +
				"temp=" + temp +
				", humidity=" + humidity +
				", pressure=" + pressure +
				", weatherData=" + weatherData +
				'}';
	}
}

class EveningCondition implements Observable, Display {
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	public EveningCondition(Subject weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	@Override
	public void display() {
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "EveningCondition{" +
				"temp=" + temp +
				", humidity=" + humidity +
				", pressure=" + pressure +
				", weatherData=" + weatherData +
				'}';
	}
}