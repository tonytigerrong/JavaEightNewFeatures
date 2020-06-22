package com.corejava.interviews.threads.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		StampedLock lock = new StampedLock();
		Data2 data = new Data2(lock);
		Writer writer = new Writer(data);
		Reader reader = new Reader(data);
		es.submit(writer);
		es.submit(reader);
		es.submit(reader);
		es.shutdown();
	}

}

class Data2 {
	private Map<String, String> map = new HashMap<>();
	private StampedLock lock;

	Data2(StampedLock lock) {
		this.lock = lock;
	}

	void insert() {
		long stamp = lock.writeLock();
		System.out.println("Get writelock stamp:"+stamp);
		try {
			Thread.sleep(5000);
			map.put("key1", "value1");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlockWrite(stamp);
		}
	}

	void get() {
//		long stamp = lock.readLock(); // same with ReadWriteLock
		/*
		 * tryOptimisticRead might get invalid (0) lock(stamp),but return immediataly ReadWriteLock don't
		 * tryOptimisticRead has to using lock.validate(stamp) to validate if the lock is true
		 */
		long stamp = lock.tryOptimisticRead(); 
		/*
		 * the while loop is same effect as lock.readLock()
		 * get the real lock 
		 */
		while(!lock.validate(stamp) ){
			stamp = lock.tryOptimisticRead();
		}
		System.out.println("Get readlock stamp:"+stamp);
		try {
			System.out.println("Read: "+map.get("key1"));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlockRead(stamp);
		}
	}
}

class Writer implements Runnable {
	private Data2 data;

	Writer(Data2 data) {
		this.data = data;
	}

	@Override
	public void run() {

		data.insert();
	}
}

class Reader implements Runnable {
	private Data2 data;

	Reader(Data2 data) {
		this.data = data;
	}

	@Override
	public void run() {

		data.get();
	}
}