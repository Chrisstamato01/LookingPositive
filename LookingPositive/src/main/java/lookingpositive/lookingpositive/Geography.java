/**
 * Looking Positive Geography.
 */
package lookingpositive.lookingpositive;

import java.util.ArrayList;

/**
 * This class stores and organizes all the facilities according to their
 * municipality.
 */
public class Geography {
  /**
   * Facility type.
   */
  private String type; // Π.Χ. ΝΟΣΟΚΟΜΕΙΟ, ΦΑΡΜΑΚΕΙΟ, ΕΣΤΙΑΡΟΡΙΟ ΚΤΛ.
  /**
   * Facility name.
   */
  private String name;
  /**
   * Facility Municipality.
   */
  private String municipality;
  /**
   * Table for the facilities.
   */
  private static ArrayList<Geography> facilities = new ArrayList<Geography>();
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
   * Constructor for the class Geography.
   *
   * @param t   is the type of the facility
   * @param n   is the name
   * @param mun is the municipality
   */
  public Geography(final String t, final String n, final String mun) {
    type = t;
    name = n;
    municipality = mun;
    facilities.add(this);
  }

  /**
   * Default constructor Geography.
   */
  public Geography() {

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
   * @return the whole facilities arraylist.
   */
  public static ArrayList<Geography> getFacilities() {
    return facilities;
  }

  /**
   *
   * @param i line to be returned
   * @return the whole line
   */
  public static Geography getFacilitiesLine(final int i) {
    return facilities.get(i);
  }

  /**
   *
   * @return size of arraylist facilities
   */
  public static int getFacilitiesSize() {
    return facilities.size();  }

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
   * Fills the arraylist with the facilities.
   */
  public static void fillTables() {
    //Geography a = new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β");
    new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β");
    new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "3Β");
    new Geography("Σούπερ Μάρκετ", "Carrefour", "3Β");
    new Geography("Φαρμακείο", "Αντωνόπουλος", "3Β");
    new Geography("Φαρμακείο", "Γιαννακίδης", "3Β");
    new Geography("Νοσοκομείο", "Ασκληπείο", "3Β");
    new Geography("Νοσοκομείο", "S.P. Clinic", "3Β");
    new Geography("Εστιατόριο", "Τα Βλάχικα", "3Β");
    new Geography("Εστιατόριο", "Μαγειρευτά", "3Β");
    new Geography("Εστιατόριο", "Pizzeria Pomodori", "3Β");
    new Geography("Πάρκο", "Πλατεία Βούλας", "3Β");
    new Geography("Πάρκο", "Αθ. Διάκου", "3Β");
    new Geography("Γυμναστήριο", "Vari Sports Club", "3Β");
    new Geography("Κομμωτήριο", "Barber Shop", "3Β");
    new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "Άλιμος");
    new Geography("Σούπερ Μάρκετ", "Σκλαβενιτης", "Άλιμος");
    new Geography("Φαρμακείο", "Ζαχαριάδης", "Άλιμος");
    new Geography("Φαρμακείο", "Κολοβός", "Άλιμος");
    new Geography("Νοσοκομείο", "BioMed", "Άλιμος");
    new Geography("Νοσοκομείο", "Health", "Άλιμος");
    new Geography("Εστιατόριο", "Σουβλάκια", "Άλιμος");
    new Geography("Εστιατόριο", "Cuisine205", "Άλιμος");
    new Geography("Πάρκο", "Πάρκο Αλίμου", "Άλιμος");
    new Geography("Γυμναστήριο", "True Fitness", "Άλιμος");
    new Geography("Κομμωτήριο", "Salon Coiffure", "Άλιμος");
    new Geography("Σούπερ Μάρκετ", "Σκλαβενίτης", "Γλυφάδα");
    new Geography("Σούπερ Μάρκετ", "SuperFoodsMarket", "Γλυφάδα");
    new Geography("Φαρμακείο", "Βασιλακάκης", "Γλυφάδα");
    new Geography("Νοσοκομείο", "Medical 23", "Γλυφάδα");
    new Geography("Φαρμακείο", "Γεωργούλης", "Γλυφάδα");
    new Geography("Εστατόριο", "Mexican de Glyfada", "Γλυφάδα");
    new Geography("Εστατόριο", "Sushi Esperidon", "Γλυφάδα");
    new Geography("Πάρκο", "Πλατεία Εσπερίδων", "Γλυφάδα");
    new Geography("Πάρκο", "Μαυρολέωντος", "Γλυφάδα");
    new Geography("Γυμναστήριο", "L.F.F. GYM", "Γλυφάδα");
    new Geography("Κομμωτήριο", "Pretty Hair", "Γλυφάδα");
  }
}
