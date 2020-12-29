package LookingPositive.LookingPositive;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddUser {
static int id = 0;
static int password = 1000;

	private static boolean hasError = false;

	public static void add() {
		Profile profile = new Profile(handleFirstName(), handleLastName(), handleMobilePhone(),
				handleResidenceRegion(),handleUserID(),/* handleGender(),*/
				/*handleDateOfInfection(),*/ handleAge(), handleIsSusceptible(), handlePassword(), handleEmail());

		hasError = false;
	}
	protected static String handleFirstName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Όνομα: ");
		String firstName = null;
		
		boolean flag = true;
		while (flag == true) {
		
		try {
		firstName = sc.next();
		flag = false;
		} catch (Exception e){
			flag = true;
			System.err.println("Εισάγετε έγκυρο όνομα"+ e);
		}
		}
		System.out.println(firstName);
		
		return firstName;
	}
	protected static String handleLastName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Επώνυμο: ");
		String lastName = "ka Tzortziia";

		boolean flag = false;
		while (flag == false) {
//			flag = false;
		try {
		lastName = sc.next();
		flag = true;
		} catch(Exception e) {
			
			System.err.println("Εισάγετε έγκυρο επώνυμο"+e);
		}
		}
		System.out.println(lastName);
		
		return lastName;
	}
	private static int handleMobilePhone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Κινητό Τηλέφωνο: ");
		
		int mobileNumber = 0;
		boolean flag = true;
		while (flag == true) {
			flag = false;
		try {
			mobileNumber = sc.nextInt();
		} catch (InputMismatchException e) {
			flag = true;
			System.out.println("Εισάγετε έγκυρο αριθμό τηλεφώνου");
		}
		sc.nextLine();
		}
		
		return mobileNumber;
	}
	private static String handleResidenceRegion() {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		String residenceRegion = null;

		boolean flag = true;
		
		boolean exceptionNotOccured = false;
		System.out.println("Δήμος Κατοικίας[Γλυφάδα(1), Άλιμος(2), Βάρη-Βούλα-Βουλιαγμένη(3)]: ");
		while(flag) {
			flag = false;
			exceptionNotOccured = false;
//			System.out.println("Δήμος Κατοικίας[Γλυφάδα(1), Άλιμος(2), Βάρη-Βούλα-Βουλιαγμένη(3)]: ");
			while(!exceptionNotOccured) {
			
			try {
			a = sc.nextInt();
			exceptionNotOccured = true;
			} catch (InputMismatchException e) {			
				System.out.println("Εισάγετε έγκυρο αριθμό(1,2,3)");
				sc.nextLine();
			} 
			
			}
			switch(a) {

			case 1:
				residenceRegion = "Γλυφάδα";
				break;
			
			case 2:
				residenceRegion = "'Αλιμος";
				break;
			
			case 3:
				residenceRegion = "Βάρη-Βούλα-Βουλιαγμένη";
				break;
			
			default:
				flag = true;
				System.out.println("Εισάγετε έγκυρο αριθμό(1,2,3)");
				break;

			}
			sc.nextLine();
		}
		
		
		return residenceRegion;
	}
	private static int handleUserID() {
		return id++;	
	}
/*	private static String handleGender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Φύλο: ");
		String gender = sc.next();
		return gender;
	}*/
/*	private static String handleDateOfInfection() {
		Scanner sc = new Scanner(System.in);    // να την φτιαξουμε με if (αν εχει κοβιντ ή οχι)
		System.out.println("Έχετε μολυνθεί; (Ν/Ο)");
		String isInfected = sc.next();
		if (isInfected == "Ν") {
			System.out.println("Ημερομήνια μολύνσεως: "); 
			String dateOfInfection = sc.next();
			return dateOfInfection;
		}else {
			return null;
		}
	}*/
	private static int handleAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ηλικία: ");
		int age = 0;
		boolean flag = true;
		while (flag == true) {
		flag = false;
		try {
		
		age = sc.nextInt();
		} catch (InputMismatchException e){
			flag = true;
			System.out.println("Εισάγετε σωστή ηλικία");
		} catch (Exception e) {
			flag = true;
			System.out.println("Εισάγετε έγκυρο αριθμό");
		}
		sc.nextLine();
		}
		return age;
		
	}
	private static Boolean handleIsSusceptible() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ανήκετε σε ευπαθή ομάδα; (Ν/Ο)");

		boolean w = true;
		String Susceptible = null;
	
		while (w) {
			w = false;
			Susceptible = sc.next();
			if (!(Susceptible.equals("N")|| Susceptible.equals("O"))) {
				System.out.println("Εισάγετε έγκυρο χαρακτήρα");
				w = true;
			}
		}
		
		boolean isSuspectible;
		if (Susceptible == "Ν") {
			isSuspectible = true;
		}else {
			isSuspectible = false;
		}
		return isSuspectible;
	}
	private static String handlePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Εισάγετε τον κωδικό σας");
		String password = sc.next();
		return password;
	}
	private static String handleEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Τα στοιχεία καταχωρήθηκαν επιτυχώς");
		return email;	
	}	
	
	
	


}
