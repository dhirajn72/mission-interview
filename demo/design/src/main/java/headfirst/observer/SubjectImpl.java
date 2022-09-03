package headfirst.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject{
	private List<Observer> observersList;
	private float temperature, pressure, humidity;
	public SubjectImpl(){
		this.observersList = new ArrayList<>();
	}
	@Override
	public void registerObserver(Observer observer) {
		observersList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		if(observersList.contains(observer)) {
			System.out.println("Observer " + observer + " has been removed");
			observersList.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		observersList.stream().forEach(observer -> observer.update(this.temperature, this.pressure, this.humidity));
	}
	public void setMeasurements(float temperature, float pressure, float humidity){
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		notifyObservers();
	}
}
