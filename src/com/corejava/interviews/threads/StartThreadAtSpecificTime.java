package com.corejava.interviews.threads;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class StartThreadAtSpecificTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * need start task at 2:30
		 */
		Instant in = Instant.now();
		LocalDateTime localDateTime = LocalDateTime.of(2020, 06,20,14,42,0);
		Duration duration = Duration.between(LocalDateTime.ofInstant(in, ZoneId.systemDefault()), localDateTime);
		long sec = duration.getSeconds();
		System.out.println(sec);
		
//		sec = 2;
		Timer timer = new Timer();
		timer.schedule(new MyTask(timer), sec*1000);
		
	}

}
class MyTask extends TimerTask{
	private Timer timer;
	MyTask(Timer timer){
		this.timer = timer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Callable<String> callable = new MyThread();
		FutureTask future = new FutureTask(callable);
		Thread t1 = new Thread(future,"t1");
		t1.start();
		this.timer.cancel();
	}
	
}
class MyThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task started:::"+Thread.currentThread().getName());
		Thread.sleep(4000);
		System.out.println("Task ended:::"+Thread.currentThread().getName());
		return Thread.currentThread().getName()+" is done!";
	}
	
}