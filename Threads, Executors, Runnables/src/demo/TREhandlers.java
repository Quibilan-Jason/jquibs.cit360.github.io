package demo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TREhandlers {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//create thread 
		Thread getMonths = new threadTest();
		
		//calls exclamations from Runnable
		Runnable shouts = new exclamations();
		
		//prints out 5 for priority
		System.out.println(new Thread(shouts).getPriority());
		System.out.println(getMonths.getPriority());
			
		getMonths.start();
		//You will notice it prints slowly because the "sleep(2000)" item we put in there delays printing by 2 seconds.
		
		//The following will begin shouting at us while we are working on the months...
		//You need to tell the code it is a new thread so it can use it.
		new Thread(shouts).start(); //Note I will still have to create a new Thread with shouts when I want to use it a second time...
		
		//This code will "suspend" both threads from running in the background while they work.
		//This is because technically both threads are still running the loops in their threads.
		
		try {
			getMonths.suspend();
			System.out.println("Brah! getMonths is on break...");
			getMonths.resume();
			
		} catch (Exception e) {
			System.out.println("Brah, what da...");
		}
		
		//changing thread priorities...
		getMonths.setPriority(10); //Highest priority.
		new Thread(shouts).setPriority(1); //Lowest priority.
		
		System.out.println(new Thread(shouts).getPriority());
		System.out.println(getMonths.getPriority());
		
		/*
		 * Executors
		 * The following works with runnables to create a thread pool that will save CPU power.		
		 */
		
		Executor letsRunAnExecutor = Executors.newCachedThreadPool(); 
		for (int counterFor = 0; counterFor < 2; counterFor++) {
			Runnable shoutsTwo = new exclamations(); //creating new thread to run from exclamations.
			Thread getMonthsTwo = new threadTest();	//creating new thread to run from threadTest
			letsRunAnExecutor.execute(shoutsTwo);
			letsRunAnExecutor.execute(getMonthsTwo);
		} try {
			Thread.sleep(5000);
			System.out.println("BRAH! I AM NOW AWAKENED...");
			Runnable shoutsTwo = new exclamations(); 
			Thread getMonthsTwo = new threadTest();	
			letsRunAnExecutor.execute(shoutsTwo);
			letsRunAnExecutor.execute(getMonthsTwo);
		} catch (InterruptedException e) {
			System.out.println("Brah! you messed dis up...");
			e.printStackTrace(); 
		}
	}
}
