public class ProdCons {
	public static void main(String[] args) {
		ProducerConsumer_1 producerConsumer = new ProducerConsumer_1();
		ThreadA t1 = new ThreadA(producerConsumer);
		ThreadB t2 = new ThreadB(producerConsumer);
	}

	static class ThreadA implements Runnable{
		ProducerConsumer_1 producerConsumer;
		ThreadA(ProducerConsumer_1 producerConsumer){
			this.producerConsumer = producerConsumer;
			Thread t1 = new Thread(this);
			t1.start();
		}
		@Override
		public void run() {
			for (int i = 0; i < 10; i++)
				producerConsumer.produce(i);

		}
	}
	static class ThreadB implements Runnable{
		ProducerConsumer_1 producerConsumer;
		ThreadB(ProducerConsumer_1 producerConsumer){
			this.producerConsumer = producerConsumer;
			Thread t2 = new Thread(this);
			t2.start();
		}
		@Override
		public void run() {
			for (int i = 0; i < 10; i++)
				producerConsumer.consume();

		}
	}
}

class ProducerConsumer_1 {
	int val;
	boolean flag = false;

	public synchronized void produce(int val) {
		if (flag) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.val = val;
		System.out.println("Published :" + this.val);
		flag = true;
		notify();
	}

	public synchronized void consume() {
		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
			}
		}

		System.out.println("Consumed :" + this.val--);
		try {
			Thread.sleep(500);
		}
		catch (Exception e){}
		flag = false;
		notify();
	}
}
