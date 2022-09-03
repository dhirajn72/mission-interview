package headfirst.observer;

public class Observer_2 implements Observer, Display {
	private Subject weatherData;
	private float temperature, humidity, pressure;

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.display();
	}
	public Observer_2(Subject weaterData){
		this.weatherData = weatherData;
		weaterData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Observer 2, weather is = Temperature :" + this.temperature +", Humidity : " + this.humidity + ", Pressure : " + this.pressure );
	}
}
