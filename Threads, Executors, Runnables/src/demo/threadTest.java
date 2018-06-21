package demo;

public class threadTest extends Thread {	
	
	public void run() {
		// This thread will run a for loop that will count the months out. 
		for (int counter = 1; counter < 13; counter++) {
			String monthOfYear;
			switch (counter) {
			
			case 1: monthOfYear = "January";
			System.out.println(monthOfYear);
			System.out.println("January is named after the Roman god Janus, who was always shown as having two heads.");
			System.out.println("He looked back to the last year and forward to the new one.");
			System.out.println("Birthstone: Garnet");
			System.out.println("Flower: Carnation");
			break;
			
			case 2: monthOfYear = "February";
			System.out.println(monthOfYear);
			System.out.println("The Saxon term for the month, Sol-monath, means \"cake month\". This is because they offered cakes to the gods during this month.");
			System.out.println("Birthstone: Amethyst");
			System.out.println("Flower: Primrose");
			break;
			
			case 3: monthOfYear = "March";
			System.out.println("The word 'March' comes from the Roman 'Martius' and was named after Mars, the god of war.");			
			System.out.println("Birthstone: Aquamarine");
			System.out.println("Flower: Dafodil");
			break;
			
			case 4: monthOfYear = "April";
			System.out.println(monthOfYear);
			System.out.println("The real origin of its name has been lost.");
			System.out.println("The most common theory is that Aprilis is derived from the Latin verb Aperire, to open, as the opening, or blossoming, of trees and flowers.");
			System.out.println("Birthstone: Diamond");
			System.out.println("Flower: Daisy or Sweet Pea");
			break;
			
			case 5: monthOfYear = "May";
			System.out.println(monthOfYear);
			System.out.println("The month may have been named for the Greek goddess Maia, who was identified with the Roman goddess of fertility, Bona Dea.");			
			System.out.println("Birthstone: Emerald");
			System.out.println("Flower: lily of the valley and hawthorn");
			break;
			
			case 6: monthOfYear = "June";
			System.out.println(monthOfYear);
			System.out.println("The month of June is probably named after Juno, the wife of Jupiter, and queen of the gods.");
			System.out.println("Juno is always represented as a tall, beautiful woman, wearing a crown and bearing a sceptre in her hand, and often she is shown with a peacock at her side.");
			System.out.println("Birthstone: Moonstone or Pearl");
			System.out.println("Flower: Rose and Honeysuckle");
			break;
			
			case 7: monthOfYear = "July";
			System.out.println(monthOfYear);
			System.out.println("July was renamed for Julius Caesar");
			System.out.println("In prior years, it was called Quintilis. If you know your latin, that \"Quint\" thing is screaming \"# 5\".");
			System.out.println("Birthstone: Ruby");
			System.out.println("Flower: Larkspur and the Water Lily");
			break;
			
			case 8: monthOfYear = "August";
			System.out.println(monthOfYear);
			System.out.println("August was named in honor of Augustus Caesar.");
			System.out.println("It has 31 days because Augustus wanted as many days as Julius Caesar's month of July had, they took that extra day from February.");
			System.out.println("Birthstone: Peridot");
			System.out.println("Flower: Gladious and the Poppy");
			break;
			
			case 9: monthOfYear = "September";
			System.out.println(monthOfYear);
			System.out.println("September's name comes from septem, Latin for “seven.\"");
			System.out.println("More peopel are born in September than any other month!");
			System.out.println("Birthstone: Sapphire");
			System.out.println("Flower: Aster and the Morning Glory");
			break;
			
			case 10: monthOfYear = "October";			
			System.out.println(monthOfYear);
			System.out.println("October received its name from the Latin numeral octo meaning \"eight\", because in the original Roman calendar it was the eighth month.");
			System.out.println("Birthstone: Opal");
			System.out.println("Flower: Marigold and Cosmos");
			break;
			
			case 11: monthOfYear = "November";
			System.out.println(monthOfYear);
			System.out.println("The name 'November' is believed to derive from 'novem' which is the Latin for the number 'nine'.");
			System.out.println("People born around mid-November were conceived around Valentine's Day.");
			System.out.println("Birthstone: Topaz");
			System.out.println("Flower: Chrysanthemum");
			break;
			
			case 12: monthOfYear = "December";
			System.out.println(monthOfYear);
			System.out.println("The Latin name is derived from Decima, the middle Goddess of the Three Fates who personifies the present.");
			System.out.println("Birthstone: Turquoise");
			System.out.println("Flower: Narcissus and the Holly");
			break;
			
			}
			try { 
				Thread.sleep(2000); //this tells the thread to sleep so that it can gather information needed before running again.
			} catch(InterruptedException e) {
				
			}
		}
	}	
}
