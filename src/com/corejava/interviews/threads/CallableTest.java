package com.corejava.interviews.threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		FutureTask[] futures = new FutureTask[3];
		for(int i=0 ; i<3 ; i++){
			Callable<String> myCall = new MyCallable();
			futures[i] = new FutureTask(myCall);
			Thread t = new Thread(futures[i]);
			t.start();
		}
		for(int i=0 ; i<3 ; i++){
			System.out.println(futures[i].get().toString());
		}
	}
	

}
class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		Thread.sleep(4000);
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
		return Thread.currentThread().getName()+" is done!";
	}
	
}

