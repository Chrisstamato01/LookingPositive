/**
 * This class belongs to the package lookingpositive.lookingpositive.
 */
package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class stores and organizes all the facilities according to their
 * municipality.
 */
public class Geography {
  /**
   * Facility type.
   */
  private String type;
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
  private static final int CASES_LENGTH = 4;
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
   * Constructor for the class Geography.
   *
   * @param facType         is the type of the facility
   * @param facName         is the name
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
   * Returns the municipality.
   *
   * @return municipality
   */
  public final String getMunicipality() {
    return municipality;
  }

  /**
   * Stores the facilities.
   *
   * @return the whole facilities table.
   */
  public static ArrayList<Geography> getFacilities() {
    return facilities;
  }

  /**
   * Returns a single facility from the array list.
   *
   * @param i line to be returned
   * @return the whole line
   */
  public static Geography getFacilitiesLine(final int i) {
    return facilities.get(i);
  }

  /**
   * Returns the size of the facilities array list.
   *
   * @return size of facilities
   */
  public static int getFacilitiesSize() {
    return facilities.size();
  }

  /**
   * Shows the color of each municipality.
   *
   * @param oldDate is the last date
   */
  public static void showMunColor(final LocalDate oldDate) {
    updateCases(oldDate);
    System.out.println("Today's epidemiological profile is: ");
    System.out.println(munColor("3B"));
    System.out.println(munColor("Glyfada"));
    System.out.println(munColor("Alimos"));
  }

  /**
   * Adds new case to the counter.
   *
   * @param id is the user's id
   */
  public static void newCase(final int id) {
    final int three = 3;
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (Profile.profilesLine(i).getUserID() == id) {
        Profile profile = Profile.profilesLine(i);
        if (profile.getResidenceRegion().equals("3B")) {
          cases3B[three]++;
        } else if (profile.getResidenceRegion().equals("Glyfada")) {
          casesGlyfada[three]++;
        } else {
          casesAlimos[three]++;
        }
      }
    }
  }

  /**
   * Updates the table Cases.
   *
   * @param oldDate id the last login day
   */
  public static void updateCases(final LocalDate oldDate) {
    final int three = 3;
    long differenceOfDays = oldDate.until(LocalDate.now(), ChronoUnit.DAYS);
    for (int counter = 0; counter < differenceOfDays; counter++) {
      cases3B[2] = cases3B[1];
      cases3B[1] = cases3B[0];
      cases3B[0] = cases3B[three];
      cases3B[three] = 0;
      casesGlyfada[2] = casesGlyfada[1];
      casesGlyfada[1] = casesGlyfada[0];
      casesGlyfada[0] = casesGlyfada[three];
      casesGlyfada[three] = 0;
      casesAlimos[2] = casesAlimos[1];
      casesAlimos[1] = casesAlimos[0];
      casesAlimos[0] = casesAlimos[three];
      casesAlimos[three] = 0;
    }
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public final String toString() {
    return this.type + " - Name: " + this.name + " - Municipality: "
        + this.municipality;
  }

  /**
   * Finds the color of a municipality according to the number of Covid cases.
   *
   * @param mun is the municipality
   * @return String
   */
  public static String munColor(final String mun) {
    int current = 0; // the cases of the last three days
    double quotient;
    String color;
    if (mun.equals("3B")) {
      current = cases3B[0] + cases3B[1] + cases3B[2];
      quotient = (double) current / POPULATION_3B;
    } else if (mun.equals("Alimos")) {
      current = casesAlimos[0] + casesAlimos[1] + casesAlimos[2];
      quotient = (double) current / POPULATION_ALIMOS;
    } else {
      current = casesGlyfada[0] + casesGlyfada[1] + casesGlyfada[2];
      quotient = (double) current / POPULATION_GLYFADA;
    }

    final double redCodeLimit = 0.001;
    final double orangeCodeLimit = 0.0001;

    if (quotient > redCodeLimit) {
      color = "Red";
    } else if (quotient > orangeCodeLimit) {
      color = "Orange";
    } else {
      color = "Green";
    }

    return "The municpality's: " + mun + " epidemiological profile is: "
        + color;
  }

  /**
   * Saves facilities to JSON file.
   */
  public static void facilitiesSaver() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      File facilitiesfile = new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "facilities.json");
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
      facilities = objectmapper.readValue(
          FileManager.streamToString("facilities.json"),
          new TypeReference<ArrayList<Geography>>() {
          });

    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }

  /**
   * Saves the cases to the JSON file.
   */
  public static void casesSaver() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      File casesfile = new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "cases3b.json");
      objectmapper.writeValue(casesfile, cases3B);
      File casesfile2 = new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "casesglyfada.json");
      objectmapper.writeValue(casesfile2, casesGlyfada);
      File casesfile3 = new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "casesalimos.json");
      objectmapper.writeValue(casesfile3, casesAlimos);

    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }

  /**
   * Reads facilities from the local JSON file.
   */
  public static void casesReader() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      cases3B = objectmapper.readValue(new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "cases3b.json"),
          new TypeReference<int[]>() {
          });
      casesGlyfada = objectmapper.readValue(new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "casesglyfada.json"),
          new TypeReference<int[]>() {
          });
      casesAlimos = objectmapper.readValue(new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + "casesalimos.json"),
          new TypeReference<int[]>() {
          });

    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }

  /**
   * Retrieves facilities from the JSON file.
   */
  public static void casesRetriever() {
    ObjectMapper objectmapper = new ObjectMapper();

    try {
      cases3B = objectmapper.readValue(
          FileManager.streamToString("cases3b.json"),
          new TypeReference<int[]>() {
          });
      casesGlyfada = objectmapper.readValue(
          FileManager.streamToString("casesglyfada.json"),
          new TypeReference<int[]>() {
          });
      casesAlimos = objectmapper.readValue(
          FileManager.streamToString("casesalimos.json"),
          new TypeReference<int[]>() {
          });

    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
}
