package com.corejava.interviews.threads;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorServiceDemo demo = new ExecutorServiceDemo();
		demo.test1();
		demo.test2();
		demo.test3();
	}
	
	public void test3(){
		Callable<Integer> callableT1 = ()->{
			try{
				System.out.println("Start CallabeThread[" + Thread.currentThread().getName() + "]");
				Thread.sleep(5000);
				System.out.println("End   CallabeThread[" + Thread.currentThread().getName() + "]");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			return 0;
		};
		ExecutorService es = Executors.newFixedThreadPool(6);
		Future[] futures = new Future[6];
		for(int i=0 ; i<6 ; i++){
			futures[i] = es.submit(callableT1);
		}
		es.shutdown();
	}
	
	public void test2(){
		Runnable runnable1 = () -> {
			try{
				System.out.println("Start CallabeThread[" + Thread.currentThread().getName() + "]");
				Thread.sleep(5000);
				System.out.println("End   CallabeThread[" + Thread.currentThread().getName() + "]");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		};
		
		ExecutorService es = Executors.newFixedThreadPool(6);
		Future[] fus = new Future[6];
		for(int i=0 ; i<6 ; i++){
			fus[i] = es.submit(runnable1);
		}
		
		es.shutdown();
	}
	public void test1(){
		ExecutorService es = Executors.newFixedThreadPool(4);
		Future[] fus = new Future[4];
		for (int i = 0; i < 4; i++) {
			Callable<Integer> call = new CallabeThread();
			RunnableThread run = new RunnableThread();
			fus[i] = es.submit(call);
			fus[i++] = es.submit(run);
		}
		for (Future fu : fus) {
//			try{
//				if (!fu.isDone()) {  // throw nullpoint exception when fus[i] = es.submit(runnable);
//					fu.cancel(false);  	
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//			}
		}
		es.shutdown();
	}
}

class CallabeThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("Start CallabeThread[" + Thread.currentThread().getName() + "]");
		Thread.sleep(5000);
		System.out.println("End   CallabeThread[" + Thread.currentThread().getName() + "]");
		return 0;
	}
}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Start RunnableThread[" + Thread.currentThread().getName() + "]");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End   RunnableThread[" + Thread.currentThread().getName() + "]");
	}
}
