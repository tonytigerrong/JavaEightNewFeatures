package com.corejava.interviews.threads.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class RentrantLockDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		DataDemo data = new DataDemo(lock);
		MyRunnable run = new MyRunnable(data);
		Thread t = new Thread(run);
		t.start();
		System.out.println("Locked: " + lock.isLocked());
	    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
	    boolean locked = lock.tryLock();
	    System.out.println("Lock acquired: " + locked);
//		IntStream.range(0,1000).forEach(i->es.submit(this::increment));
	}

}

class DataDemo{
	private ReentrantLock lock;
	int count = 0;
	DataDemo(ReentrantLock lock){
		this.lock = lock;
	}
	void increment(){
		lock.lock();
		try{
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			lock.unlock();
		}
		
	}
}

class MyRunnable implements Runnable{
	private DataDemo data;
	MyRunnable(DataDemo data){
		this.data = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		data.increment();
		
	}
	
}

