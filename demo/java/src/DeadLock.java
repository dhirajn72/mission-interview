import java.util.Arrays;
public class DeadLock extends Thread {
	private static final Object ob1 = new Object();
	private static final Object ob2 = new Object();

	static Thread t1 = new Thread() {
		public void run() {
			synchronized (ob1) {
				System.out.println("locked ob1");
				System.out.println("waiting for ob2");
				synchronized (ob2) {
					System.out.println("locked ob2");
				}
			}
		}
	};

	static Thread t2 = new Thread(() -> {
		synchronized (ob2) {
			System.out.println("locked ob2");
			System.out.println("waiting for ob1");
			synchronized (ob1) {
				System.out.println("locked ob1");
			}
		}
	});

	public static void main(String[] args) {
		//t1.start();
		//t2.start();
		new Thread(new ThreadA()).start();
		new Thread(new ThreadB()).start();
	}

	static class ThreadA implements Runnable{
		@Override
		public void run() {
			synchronized (ob2){
				System.out.println("Locked ob1");
				try{
					Thread.sleep(500);
				}
				catch (Exception e){}
				synchronized (ob1){
					System.out.println("waiting for ob2");
				}
			}
		}
	}
	static class ThreadB implements Runnable{
		@Override
		public void run() {
			synchronized (ob2){
				System.out.println("Locked ob2");
				synchronized (ob1){
					System.out.println("waiting for ob1");
				}
			}
		}
	}
}
