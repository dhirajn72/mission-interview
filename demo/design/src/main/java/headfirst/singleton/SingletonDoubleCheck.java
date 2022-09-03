package headfirst.singleton;

public class SingletonDoubleCheck {
	private volatile static SingletonDoubleCheck instance;
	private SingletonDoubleCheck(){}
	public static SingletonDoubleCheck getInstance(){
		if(instance == null){
			synchronized(SingletonDoubleCheck.class){
				if(instance == null){
					instance = new SingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
}
