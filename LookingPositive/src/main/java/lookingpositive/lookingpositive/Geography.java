/**
 * Looking Positive Geography.
 */
package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.exc.MismatchedInputException;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
   * Length of table Cases.
   */
  private static final int CASES_LENGTH = 3;
  /**
   * Table for the cases.
   */
  private static int[] cases3B = new int[CASES_LENGTH];
  /**
   * Table for the cases of Glyfada.
   */
  private static int[] casesGlyfada = new int[CASES_LENGTH];
  /**
   * Table for the cases of Alimos.
   */
  private static int[] casesAlimos = new int[CASES_LENGTH];
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
   * Counts today's cases in 3B.
   */
  private static int todaysCases3B = 0;
  /**
   * Counts today's cases in Alimos.
   */
  private static int todaysCasesAlimos = 0;
  /**
   * Counts today's cases in Glyfada.
   */
  private static int todaysCasesGlyfada = 0;

  /**
   * Constructor for the class Geography.
   *
   * @param facType   is the type of the facility
   * @param facName   is the name
   * @param facMunicipality is the municipality
   */
  public Geography(final String facType, final String facName,
                   final String facMunicipality) {
    type = facType;
    name = facName;
    municipality = facMunicipality;
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
  public final String getType() {
    return type;
  }

  /**
   * Return name method.
   *
   * @return name
   */
  public final String getName() {
    return name;
  }

  /**
   * @return municipality
   */
  public final String getMunicipality() {
    return municipality;
  }

  /**
   * @return the whole facilities table.
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
   * @return size of facilities
   */
  public static int getFacilitiesSize() {
    return facilities.size();
  }

  /**
   * Adds new case to the counter.
   * @param id is the user's id
   */
  public static void newCase(final int id) {
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (Profile.profilesLine(i).getUserID() == id) {
        Profile profile = Profile.profilesLine(i);
        if (profile.getResidenceRegion().equals("3Β")) {
          todaysCases3B++;
        } else if (profile.getResidenceRegion().equals("Γλυφάδα")) {
          todaysCasesGlyfada++;
        } else {
          todaysCasesAlimos++;
        }
      }
    }
  }

  /**
   * Updates the table Cases.
   * @param oldDate id the last login day
   */
  public static void updateCases(final LocalDate oldDate) {
    long differenceOfDays = oldDate.until(LocalDate.now(), ChronoUnit.DAYS);
    for (int counter = 0; counter < differenceOfDays; counter++) {
      cases3B[2] = cases3B[1];
      cases3B[1] = cases3B[0];
      cases3B[0] = todaysCases3B;
      todaysCases3B = 0;
      casesGlyfada[2] = casesGlyfada[1];
      casesGlyfada[1] = casesGlyfada[0];
      casesGlyfada[0] = todaysCasesGlyfada;
      todaysCasesGlyfada = 0;
      casesAlimos[2] = casesAlimos[1];
      casesAlimos[1] = casesAlimos[0];
      casesAlimos[0] = todaysCasesAlimos;
      todaysCasesAlimos = 0;
    }
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public final String toString() {
    return this.type + " - Όνομα: " + this.name + " - Δήμος: "
        + this.municipality;
  }

  /**
   * Finds the color of a municipality according to the number of Covid cases.
   *
   * @param mun is the municipality
   * @return String
   */
  public static String munColor(final String mun) {
    //updateCases();
    double current = 0; // the cases of the last three days
    double quotient;
    String color;
    if (mun.endsWith("3Β")) {
      current = cases3B[0] + cases3B[1] + cases3B[2];
      quotient = current / POPULATION_3B;
    } else if (mun.endsWith("Alimos")) {
      current = casesAlimos[0] + casesAlimos[1] + casesAlimos[2];
      quotient = current / POPULATION_ALIMOS;
    } else {
      current = casesGlyfada[0] + casesGlyfada[1] + casesGlyfada[2];
      quotient = current / POPULATION_GLYFADA;
    }

    final double redCodeLimit = 0.001;
    final double orangeCodeLimit = 0.0001;

    if (quotient > redCodeLimit) {
      color = "Κόκκινο";
    } else if (quotient > orangeCodeLimit) {
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
    new Geography("Κομμωτήριο", "Natasha's", "Γλυφάδα");
  }

  /**
   * Saves facilities to JSON file.
   */
  public static void facilitiesSaver() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      File facilitiesfile = new File(
          "src\\main\\resourses\\"
          + "facilities.json").getAbsoluteFile();
      objectmapper.writeValue(facilitiesfile, facilities);
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }

  /**
   * Retrieves facilities from JSON file.
   */
  public static void facilitiesRetriever() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      File facilitiesfile = new File(
          "src\\main\\resourses"
          + "\\facilities.json").getAbsoluteFile();
      facilities = objectmapper.readValue(
          facilitiesfile, new TypeReference<ArrayList<Geography>>() { });

    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
}
