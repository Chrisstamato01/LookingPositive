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

    Profile.profilesRetriever();

    System.out.println("Give me the id mfcker.");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();

    AddUser.change(id);

    for (int i = 0; i < Profile.profilesSize(); i++) {
      System.out.println(Profile.profilesLine(i));
    }
  }
}
