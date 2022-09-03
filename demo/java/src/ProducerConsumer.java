public class ProducerConsumer {
	public static void main(String[] args) {
		Stack1 stack1 = new Stack1();
		ThreadA a = new ThreadA(stack1, "Thread-A");
		ThreadB b = new ThreadB(stack1, "Thread-B");

	}
}

class ThreadA extends Thread {
	Stack1 stack;

	public ThreadA(Stack1 stack1, String name) {
		this.stack = stack1;
		Thread thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stack.push(i );
		}
	}
}

class ThreadB extends Thread {
	Stack1 stack;

	public ThreadB(Stack1 stack1, String name) {

		this.stack = stack1;
		Thread thread = new Thread(this, name);
		thread.start();

	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
	}
}

class Stack1 {
	int x;
	boolean flag = false;

	public synchronized void push(int x) {

		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		this.x = x;
		System.out.println("x is pushed:" + x);
		flag = true;
		notify();
	}

	public synchronized int pop() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("x is popped:" + x);

		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();
		return x;
	}
}
