package multithreadin;
class CustomThread implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started.");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
		System.out.println(Thread.currentThread().getName() + " exited.");
	}
}
public class ThreadJoinTest {
	public static void main(String args[]) throws InterruptedException {
		//Thread t1 = new Thread( new CustomThread(), "Thread-1");
		//Thread t2 = new Thread( new CustomThread(), "Thread-2");
		//Thread t3 = new Thread( new CustomThread(), "Thread-3");
		Thread mythread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " started.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted.");
			}
			System.out.println(Thread.currentThread().getName() + " exited.");
		});

		//t1.start();
		//main thread class the join on t1
		//and once t1 is finish then only t2 can start
		//t1.join();
		//t2.start();
		//main thread class the join on t2
		//and once t2 is finish then only t3 can start
		//t2.join();
		//t3.start();

		Thread t1 = new Thread(mythread);
		Thread t2 = new Thread(mythread);
		Thread t3 = new Thread(mythread);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();


		Testable testable = (s) -> {  return s == null ? "string is null" : s;};

		String result = testable.test(null);
		System.out.println(result);
		result = testable.test("oracle");
		System.out.println(result);
	}

	interface Testable{
		String test(String str);
	}
}