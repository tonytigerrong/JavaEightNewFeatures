package com.corejava.interviews.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class InteruptDemo {
	
	public static void main(String[] args){
		MyFuns myFuns = new MyFuns();
		Callable<String> testThread = new MyTestThread(myFuns);
		FutureTask future = new FutureTask(testThread);
		Thread t1 = new Thread(future);
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * Thread.interrupt() :
		 * 		stop waiting or sleeping status of Thread, in the mean time throw InterrupteException
		 * 
		 *  if thread is waiting or sleeping and being interrupted,
		 *   will throw interruptexception and stop waiting or sleeping status
		 */
		t1.interrupt(); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myFuns.setIsBlock(false);
	}
}

class MyFuns{
	private boolean isBlock = true;
	public synchronized void setIsBlock(boolean isBlock){
		this.isBlock = isBlock;
		System.out.println("isBlock is set to '"+isBlock+"'");
		notify();
	}
	public synchronized void method1() {
		System.out.println("start method1");
		while(isBlock){
			System.out.println("block");
			try {
				wait(); // if be interrupt, will throw interruptedexception here 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("block passed");
		}
		notify();
		System.out.println("end method1");
	}
}

class MyTestThread implements Callable<String>{
	private MyFuns myFuns;
	MyTestThread(MyFuns myFuns){
		this.myFuns = myFuns;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		this.myFuns.method1();
		return "done";
	}
	
}