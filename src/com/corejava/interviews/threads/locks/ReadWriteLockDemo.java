package com.corejava.interviews.threads.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		/**
		 * ReentrantReadWriteLock has a pair of lock: (1) write lock (2) read lock
		 * if write lock lock, read lock is lock aslo, we can't get readlock until write lock unlocked.
		 * if write lock is not locked, readlock can be locked, and write lock can be locked as well
		 */
		ReadWriteLock lock = new ReentrantReadWriteLock();

		DataDemo2 data = new DataDemo2(lock);
		MyWriter writer = new MyWriter(data);
		MyReader reader = new MyReader(data);
		
		
		
		es.submit(writer); // lock.writelock is lock here for 5 sec

		es.submit(reader); // lock.readlock can't be get until lock.writelock unlocked

		es.submit(reader);


		
		es.shutdown();
	}

}

class DataDemo2 {
	private ReadWriteLock lock;
	private Map<String, String> map = new HashMap<>();

	DataDemo2(ReadWriteLock lock) {
		this.lock = lock;
	}

	void insert() {
		lock.writeLock().lock();
		try {
			Thread.sleep(5000);
			map.put("key1", "value1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

	void get() {
		lock.readLock().lock();
		try {
//			Thread.sleep(0);
			System.out.println(map.get("key1"));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}

}

class MyWriter implements Runnable {
	private DataDemo2 demo;

	MyWriter(DataDemo2 demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		demo.insert();
	}
}

class MyReader implements Runnable {
	private DataDemo2 demo;

	MyReader(DataDemo2 demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.demo.get();
	}
}
