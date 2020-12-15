package PROG2;
import java.util.Scanner;

public class Health {
	public static void areyouok() {
			System.out.println(" Νιώθετε καλά σήμερα ;(ΝΑΙ/ΟΧΙ) ");
			Scanner sc = new Scanner(System.in);
			String answer= sc.next();
			if (answer.equalsIgnoreCase("ΟΧΙ") ) {
				String[] symptoms1 = {"Πυρετός","Πυρετος","πυρετος","Βήχας","βηχας","Απώλεια γεύσης","Απώλεια όσφρισης","Κόπωση","Πόνο στο σώμα"};
				//System.out.println("1.Πυρετος\n2.Βήχας\n3.Κώποση\n4.Απώλεια γεύσης\n5.Απώλεια όσφρισης\n6.Κόποση\n7.Πόνο στο σώμα\n8.Λαιμόπονο\n9.Πονοκέφαλο\n10.Δύσποια\n'Αμα νιώθετε κάτι από αυτα καλό θα είναι να συμβουλευτείτε τον γιατρό σας.Αποτελούν συχνα συμπώματα Covid-19");
				boolean flag=false;
				int countsymptoma=0;
				while(flag == false) {
				System.out.println("Πείτε μου κάποιο σύμπτωμα ή ενόχληση που έχετε: ");
				String apadisi = sc.next();
				for (String symptom : symptoms1) {
					if (symptom.equalsIgnoreCase(apadisi)) {
						countsymptoma++;
					}
				}
				System.out.println("Υπάρχει κάποιο άλλο σύμπτωμα; (ΝΑΙ/ΟΧΙ)");
				apadisi=sc.next();
				if (apadisi.equalsIgnoreCase("ΟΧΙ")) {
					flag=true;
				}
				}
				if (countsymptoma == 0) {
					System.out.println("Δεν υπάρχει λόγος ανησυχίας");
				}
				else if (countsymptoma < 3) {
					System.out.println("Παρακαλώ επικοινωνίστε με τον γιατρό σας και μέινετε προληπτικά σπιτι");
				}
				else {
					System.out.println("Παρακαλώ επικοινωνίστε το συντομότερο με το γιατρό σας, πιθανως να εχετε Covid-19");
				}
				}
			}
}


