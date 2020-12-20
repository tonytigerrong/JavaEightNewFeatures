package com.corejava.interviews.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class WaitNotifyDemo {
	public static void main(String[] args){
		/**
		 * if start one sending and one recieving thread, it will work well
		 * if start two sending and two recieving threads, will dead locked( jps, jstack)
		 * 		: this dead lock might cause by using single locker (Data Object)
		 * 			: solve this by replace 'boolean isRec' to locker ( see com.corejava.interviews.threads.locks demo )
		 * 
		 */
		Data data = new Data();
		Callable<String> send1 = new Sender(data);
		Callable<String> send2 = new Sender(data);
		Callable<String> recieve1 = new Reciever(data);
		Callable<String> recieve2 = new Reciever(data);
		FutureTask futureSend1 = new FutureTask(send1);
		FutureTask futureSend2 = new FutureTask(send2);
		FutureTask futureRec1 = new FutureTask(recieve1);
		FutureTask futureRec2 = new FutureTask(recieve2);
		Thread sending1 = new Thread(futureSend1);
		Thread sending2 = new Thread(futureSend2);
		Thread recieving1 = new Thread(futureRec1);
		Thread recieving2 = new Thread(futureRec2);
		sending1.start();
		sending2.start();
		recieving1.start();
		recieving2.start();
	}
	
}

/**
 * isRec: a switch,
 * 			if false: send message
 * 			if true : receive message
 * 
 * @author jianzhong.rong
 *
 */
class Data {
	private boolean isRec = false;
	private String message ;
	public synchronized void send(String message) throws InterruptedException {
		// isRec initial by false, so send message is 1st action, no wait
		while (isRec) {
			//if isRec is true, waiting for recieve finish
			wait();
			
		}
		isRec = true;
		this.message = message;
		System.out.println("Send ==============================>\""+this.message+"\" now");
		notify();
	}

	public synchronized String receive() throws InterruptedException {
//		System.out.println("Receive start now");
		while (!isRec) {
//			System.out.println("Receive wait now < < < <");
			wait();
			
		}
		isRec = false;
//		System.out.println("Receive end now");
		notify();
		return this.message;
	}
}

class Sender implements Callable<String> {
	private Data data;
	private String[] messages ={"message 1","message 2", "message 3", "end"};
	Sender(Data data) {
		this.data = data;
	}

	@Override
	public String call() throws Exception {

		System.out.println("Thread [" + Thread.currentThread().getName() + "] is started!");
		for (String msg : messages) {
			this.data.send(msg);
			Thread.sleep(1000);
		}
		return Thread.currentThread().getName() + " is Done!";
	}
}

class Reciever implements Callable<String> {
	private Data data;
	Reciever(Data data){
		this.data = data;
	}
	@Override
	public String call() throws Exception {

		System.out.println("Thread [" + Thread.currentThread().getName() + "] is started!");
		String msg=null;

		for(msg=this.data.receive() ; !"end".equals(msg) ; msg=this.data.receive()){
				System.out.println("Get message<==============================\""+msg+"\"");
				Thread.sleep(4000);
		}
		return Thread.currentThread().getName() + " is Done!";
	}
}