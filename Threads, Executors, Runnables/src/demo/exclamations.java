package demo;


public class exclamations implements Runnable {
	
	//The following code will produce Exclamations throughout the other code.
	public void run() {
		//The following code details what this thread will "exclaim" during the code...
		for (int answer = 42; answer > -1;) {
			if (answer > 21) {
				System.out.println("The Answer is " + answer + "!");
				answer = answer - 3;
			}else if (answer == 21) { 
				System.out.println("The Answer is " + answer + "!");
				System.out.println("Hold up Brah, trying to give fun facts about each month!");
				answer = answer - 3;
			} else {
				break;				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			} 
		}
	}	
}

