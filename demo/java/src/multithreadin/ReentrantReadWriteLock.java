package multithreadin;

import java.util.concurrent.locks.Lock;

public class ReentrantReadWriteLock {
	private int counter;
	private final java.util.concurrent.locks.ReentrantReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
	private final Lock readLock = rwLock.readLock();
	private final Lock writeLock = rwLock.writeLock();

	public void incrementCounter(){
		writeLock.lock();
		try{
			counter = counter + 1;
		}
		finally {
			writeLock.unlock();
		}
	}

	public int getCounter(){
		readLock.lock();
		try{
			return counter;
		}
		finally {
			readLock.unlock();
		}
	}

	void test(){
		Thread t1 = new Thread(() -> {}); // newborn state
		t1.start(); // runnable state, if the resource is available it will go to running state
		// from running state, if the requested resource is not available, then it will go to blocked state



	}
}
