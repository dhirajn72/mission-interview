package headfirst.observer;

public class Observer_1 implements Observer, Display {
	private Subject weatherData; // We need if the Observer himself wants to remove from the observers list, Observer_1#removeFromObserverList
	private float temperature, humidity, pressure;

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.display();
	}
	public Observer_1(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	public void removeFromObserversList(){
		this.weatherData.removeObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Observer 1, weather is = Temperature :" + this.temperature +", Humidity : " + this.humidity + ", Pressure : " + this.pressure );
	}
}
