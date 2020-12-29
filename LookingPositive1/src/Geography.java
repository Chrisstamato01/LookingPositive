public class Geography {
	private String type; //Π.Χ. ΝΟΣΟΚΟΜΕΙΟ, ΦΑΡΜΑΚΕΙΟ, ΕΣΤΙΑΡΟΡΙΟ ΚΤΛ.
	private String name; 
	private String municipality;
	private static int count = 0;
	public static Geography facilities[] = new Geography[100];
	private static float population3B = 49399;
	private static float populationAlimos = 49720; 
	private static float populationGlyfada = 87305;

	public Geography(String type, String name, String municipality) {
		facilities[count] = this;
		this.type = type;
		this.name = name;
		this.municipality = municipality;
		count++;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMunicipality() {
		return municipality;
	}
	
	@Override
	public String toString() {
		return this.type + " Όνομα: " + this.name + " Ανήκει στον Δήμο: " + this.municipality;
	}
	
// ΕΥΡΕΣΗ ΧΡΩΜΑΤΟΣ ΕΠΙΚΥΝΔΙΝΟΤΗΤΑΣ ΚΑΘΕ ΠΕΡΙΟΧΗΣ
	public static String MunColor(String mun) { 
		float current = 0;
		float q;
		String color;
// ΟΠΟΥ CASES1,2,3 ΤΑ ΚΡΟΥΣΜΑΤΑ ΤΩΝ ΤΕΛΕΥΤΑΙΩΝ 3 ΗΜΕΡΩΝ (TO BE FIXED)	
		if(mun.endsWith("3Β")) {
//			current = cases1 + cases2 + cases3;
			q = current/population3B;
		} else if(mun.endsWith("Alimos")) {
//			current = cases1 + cases2 + cases3;
			q = current/populationAlimos;
		} else {
//			current = cases1 + cases2 + cases3;
			q = current/populationGlyfada ;
		}
		
		if (q > 0.001) {
			color = "Κόκκινο";
		} else if (q > 0.0001) {
			color = "Πορτοκαλί";
		} else {
			color = "Πράσινο";
		}
		
		return "Ο Δήμος " + mun + ", με βάση τα κρούσματα των τελευταίων ημερών, έχει χρώμα επικινδυνότητας " + color ;
	}       

// ΜΕΘΟΔΟΣ ΔΗΜΙΟΥΡΓΙΑΣ ΑΝΤΙΚΕΙΜΕΝΩΝ ΚΑΙ ΓΕΜΙΣΜΑ ΠΙΝΑΚΩΝ
	public static void fillTables() {
		facilities[0] = new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β"); // TΟ B ΣΤΟ "3Β" ΕΙΝΑΙ ΕΛΛΗΝΙΚΟ
		facilities[1] = new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "3Β");
		facilities[2] = new Geography("Σούπερ Μάρκετ", "Carrefour", "3Β");
		facilities[3] = new Geography("Φαρμακείο", "Αντωνόπουλος", "3Β");
		facilities[4] = new Geography("Φαρμακείο", "Γιαννακίδης", "3Β");
		facilities[5] = new Geography("Νοσοκομείο", "Ασκληπείο", "3Β");
		facilities[6] = new Geography("Νοσοκομείο", "S.P. Clinic", "3Β");
		facilities[7] = new Geography("Εστιατόριο", "Τα Βλάχικα", "3Β");
		facilities[8] = new Geography("Εστιατόριο", "Μαγειρευτά", "3Β");
		facilities[9] = new Geography("Εστιατόριο", "Pizzeria Pomodori", "3Β");
		facilities[10] = new Geography("Πάρκο", "Πλατεία Βούλας", "3Β");
		facilities[11] = new Geography("Πάρκο", "Αθ. Διάκου", "3Β");
		facilities[12] = new Geography("Γυμναστήριο", "Vari Sports Club", "3Β");
		facilities[13] = new Geography("Κομμωτήριο", "Barber Shop", "3Β");
		facilities[14] = new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "Άλιμος");
		facilities[15] = new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "Άλιμος");
		facilities[16] = new Geography("Φαρμακείο", "Ζαχαριάδης", "Άλιμος");
		facilities[17] = new Geography("Φαρμακείο", "Κολοβός", "Άλιμος");
		facilities[18] = new Geography("Νοσοκομείο", "BioMed", "Άλιμος");
		facilities[19] = new Geography("Νοσοκομείο", "Health", "Άλιμος");
		facilities[20] = new Geography("Εστιατόριο", "Σουβλάκια", "Άλιμος");
		facilities[21] = new Geography("Εστιατόριο", "Cuisine205", "Άλιμος");
		facilities[22] = new Geography("Πάρκο", "Πάρκο Αλίμου", "Άλιμος");
		facilities[23] = new Geography("Γυμναστήριο", "True Fitness", "Άλιμος");
		facilities[24] = new Geography("Κομμωτήριο", "Salon Coiffure", "Άλιμος");
		facilities[25] = new Geography("Σούπερ Μάρκετ","Σκλαβενίτης","Γλυφάδα");
		facilities[26] = new Geography("Σούπερ Μάρκετ", "SuperFoodsMarket", "Γλυφάδα");
		facilities[27] = new Geography("Φαρμακείο", "Βασιλακάκης", "Γλυφάδα");
		facilities[28] = new Geography("Νοσοκομείο", "Medical 23", "Γλυφάδα");
		facilities[29] = new Geography("Φαρμακείο", "Γεωργούλης", "Γλυφάδα");
		facilities[30] = new Geography("Εστατόριο", "Mexican de Glyfada", "Γλυφάδα");
		facilities[31] = new Geography("Εστατόριο", "Sushi Esperidon", "Γλυφάδα");
		facilities[32] = new Geography("Πάρκο", "Πλατεία Εσπερίδων", "Γλυφάδα");
		facilities[33] = new Geography("Πάρκο", "Μαυρολέωντος", "Γλυφάδα");
		facilities[34] = new Geography("Γυμναστήριο", "L.F.F. GYM", "Γλυφάδα");
		facilities[35] = new Geography("Κομμωτήριο", "Pretty Hair", "Γλυφάδα");
	
	}
}
