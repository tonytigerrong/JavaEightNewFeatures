package com.corejava.interviews.threads;

public class VolatileDemo {
/**
 * Volatile is a keyword for visibility sychronization
 * 1. variable in thread1 changing is not guaranted effected to thread2
      since, the changing might still in thread1's cache (L1 and L2 cache), not pass to L3 cache which shared with thread2
   2. Volatile can fix this, 
   3. Volatile use for one thread write(change), multiple thread read.  
 * @param args
 */
	 	private 
	 		//volatile 
	 		static int number;
	    private 
	    	//volatile 
	    	static boolean ready;
	 
	    private static class Reader extends Thread {
	 
	        @Override
	        public void run() {
	            while (!ready) {
	            	/**
	            	 * Thread.yield:
	            	 * 		the current thread is willing to relinguish its current use of processor 
	            	 * 		but it'd like to be scheduled asap.
	            	 * yield vs wait/sleep/join
	            	 * 		yield: can't set mini time to re-life, others can
	            	 * 		
	            	 */
	                Thread.yield();
	            }
	            System.out.println(number);
	        }
	    }
	 
	    public static void main(String[] args) {
	        for(int i=0 ; i<10000 ; i++){
	        	new Reader().start();
	        }
	        number = 42;
	        ready = true;
	    }

}


