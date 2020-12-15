import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;   
import java.util.Iterator;
public class AddDelevents {
	public static void addevent() {
		//Eventsaver.addevent(new Event(dateInput(), PLACE ,profileListInput()), userid, x);
	}

	public static LocalDate dateInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Εισάγεται ημερομηνία για την εκδήλωση σας (d/m/yyyy).");
		boolean flag = false;
		LocalDate date = null;
		while(flag==false) {
			flag=true;
			String sDate = sc.nextLine();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		try {
			 date = LocalDate.parse(sDate, dateFormat);}
		catch(DateTimeParseException e) {
			System.err.println("AN ERROR OCCURED " + e );
			flag=false;
		}
		catch(Exception e) {
			System.err.println("AN ERROR OCCURED");
			flag=false;}
		LocalDate now = LocalDate.now(); 
		if(now.until(date, ChronoUnit.DAYS)<0) {
			flag=false;
			System.out.println("Η ημερομηνία που εισάγατε ειναι παρελθονιτκή.");
			}
		}
		sc.close();
		return date;
	}
	
	
	
	
	public static ArrayList<Profile> profileListInput(){
		Scanner sc = new Scanner(System.in);
		ArrayList<Profile> contactedpeople = new ArrayList<>();
		System.out.println("Θα συναναστραφείτε και με αλλα άτομα κατά την έξοδο σας; (ΝΑΙ/ΟΧΙ).");
		boolean flag = false;
		String answer = "Ν";
		while(flag==false) {
			answer = sc.nextLine();
			if(!(answer.equals("ΝΑΙ") || answer.equals("ΟΧΙ"))) {
				System.out.println("Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
			}else {
				flag = true;
			}
		}
		if(answer.equals("ΝΑΙ")){
			System.out.println("Εισάγεται τα άτομα με τα οποία θα συναντηθείτε.");
			String inneranswer = "ΝΑΙ";
			while(inneranswer.equals("ΝΑΙ")) {
				System.out.println("Εισάγεται το όνομα του ατόμου.");
				String firstname = sc.nextLine();
				System.out.println("Εισάγεται το επίθετο του ατόμου.");
				String lastname = sc.nextLine();
				contactedpeople.add(addcontactedpeople(firstname,lastname));
				System.out.println("Θα συναντηθείτε και με άλλα άτομα ; (ΝΑΙ/ΟΧΙ) ");
				flag=false;
				while(flag==false) {
					inneranswer = sc.nextLine();
					if(!(inneranswer.equals("ΝΑΙ") || inneranswer.equals("ΟΧΙ"))) {
						System.out.println("Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
					}else {
						flag = true;
					}
				}
				
			}
		}
		sc.close();
		return contactedpeople;
	}
	
	public static Profile addcontactedpeople(String firstname,String lastname) {
		boolean found = false;
		Iterator<Profile> it = Profile.profilesSave.iterator();
		Profile person;
		while(it.hasNext()) {
			person = it.next();
			if(person.getFirstName().equals(firstname) && person.getLastName().equals(lastname)) {
				return person;
			}else {
				person = new Profile(firstname , lastname);
				return person;
			}
		}
	}
	
	public static void viewevents(int userID) {
		for(int i = 0; i < Eventsaver.future.eventlist.get(userID).size(); i++) {
			System.out.println(i+1 +" "+ Eventsaver.future.eventlist.get(userID).get(i));
		}
	}
	
	public static String delevent(int userID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Οι προγραμματισμένες σας εκδηλώσεις είναι οι εξής : ");
		viewevents(userID);
		System.out.println("Επιλέξτε τον αριθμό της εκδήλωσης που θέλετε να διαγράψετε.");
		boolean foundexception = true;
		boolean numbernotfound = false;
		int n = -1;
		while (foundexception == true) {
			while (numbernotfound==false) {
			try {
				n = sc.nextInt();
				if(n>Eventsaver.future.eventlist.get(userID).size()-1 || n < 1) {
					System.out.println("Παρακαλώ εισάγεται έγκειρο αριθμό.");
				}else {
					numbernotfound = true;
				}
			}catch(InputMismatchException e) {
				System.out.println("Παρακαλώ εισάγεται αριθμό.");
			}catch(Exception e ) {
				System.err.println(e);
			}
			}
		}
		Eventsaver.future.eventlist.get(userID).remove(n-1);
		sc.close();
		return "Η εκδήλωση " +n+ " διαγράφηκε επιτυχώς. "; 
	}
}

