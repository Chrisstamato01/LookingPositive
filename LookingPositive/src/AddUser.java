import java.util.Scanner;

public class AddUser {
	static int id=1;
	
	private boolean hasError = false;
	
	public void add() {
		Profiles profile = new Profiles();
		profile.modelCase(handleFirstName(), handleLastName(), handleMobilePhone(), 
				handleResidenceRegion(),handleUserID(), handleGender(),
				handleDateOfInfection(), handleAge(), handleIsSusceptible(),handleGetCloseContactWith());
		hasError = false;
	}
	private String handleFirstName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Όνομα: ");
		String firstName = sc.next();
		return firstName;
	}
	private String handleLastName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Επώνυμο: ");
		String lastName = sc.next();
		return lastName;
	}
	private String handleMobilePhone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Κινητό Τηλέφωνο: ");
		String mobileNumber = sc.next();
		return mobileNumber;
	}
	private String handleResidenceRegion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Δήμος Κατοικίας: ");
		String residenceRegion = sc.next();
		return residenceRegion;
	}
	private int handleUserID() {
		return id++;	
	}
	private String handleGender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Φύλο: ");
		String gender = sc.next();
		return gender;
	}
	private String handleDateOfInfection() {
		Scanner sc = new Scanner(System.in);    // να την φτιαξουμε με if (αν εχει κοβιντ ή οχι)
		System.out.println("Έχετε μολυνθεί ;(Ν/Ο)");
		String isInfected = sc.next();
		if (isInfected == "Ν") {
			System.out.println("Ημερομήνια μολύνσεως: "); 
			String dateOfInfection = sc.next();
			return dateOfInfection;
		}else {
			return null;
		}
	}
	private int handleAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ηλικία: ");
		int age = sc.nextInt();
		return age;
	}
	private Boolean handleIsSusceptible() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ανήκετε σε ευπαθή ομάδα; (Ν/Ο)");
		String Susceptible = sc.next();
		boolean isSuspectible;
		if (Susceptible == "Ν") {
			isSuspectible = true;
		}else {
			isSuspectible = false;
		}
		return isSuspectible;
	}
	private String[] handleGetCloseContactWith() {
		Scanner sc = new Scanner(System.in);
		String []toReturn = new String[20];
		System.out.println("Έχετε έρθει σε επαφή με άλλα ατομα ; (Ν/Ο)");
		String 	closeContactWith = sc.next();
		int i=0;
		
		if (closeContactWith == "Ν") {
			System.out.println("Με ποιον ;");
			System.out.println("Οταν τελειωσετε εισαγεται Τέλος");
			closeContactWith = sc.next();
			while (closeContactWith != "Τέλος") {
				toReturn[i++] = closeContactWith;
				closeContactWith = sc.next();
			}
			return toReturn;
		}else {
			return null;
		}

	}

}
