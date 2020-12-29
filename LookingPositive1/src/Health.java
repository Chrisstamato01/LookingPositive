import java.util.Scanner;
public class Health {
		public static void areyouok() {
			System.out.println(" Νιώθετε καλά σήμερα ;(ΝΑΙ/ΟΧΙ) ");
			Scanner sc = new Scanner(System.in);
			String answer= sc.next();
			if (answer.equalsIgnoreCase("ΟΧΙ") ) {
				boolean flag=false;
				int countsymptoma=0;
				while(flag == false) {
					System.out.println( "Άν έχετε πυρετό πατήστε 1");
					System.out.println( "Άν έχετε βήχα πατήστε 2");
					System.out.println( "Άν αισθάνεστε κόπωση πατήστε 3");
					System.out.println( "Άν έχετε απώλεια γεύσης πατήστε 4");
					System.out.println( "Άν έχετε απώλεια όσφρισης πατήστε 5");
					System.out.println( "Άν έχετε λαιμόπονο πατήστε 6");
					System.out.println( "Άν έχετε πονοκέφαλο πατήστε 7");
					System.out.println( "Άν έχετε δύσποια πατήστε 8");
					System.out.println( "Άν δεν επιθυμείτε να προσθέσετε κάποιο σύμπτωμα πατήστε 0");
					int apadisi = sc.nextInt();
					switch(apadisi) {
					case 0:
						flag = true ;
						break;
					case 1:
						countsymptoma = countsymptoma + 2 ; // Σε κάποια συμπτώματα προστίθονται δύο γιατι θεωθείται οτι έχουν μεγαλύτερη βαρύτητα
						break;
					case 2:
						countsymptoma = countsymptoma + 2 ;
						break;
					case 3:
						countsymptoma = countsymptoma + 1 ;
						break;
					case 4:
						countsymptoma = countsymptoma + 2 ;
						break;
					case 5:
						countsymptoma = countsymptoma + 2 ;
						break;
					case 6:
						countsymptoma = countsymptoma + 1 ;
						break;
					case 7:
						countsymptoma = countsymptoma + 1 ;
						break;
					case 8:
						countsymptoma = countsymptoma + 1 ;
						break;
					}
				}
				if (countsymptoma == 0) {
					System.out.println("Δεν υπάρχει λόγος ανησυχίας");
				}
				else if (countsymptoma < 3) {
					System.out.println("Παρακαλώ επικοινωνίστε με τον γιατρό σας και μέινετε προληπτικά σπιτι και να είστε σε επιφυλακή");
				}
				else {
					System.out.println("Παρακαλώ επικοινωνίστε το συντομότερο με το γιατρό σας, πιθανως να εχετε Covid-19");
				}
				}
			else {
				System.out.println("Τέλεια! Να έχετε μια καλή μέρα και να προσέχετε!");
			}
		}          
}
