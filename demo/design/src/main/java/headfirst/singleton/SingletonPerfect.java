package headfirst.singleton;

import java.io.Serializable;

public class SingletonPerfect implements Cloneable, Serializable {
	private static SingletonPerfect instance ;
	private SingletonPerfect(){};
	public static SingletonPerfect getInstance(){
		if(instance == null){
			synchronized(SingletonPerfect.class){
				if(instance == null){
					instance = new SingletonPerfect();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	protected Object readResolve(){
		return getInstance();
	}
}
