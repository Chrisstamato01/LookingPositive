package lookingpositive.lookingpositive;

//import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
/**
 * Main class for Chris.
 */
public final class ChrisMain {
  /**
   * This is the private default constructor.
   */
  private ChrisMain() {

  }
  /**
   * Executable main class.
   * @param args you know
   */
  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);
//Profile.profilesRetriever();
//AddUser.add();

/*    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      System.out.println(Profile.profilesSaveLine(i));
    }*/

    Geography.fillTables();
    Geography.facilitiesSaver();

    for (int i = 0; i < Geography.getFacilitiesSize(); i++) {
      System.out.println(Geography.getFacilitiesLine(i));
    }

    //System.out.println(Profile.profilesSaveSize());

    System.out.println("Δωσε id");
    int id = sc.nextInt();
    test(id);

  }

  /**
   * Find region from id.
   * @param id is users id
   * @return smth
   */
  public static String test(final int id) {
    String a = " ";
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (id == Profile.profilesLine(i).getUserID()) {
        a = Profile.profilesLine(i).getResidenceRegion();
      } else {
        a = "No match";
      }
    }
    System.out.println(a);
    return a;
  }
}
