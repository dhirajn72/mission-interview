package headfirst.singleton;

public class Singleton {
    public static void main(String[] args){
        System.out.println("Singleton");

    }
	private static Singleton instance;
	private Singleton(){}
	public static Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}

}
