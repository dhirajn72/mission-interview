package headfirst.observer;

public class Observer_3 implements Observer, Display {
	private Subject weatherData;
	private float temperature, humidity, pressure;

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.display();
	}
	public Observer_3(Subject weaterData){
		this.weatherData = weatherData;
		weaterData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Observer 3, weather is = Temperature :" + this.temperature +", Humidity : " + this.humidity + ", Pressure : " + this.pressure );
	}
}
