package com.corejava.interviews.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class WaitNotifyDemo {
	public static void main(String[] args){
		Data data = new Data();
		Callable<String> send = new Sender(data);
		Callable<String> recieve = new Reciever(data);
		FutureTask futureSend = new FutureTask(send);
		FutureTask futureRec = new FutureTask(recieve);
		Thread sending = new Thread(futureSend);
		Thread recieving = new Thread(futureRec);
		sending.start();
		recieving.start();
	}
	
}

class Data {
	private boolean isRec = false;
	private String message ;
	public synchronized void send(String message) throws InterruptedException {
//		System.out.println("Send start now");
		while (isRec) {
//			System.out.println("Send wait now > > > >");
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