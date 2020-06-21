package com.corejava.interviews.threads;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartThreadAtSpecificTime {

	public static void main(String[] args) {
//		System.out.println(test());

		/**
		 * need start task at 2:30
		 * Timer
		 */
		Instant in1 = Instant.now();
		
		LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(2); // 2 seconds from now
		Instant in2 = localDateTime.toInstant(OffsetDateTime.now().getOffset());
		long waitTime = getMilliSecDiff(in1, in2);
		
//		Duration duration = Duration.between(LocalDateTime.ofInstant(in1, ZoneId.systemDefault()), localDateTime);
//		long sec = duration.getSeconds();
			
		Timer timer = new Timer();
		timer.schedule(new MyTask(timer), waitTime);
		
		/**
		 * ExecutorService scheduled task
		 */
		Callable<Integer> callableThread = ()->{
			try{
				System.out.println("Start CallabeThread[" + Thread.currentThread().getName() + "]");
				Thread.sleep(5000);
				System.out.println("End   CallabeThread[" + Thread.currentThread().getName() + "]");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			return 0;
		};
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.schedule(callableThread, waitTime, TimeUnit.MILLISECONDS);
		ses.shutdown();

	}
	public static long getMilliSecDiff(Instant in1, Instant in2){
		return in2.toEpochMilli() - in1.toEpochMilli();
//		return in2.getNano() - in1.getNano();
	}
	public static long test(){
		Instant time1 = ZonedDateTime.now(ZoneId.of("Canada/Atlantic")).toInstant();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant time2 = Instant.now();
		return getMilliSecDiff(time1,time2);
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