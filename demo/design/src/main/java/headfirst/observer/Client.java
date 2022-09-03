package headfirst.observer;

public class Client {
	public static void main(String[] args){
		SubjectImpl subjectImpl = new SubjectImpl();

		Observer_1 observer1 = new Observer_1(subjectImpl);
		//Observer_3 observer3 = new Observer_3(subjectImpl);
		//Observer_2 observer2 = new Observer_2(subjectImpl);

		subjectImpl.setMeasurements(80, 90, 100);
		subjectImpl.setMeasurements(100,0,0);
		//weatherData.removeObserver(observer1);
		//System.out.println("Observer 1 has been removed");
		//observer1.removeFromObserversList();
		//subjectImpl.notifyObservers();

	}
}
