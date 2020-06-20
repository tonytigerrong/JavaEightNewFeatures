package com.corejava.interviews.threads;

public class RunnableJoinTest {

	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new MyRunnable(),"t1");
		Thread t2 = new Thread(new MyRunnable(),"t2");
		Thread t3 = new Thread(new MyRunnable(),"t3");
		t1.start();
		t1.join(1000);
		t2.start();
		t2.join(2000);
		t3.start();
		t3.join();
		System.out.println("exit!");
	}
}
class MyRunnable implements Runnable{
	@Override
	public void run(){
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	}
}
