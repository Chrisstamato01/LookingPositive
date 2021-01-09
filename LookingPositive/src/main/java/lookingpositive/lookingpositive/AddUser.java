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
   * Adds user in profile array.
   */
  public static void add() {
    Profile profile = new Profile(handleFirstName(), handleLastName(),
        handleResidenceRegion(), handleAge(), handleIsSusceptible(),
        handlePassword(), handleEmail());
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
    String lastName = sc.next();
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

  /**
   * Case 3 constant.
   */
  private static final int THREE = 3;
  /**
   * User adds his residence region.
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

      case THREE:
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
   * User adds his age.
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
   * User declares whether he/she is susceptible.
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
        System.out.println("Εισάγετε έγκυρο χαρακτήρα "
            + "(Ν/Ο λατινικοί χαρακτήρες)");
        w = true;
      }
    }

    boolean isSuspectible;
    if (susceptible == "N") {
      isSuspectible = true;
    } else {
      isSuspectible = false;
    }
    return isSuspectible;
  }
  /**
   * User set his password.
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
  * User adds his email.
  *
  * @return User's email
  */
  private static String handleEmail() {
    boolean a = false;
    Scanner sc = new Scanner(System.in);
    System.out.println("Email(μόνο gmail)/n"
    + "(μέχρι πριν @. πχ.: lookingPositive@gmail.com"
    + " -> lookingPositive): ");
    String email = sc.next();
    String domain = null;
    while (!a) {
      if (email.contains("@") || email.contains(".com")
          || email.contains(".gr")) {
        System.out.println("Μη έγκυρη καταχώρηση email."
          + " Προσπαθήστε ξανά χωρίς την κατάληξη @...");
          email = sc.next();
      } else {
        int b = -1;

        boolean flag = true;

        boolean exceptionNotOccured = false;
        System.out.println(
            "Είδος gmail[@gmail.com(1), @gmail.gr(2)]: ");
        while (flag) {
          flag = false;
          exceptionNotOccured = false;
          while (!exceptionNotOccured) {

            try {
              b = sc.nextInt();
              exceptionNotOccured = true;
            } catch (InputMismatchException e) {
              System.out.println("Εισάγετε έγκυρο αριθμό(1,2)");
              sc.nextLine();
            }

          }
          switch (b) {

          case 1:
            domain = "@gmail.com";
            break;

          case 2:
            domain = "@gmail.gr";
            break;

          default:
            flag = true;
            System.out.println("Εισάγετε έγκυρο αριθμό(1,2,)");
            break;
          }
          sc.nextLine();
        }
        a = true;
      }
    }
    System.out.println("Τα στοιχεία καταχωρήθηκαν επιτυχώς");
    String usersEmail = email + domain;
    return usersEmail;
  }
}
