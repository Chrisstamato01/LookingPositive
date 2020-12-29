package LookingPositive.LookingPositive;
import java.util.Scanner;

public class Operations {
	public static void main(String[]args) {
		
		SignInUp.login();
		
		
		
	}
	public static void run(int userID) {
		
		boolean execution = true;
		
		while (execution) {
			
			menu();
			
			int menuChoice = menuChoice();
			
			switch(menuChoice) {
			
				case 1:
					
					break;
				
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					
					break;
					
				case 5:
					
					break;
					
				case 6:
					
					break;	
					
				case 7:
					execution = false;
					System.out.println("Τερματισμός Προγράμματος...");
					break;
					
			}
		
		}
	
	}

	private static int menuChoice() {
		
	    Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		while(choice < 1 || choice > 7) {
			
			try {
			
			choice = sc.nextInt();
			
			}catch (Exception ex) {
				 sc.next();
	             System.out.println("Μη έγκυρη τιμή");
			}

			if(choice < 1 || choice > 7) {
				System.out.println("Εισάγετε επιλογή [1-7]");
			}
		
		}
		
		return choice;
	}

	private static void menu() {
		System.out.println(
				"------------Μενού Επιλογών------------ \n" +
				"1. Γεγονότα \n" +
				"2. Υγεία \n" +
				"3. Γεωγραφική περιγραφή \n" +
				"4. Πληροφορίες για τον ιό \n" +
				"5. Ειδοποιήσεις \n" +
				"6. Ρυθμίσεις \n" +
				"7. Έξοδος \n" +
				"Εισάγετε επιλογή [1-7]");
		
	}
	
}

