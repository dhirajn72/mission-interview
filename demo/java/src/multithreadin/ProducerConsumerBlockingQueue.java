package multithreadin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
	public static void main(String[] args){
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		ProducerConsumer producerConsumer = new ProducerConsumer(queue);
		Thread produce = new Thread(()-> {
					for(int i = 0; i < 10; i++){
						try {
							producerConsumer.produce(i);
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

		Thread consumer = new Thread(()->{
					for(int i = 0; i < 10; i++){
						try {
							producerConsumer.consume();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
		});
		produce.start();
		consumer.start();

	}

	static class ProducerConsumer{
		private BlockingQueue<Integer> queue;
		ProducerConsumer(BlockingQueue<Integer> queue){
			this.queue = queue;
		}
		void produce(int val) throws InterruptedException {
			queue.put(val);
			System.out.println("Produced :" + val);
		}
		void consume() throws InterruptedException {
			System.out.println("Consumed : " + queue.take());
		}
	}
}
