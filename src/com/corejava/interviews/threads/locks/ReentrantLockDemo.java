package com.corejava.interviews.threads.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		/**
		 * lock using path: lock ->DateDemo(data) -> MyRunnable(run) 
		 */
		DataDemo data = new DataDemo(lock);
		MyRunnable run = new MyRunnable(data);
		es.submit(run);	 // thread is runing and lock is using now for 1 sec
		System.out.println("Locked: " + lock.isLocked()); // should be true
	    System.out.println("Held by me: " + lock.isHeldByCurrentThread()); // so should be false
	    boolean locked = lock.tryLock(); // withinc 1 sec, can't get lock 
	    System.out.println("Lock acquired: " + locked);
	    es.shutdown();
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

