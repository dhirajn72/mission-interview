package multithreadin;

public class ProducerConsumerTest {
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer obj = new ProducerConsumer();
		ThreadGroup tg = new ThreadGroup("admin");
		Thread t1 = new Thread(tg, ()-> {
			for(int i = 1; i < 10; i++){
				obj.produce(i);
			}
		});
		Thread t2 = new Thread(tg, () -> {
			for(int i = 1; i < 10; i++){
				obj.consume();
			}
		});
		t1.start();
		t2.start();
	}
}

class ProducerConsumer{
	int val;
	boolean flag = false;

	public synchronized void produce(int val){
		if(flag){
			try{
				wait(500);
			}
			catch(Exception e){}
		}
		this.val = val;
		System.out.println("Produced :" + this.val);

		try{
			Thread.sleep(500);
		}catch(Exception e ){}
		flag = true;
		notifyAll();
	}
	public synchronized void consume(){
		if(!flag){
			try{
				wait(500);
			}
			catch(Exception e ){ }
		}
		System.out.println("Consumed :"+ this.val);
		flag = false;
		notifyAll();
	}
}