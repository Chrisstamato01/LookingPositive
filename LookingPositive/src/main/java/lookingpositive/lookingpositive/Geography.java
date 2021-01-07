package lookingpositive.lookingpositive;

/**
 * This class stores and organizes all the facilities according to their
 * municipality.
 */
public class Geography {
  /**
   * Facility type.
   */
  private final String type; // Π.Χ. ΝΟΣΟΚΟΜΕΙΟ, ΦΑΡΜΑΚΕΙΟ, ΕΣΤΙΑΡΟΡΙΟ ΚΤΛ.
  /**
   * Facility name.
   */
  private final String name;
  /**
   * Facility Municipality.
   */
  private final String municipality;
  /**
   * Counter for the table.
   */
  private static int count = 0;
  /**
   *
   */
  private static final int FAC_LENGTH = 100;
  /**
   * Table for the facilities.
   */
  private static Geography[] facilities = new Geography[FAC_LENGTH];
  /**
   * Population of municipality 3B.
   */
  private static final int POPULATION_3B = 49399;
  /**
   * Population of municipality Alimos.
   */
  private static final int POPULATION_ALIMOS = 49720;
  /**
   * Population of municipality Glyfada.
   */
  private static final int POPULATION_GLYFADA = 87305;

  /**
   * Constructor for the class Geography. Creates objects and stores them in the
   * table.
   *
   * @param t   is the type of the facility
   * @param n   is the name
   * @param mun is the municipality
   */
  public Geography(final String t, final String n, final String mun) {
    facilities[count] = this;
    this.type = t;
    this.name = n;
    this.municipality = mun;
    count++;
  }

  /**
   * Return type method.
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * Return name method.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @return municipality
   */
  public String getMunicipality() {
    return municipality;
  }

  /**
   *
   * @param cell is the cell called
   * @return facilities
   */
  public static Geography getFacilitiesCells(final int cell) {
    return facilities[cell];
  }

//  @Override

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return this.type + " Όνομα: " + this.name + " Ανήκει στον Δήμο: "
        + this.municipality;
  }

  /**
   * Finds the color of a municipality according to the number of covid cases.
   *
   * @param mun is the municipality
   * @return String
   */
  public static String munColor(final String mun) {
    float current = 0;
    float q;
    String color;
// ΟΠΟΥ CASES1,2,3 ΤΑ ΚΡΟΥΣΜΑΤΑ ΤΩΝ ΤΕΛΕΥΤΑΙΩΝ 3 ΗΜΕΡΩΝ (TO BE FIXED)
    if (mun.endsWith("3Β")) {
//current = cases1 + cases2 + cases3;
      q = current / POPULATION_3B;
    } else if (mun.endsWith("Alimos")) {
//current = cases1 + cases2 + cases3;
      q = current / POPULATION_ALIMOS;
    } else {
//current = cases1 + cases2 + cases3;
      q = current / POPULATION_GLYFADA;
    }

    final double redCodeLimit = 0.001;
    final double orangeCodeLimit = 0.0001;

    if (q > redCodeLimit) {
      color = "Κόκκινο";
    } else if (q > orangeCodeLimit) {
      color = "Πορτοκαλί";
    } else {
      color = "Πράσινο";
    }

    return "Ο Δήμος " + mun
        + ", με βάση τα κρούσματα των τελευταίων ημερών, έχει χρώμα "
        + "επικινδυνότητας " + color;
  }

  /**
   * Fills the table with the facilities.
   */
  public static void fillTables() {
    facilities[count] = new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "3Β");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "Carrefour", "3Β");
    facilities[count] = new Geography("Φαρμακείο", "Αντωνόπουλος", "3Β");
    facilities[count] = new Geography("Φαρμακείο", "Γιαννακίδης", "3Β");
    facilities[count] = new Geography("Νοσοκομείο", "Ασκληπείο", "3Β");
    facilities[count] = new Geography("Νοσοκομείο", "S.P. Clinic", "3Β");
    facilities[count] = new Geography("Εστιατόριο", "Τα Βλάχικα", "3Β");
    facilities[count] = new Geography("Εστιατόριο", "Μαγειρευτά", "3Β");
    facilities[count] = new Geography("Εστιατόριο", "Pizzeria Pomodori", "3Β");
    facilities[count] = new Geography("Πάρκο", "Πλατεία Βούλας", "3Β");
    facilities[count] = new Geography("Πάρκο", "Αθ. Διάκου", "3Β");
    facilities[count] = new Geography("Γυμναστήριο", "Vari Sports Club", "3Β");
    facilities[count] = new Geography("Κομμωτήριο", "Barber Shop", "3Β");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος",
        "Άλιμος");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "Άλιμος");
    facilities[count] = new Geography("Φαρμακείο", "Ζαχαριάδης", "Άλιμος");
    facilities[count] = new Geography("Φαρμακείο", "Κολοβός", "Άλιμος");
    facilities[count] = new Geography("Νοσοκομείο", "BioMed", "Άλιμος");
    facilities[count] = new Geography("Νοσοκομείο", "Health", "Άλιμος");
    facilities[count] = new Geography("Εστιατόριο", "Σουβλάκια", "Άλιμος");
    facilities[count] = new Geography("Εστιατόριο", "Cuisine205", "Άλιμος");
    facilities[count] = new Geography("Πάρκο", "Πάρκο Αλίμου", "Άλιμος");
    facilities[count] = new Geography("Γυμναστήριο", "True Fitness", "Άλιμος");
    facilities[count] = new Geography("Κομμωτήριο", "Salon Coiffure", "Άλιμος");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "Σκλαβενίτης",
        "Γλυφάδα");
    facilities[count] = new Geography("Σούπερ Μάρκετ", "SuperFoodsMarket",
        "Γλυφάδα");
    facilities[count] = new Geography("Φαρμακείο", "Βασιλακάκης", "Γλυφάδα");
    facilities[count] = new Geography("Νοσοκομείο", "Medical 23", "Γλυφάδα");
    facilities[count] = new Geography("Φαρμακείο", "Γεωργούλης", "Γλυφάδα");
    facilities[count] = new Geography("Εστατόριο", "Mexican de Glyfada",
        "Γλυφάδα");
    facilities[count] = new Geography("Εστατόριο", "Sushi Esperidon",
        "Γλυφάδα");
    facilities[count] = new Geography("Πάρκο", "Πλατεία Εσπερίδων", "Γλυφάδα");
    facilities[count] = new Geography("Πάρκο", "Μαυρολέωντος", "Γλυφάδα");
    facilities[count] = new Geography("Γυμναστήριο", "L.F.F. GYM", "Γλυφάδα");
    facilities[count] = new Geography("Κομμωτήριο", "Pretty Hair", "Γλυφάδα");

  }
}

