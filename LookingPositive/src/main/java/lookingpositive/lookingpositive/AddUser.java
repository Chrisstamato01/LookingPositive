package lookingpositive.lookingpositive;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class creates users' profiles.
 *
 */
public final class AddUser {
  private AddUser() {

  }
  /**
   * initializes User IDs.
   */
  private static int id = 0;            //was not private
  /**
   * initializes User IDs.
   */
  private static final int PASSWORD = 1000;   //was not private

  /**
   * Nvm.
   */
  private static boolean hasError = false;
  /**
   * Handles the addition of new users.
   */
  public static void add() {
    Profile profile = new Profile(handleFirstName(), handleLastName(),
        handleResidenceRegion(), handleAge(), handleIsSusceptible(),
        handlePassword(), handleEmail());

    hasError = false;
  }
  /**
   * Requires user to add his name.
   *
   * @return first name
   */
  protected static String handleFirstName() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Όνομα: ");
    String firstName = null;

    boolean flag = true;
    while (flag) {

      try {
        firstName = sc.next();
        flag = false;
      } catch (Exception e) {
        flag = true;
        System.err.println("Εισάγετε έγκυρο όνομα" + e);
      }
    }
    System.out.println(firstName);

    return firstName;
  }
  /**
   * Requires user to add his surname.
   *
   * @return last name
   */
  protected static String handleLastName() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Επώνυμο: ");
    String lastName = "ka Tzortziia";

    boolean flag = false;
    while (flag) {
      try {
        lastName = sc.next();
        flag = true;
      } catch (Exception e) {

        System.err.println("Εισάγετε έγκυρο επώνυμο" + e);
      }
    }
    System.out.println(lastName);

    return lastName;
  }

/*  private static String handleMobilePhone() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Κινητό Τηλέφωνο: ");

    String mobileNumber = "-";
    boolean flag = true;
    while (flag) {
      flag = false;
      try {
        mobileNumber = sc.next();
      } catch (InputMismatchException e) {
        flag = true;
        System.out.println("Εισάγετε έγκυρο αριθμό τηλεφώνου");
      }
      sc.nextLine();
    }

    return mobileNumber;
  }
*/
  /**
   * Requires user to add his residence region.
   *
   * @return residence region
   */
  private static String handleResidenceRegion() {
    Scanner sc = new Scanner(System.in);
    int a = -1;
    String residenceRegion = null;

    boolean flag = true;

    boolean exceptionNotOccured = false;
    System.out.println(
        "Δήμος Κατοικίας[Γλυφάδα(1), Άλιμος(2), Βάρη-Βούλα-Βουλιαγμένη(3)]: ");
    while (flag) {
      flag = false;
      exceptionNotOccured = false;
      while (!exceptionNotOccured) {

        try {
          a = sc.nextInt();
          exceptionNotOccured = true;
        } catch (InputMismatchException e) {
          System.out.println("Εισάγετε έγκυρο αριθμό(1,2,3)");
          sc.nextLine();
        }

      }
      switch (a) {

      case 1:
        residenceRegion = "Γλυφάδα";
        break;

      case 2:
        residenceRegion = "'Αλιμος";
        break;

      case 2 + 1:
        residenceRegion = "Βάρη-Βούλα-Βουλιαγμένη";
        break;

      default:
        flag = true;
        System.out.println("Εισάγετε έγκυρο αριθμό(1,2,3)");
        break;

      }
      sc.nextLine();
    }

    return residenceRegion;
  }
  /**
   * Generates users' private IDs.
   *
   * @return users' IDs
   */
  private static int handleUserID() {
    return id++;
  }
  /**
   * Requires user to add his age.
   *
   * @return age
   */
  private static int handleAge() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ηλικία: ");
    int age = 0;
    boolean flag = true;
    while (flag) {
      flag = false;
      try {

        age = sc.nextInt();
      } catch (InputMismatchException e) {
        flag = true;
        System.out.println("Εισάγετε σωστή ηλικία");
      } catch (Exception e) {
        flag = true;
        System.out.println("Εισάγετε έγκυρο αριθμό");
      }
      sc.nextLine();
    }
    return age;

  }
  /**
   * Requires user to declare whether he/she belongs to high risk groups or not.
   *
   * @return whether he/she susceptible
   */
  private static Boolean handleIsSusceptible() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ανήκετε σε ευπαθή ομάδα; (Ν/Ο)");

    boolean w = true;
    String susceptible = null;

    while (w) {
      w = false;
      susceptible = sc.next();
      if (!(susceptible.equals("N") || susceptible.equals("O"))) {
        System.out.println("Εισάγετε έγκυρο χαρακτήρα");
        w = true;
      }
    }

    boolean isSuspectible;
    if (susceptible == "Ν") {
      isSuspectible = true;
    } else {
      isSuspectible = false;
    }
    return isSuspectible;
  }
  /**
   * Requires user to set his password.
   *
   * @return User's password
   */
  private static String handlePassword() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Εισάγετε τον κωδικό σας");
    String pass = sc.next();
    return pass;
  }

  /**
  * Requires user to add his email.
  *
  * @return User's email
  */
  private static String handleEmail() {
    boolean a = false;
    Scanner sc = new Scanner(System.in);
    System.out.println("Email(μέχρι πριν @. πχ.: lookingPositive@gmail.com"
    + " -> lookingPositive): ");
    String email = sc.next();
    while (!a) {
      if (email.contains("@") || email.contains(".com")
          || email.contains(".gr")) {
        System.out.println("Μη έγκυρη καταχώρηση email."
          + " Προσπαθήστε ξανά χωρίς την κατάληξη @...");
      } else {
        System.out.println("Τα στοιχεία καταχωρήθηκαν επιτυχώς");
        a = true;
      }
    }
    return email + "@gmail.com";
  }
}
