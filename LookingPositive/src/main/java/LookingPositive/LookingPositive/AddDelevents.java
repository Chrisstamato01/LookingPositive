package LookingPositive.LookingPositive;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class AddDelevents {
	//πρεπει να σβηστει η dayofcreation ειναι για το τεστινγκ
	//the event is created and registered in the calendar
	public static void addevent(int userId , int dateofcreation) {
		 Eventsaver.addtocalendar(new Event(dateInput(), addgeography(), profileListInput()), userId , dateofcreation);
		 
	}
	//the user chooses the day of the event (today/future)
	public static LocalDate dateInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Εισάγεται ημερομηνία για την εκδήλωση σας (d/m/yyyy).");
		boolean flag = false;
		LocalDate date = null;
		while (flag == false) {
			flag = true;
			String sDate = sc.nextLine();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
			try {
				date = LocalDate.parse(sDate, dateFormat);
			} catch (DateTimeParseException e) {
				System.err.println("AN ERROR OCCURED " + e);
				flag = false;
			} catch (Exception e) {
				System.err.println("AN ERROR OCCURED");
				flag = false;
			}
			LocalDate now = LocalDate.now();
			if (now.until(date, ChronoUnit.DAYS) < 0) {
				flag = false;
				System.out.println("Η ημερομηνία που εισάγατε ειναι παρελθονιτκή.");
			}
		}
		sc.close();
		return date;
	}
	//the user gives the a list of names he/she will see at the event
	public static ArrayList<Profile> profileListInput() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Profile> contactedpeople = new ArrayList<Profile>();
		System.out.println("Θα συναναστραφείτε και με αλλα άτομα κατά την έξοδο σας; (ΝΑΙ/ΟΧΙ).");
		boolean flag = false;
		String answer = "Ν";
		while (flag == false) {
			answer = sc.nextLine();
			if (!(answer.equals("ΝΑΙ") || answer.equals("ΟΧΙ"))) {
				System.out.println("Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
			} else {
				flag = true;
			}
		}
		if (answer.equals("ΝΑΙ")) {
			System.out.println("Εισάγεται τα άτομα με τα οποία θα συναντηθείτε.");
			String inneranswer = "ΝΑΙ";
			while (inneranswer.equals("ΝΑΙ")) {
				System.out.println("Εισάγεται το όνομα του ατόμου.");
				String firstname = sc.nextLine();
				System.out.println("Εισάγεται το επίθετο του ατόμου.");
				String lastname = sc.nextLine();
				contactedpeople.add(addcontactedpeople(firstname, lastname));
				System.out.println("Θα συναντηθείτε και με άλλα άτομα ; (ΝΑΙ/ΟΧΙ) ");
				flag = false;
				while (flag == false) {
					inneranswer = sc.nextLine();
					if (!(inneranswer.equals("ΝΑΙ") || inneranswer.equals("ΟΧΙ"))) {
						System.out.println("Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
					} else {
						flag = true;
					}
				}

			}
		}
		sc.close();
		return contactedpeople;
	}
	//checks if the names exist as users otherwise creates the profiles 
	public static Profile addcontactedpeople(String firstname, String lastname) {
		Iterator<Profile> it = Profile.profilesSave.iterator();
		Profile person;
		Profile person2 = null;
		while (it.hasNext()) {
			person = it.next();
			if (person.getFirstName().equals(firstname) && person.getLastName().equals(lastname)) {
				person2 = person;
			} else {
				person = new Profile(firstname, lastname);
				person2 = person;
			}
		}
		return person2;
	}

	public static void viewevents(int userID) {
		for (int i = 0; i < Eventsaver.future.eventlist.get(userID).size(); i++) {
			System.out.println(i + 1 + " " + Eventsaver.future.eventlist.get(userID).get(i));
		}
	}
	//the user deletes a future event from his calendar 
	public static String delevent(int userID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Οι προγραμματισμένες σας εκδηλώσεις είναι οι εξής : ");
		viewevents(userID);
		System.out.println("Επιλέξτε τον αριθμό της εκδήλωσης που θέλετε να διαγράψετε.");
		boolean foundexception = true;
		boolean numbernotfound = false;
		int n = -1;
		while (foundexception == true) {
			while (numbernotfound == false) {
				try {
					n = sc.nextInt();
					if (n > Eventsaver.future.eventlist.get(userID).size() - 1 || n < 1) {
						System.out.println("Παρακαλώ εισάγεται έγκειρο αριθμό.");
					} else {
						numbernotfound = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("Παρακαλώ εισάγεται αριθμό.");
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		Eventsaver.future.eventlist.get(userID).remove(n - 1);
		sc.close();
		return "Η εκδήλωση " + n + " διαγράφηκε επιτυχώς. ";
	}
	//the user chooses where his/her event will take place
	public static Geography addgeography() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Ποιόν δήμο θα θέλατε να επισκευτείτε(δήμος Βάρης/Βούλας/Βουλιαγμένης(1) - Άλιμος(2) - Γλυφάδα(3). ");
		boolean flag = true;
		int number = 0;
		while (flag) {
			number = sc.nextInt();
			switch (number) {
			case 1:
				for (int i = 0; i < Geography.facilities.length; i++) {
					if (Geography.facilities[i].getMunicipality() == "3Β") {
						System.out.println(i + " " + Geography.facilities[i]);
					}
				}
				flag = false;
				break;
			case 2:
				for (int i = 0; i < Geography.facilities.length; i++) {
					if (Geography.facilities[i].getMunicipality() == "Άλιμος") {
						System.out.println(i + " " + Geography.facilities[i]);
					}
				}
				flag = false;
				break;
			case 3:
				for (int i = 0; i < Geography.facilities.length; i++) {
					if (Geography.facilities[i].getMunicipality() == "Γλυφάδα") {
						System.out.println(i + " " + Geography.facilities[i]);
					}
				}
				flag = false;
				break;
			default:
				System.out.println("Εισάγεται έγκυρο αριθμό. ");
				break;
			}
		}
		System.out.println("Εισάγεται τον αριθμό του/της κατάστημος/υπηρεσίας που θα θέλατε να επισκευτειτε. ");
		flag = true;
		int choice = -1;
		while (flag) {
			try {
				choice = sc.nextInt();
				if (choice  >= Geography.facilities.length) {
					System.out.println("Παρακαλώ εισάγεται έγκειρο αριθμό.");
				} else {
					flag = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Παρακαλώ εισάγεται αριθμό.");
			} catch (Exception e) {
				System.err.println(e);
			}

		}

		return Geography.facilities[choice];
	}
}
