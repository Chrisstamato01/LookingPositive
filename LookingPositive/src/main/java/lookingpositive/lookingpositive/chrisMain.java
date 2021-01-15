package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * Main class for Chris.
 */
public class chrisMain {
  /**
   * Executable main class.
   * @param args
   */
  public static void main(String[] args) {

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
    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      if (id == Profile.profilesSaveLine(i).getUserID()) {
        a = Profile.profilesSaveLine(i).getResidenceRegion();
      } else {
        a = "No match";
      }
    }
    System.out.println(a);
    return a;
  }
}
