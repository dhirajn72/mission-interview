package multithreadin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
	private volatile int count;
	void doStuff(){
		System.out.println(Thread.currentThread().getName() +" outside the sychronized block");
		synchronized (this){
			System.out.println(Thread.currentThread().getName() + " inside the synchronized block");
			count = count + 1;
			System.out.println("Count incremented" + count);
			try {
				Thread.sleep(500);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService executors =  Executors.newFixedThreadPool(40);
		int[] arr = {6,7,8,2,3,0,2,0};
		Test1 obj = new Test1();
		for(int e : arr) {
			executors.submit(() -> obj.doStuff());
		}
		executors.shutdown();
	}
}
