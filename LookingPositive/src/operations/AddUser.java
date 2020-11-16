package operations;

import java.util.Scanner;

public class AddUser {
	
	private boolean hasError = false;
	
	public void add() {
		hasError = false;
		handleFirstName();
		handleLastName();
		handleMobilePhone();
		handleResidenceRegion();
//		handleUserID();
		handleGender();
//		handleDateOfInfection();
		handleAge();
		handleIsSusceptible();
//		handleGetCloseContactWith();
	}
	private void handleFirstName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Όνομα: ");
		String firstName = sc.next();
				
	}
	private void handleLastName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Επώνυμο: ");
		String lastName = sc.next();
	}
	private void handleMobilePhone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Κινητό Τηλέφωνο: ");
		String mobileNumber = sc.next();
	}
	private void handleResidenceRegion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Δήμος Κατοικίας: ");
		String residenceRegion = sc.next();
	}
/*	private void handleUserID() {
		Scanner sc = new Scanner(System.in);
		System.out.println(": ");
		String residenceRegion = sc.next();	
	}*/
	private void handleGender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Φύλο: ");
		String gender = sc.next();
	}
/*	private void handleDateOfInfection() {
		Scanner sc = new Scanner(System.in);
		System.out.println(": ");
		String residenceRegion = sc.next();
	}	*/
	private void handleAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ηλικία: ");
		String age = sc.next();
	}
	private void handleIsSusceptible() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ανήκετε σε ευπαθή ομάδα; (Ν/Ο)");
		String isSusceptible = sc.next();
	}
/*	private void handleGetCloseContactWith() {
	
	}*/

}
