package LookingPositive.LookingPositive;

import java.util.Scanner;
public class Health {
	/**
	 * @param userID current userID
	 * @exception InputMismatchException
	 */
	public static void chooseOperation(int userID) {
		System.out.println(" Αν θέλετε να ενημερώσετε την κατάσταση υγεία σας, πιέστε 1 ");
		System.out.println(" Αν είστε θετικός στο Κορωνοϊό, πιέστε 2 ");
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		while (answer != 1 || answer != 2) {
			try {
				answer = sc.nextInt();

			} catch (Exception ex) {
				sc.next();
				System.out.println("Μη έγκυρη τιμή");
			}

			if (answer != 1 || answer != 2) {
				System.out.println("Εισάγετε επιλογή [1-2]");
			}
		}
		if (answer == 2) {
			Tracking.track(userID);
		} else {
			areYouOk();
		}
	}
	/**
	 * this method records symptoms
	 *@exception InputMismatchException
	 */
	public static void areYouOk() {
		System.out.println(" Νιώθετε καλά σήμερα ;(ΝΑΙ/ΟΧΙ) ");
		Scanner sc = new Scanner(System.in);
		String answer = null;
		boolean flag = true;
		while (flag == true) {
			try {
				answer = sc.next();
				flag = false;
			} catch (Exception e) {
				flag = true;
				System.out.println("Εισάγετε (ΝΑΙ/ΟΧΙ) ");
			}
		}
		if (answer.equalsIgnoreCase("ΟΧΙ")) {
			flag = false;
			int countsymptoma = 0;
			while (flag == false) {
				System.out.println("Άν έχετε πυρετό πατήστε 1");
				System.out.println("Άν έχετε βήχα πατήστε 2");
				System.out.println("Άν αισθάνεστε κόπωση πατήστε 3");
				System.out.println("Άν έχετε απώλεια γεύσης πατήστε 4");
				System.out.println("Άν έχετε απώλεια όσφρισης πατήστε 5");
				System.out.println("Άν έχετε λαιμόπονο πατήστε 6");
				System.out.println("Άν έχετε πονοκέφαλο πατήστε 7");
				System.out.println("Άν έχετε δύσποια πατήστε 8");
				System.out.println("Άν δεν επιθυμείτε να προσθέσετε κάποιο σύμπτωμα πατήστε 0");
				int choice = -1;
				while (choice < 0 || choice > 8) {
					try {
						choice = sc.nextInt();

					} catch (Exception ex) {
						sc.next();
						System.out.println("Μη έγκυρη τιμή");
					}

					if (choice < 0 || choice > 8) {
						System.out.println("Εισάγετε επιλογή [0-8]");
					}

				}
				switch (choice) {
				case 0:
					flag = true;
					break;
				case 1:
					countsymptoma = countsymptoma + 2; // Σε κάποια συμπτώματα προστίθονται δύο γιατι θεωρείται οτι
														// έχουν μεγαλύτερη βαρύτητα
					break;
				case 2:
					countsymptoma = countsymptoma + 2;
					break;
				case 3:
					countsymptoma = countsymptoma + 1;
					break;
				case 4:
					countsymptoma = countsymptoma + 2;
					break;
				case 5:
					countsymptoma = countsymptoma + 2;
					break;
				case 6:
					countsymptoma = countsymptoma + 1;
					break;
				case 7:
					countsymptoma = countsymptoma + 1;
					break;
				case 8:
					countsymptoma = countsymptoma + 1;
					break;
				}
			}
			if (countsymptoma == 0) {
				System.out.println("Δεν υπάρχει λόγος ανησυχίας");
			} else if (countsymptoma < 3) {
				System.out.println(
						"Παρακαλώ επικοινωνίστε με τον γιατρό σας και μέινετε προληπτικά σπιτι και να είστε σε επιφυλακή");
			} else {
				System.out.println("Παρακαλώ επικοινωνίστε το συντομότερο με το γιατρό σας, πιθανως να εχετε Covid-19");
			}
		} else {
			System.out.println("Τέλεια! Να έχετε μια καλή μέρα και να προσέχετε!");
		}
	}
}