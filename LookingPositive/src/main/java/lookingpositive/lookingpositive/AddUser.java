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
    Scanner sc = new Scanner(System.in);
    new Profile(handleFirstName(sc), handleLastName(sc),
        handleResidenceRegion(sc), handleAge(sc), handleIsSusceptible(sc),
        handlePassword(sc), handleEmail(sc));
//    sc.close();
  }
  /**
   * Requires user to add his name.
   * @param sc
   * @return first name
   */
  protected static String handleFirstName(final Scanner sc) {
      System.out.println("Όνομα: ");
      return handleName(sc);
  }
  /**
   * Requires user to add his surname.
   * @param sc
   * @return last name
   */
  protected static String handleLastName(final Scanner sc) {
    System.out.println("Επώνυμο: ");
    return handleName(sc);
  }

  /**
   * Case 3 constant.
   */
  private static final int THREE = 3;
  /**
   * User adds his residence region.
   * @param sc
   * @return residence region
   */
  private static String handleResidenceRegion(final Scanner sc) {

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
   * @param sc
   * @return age
   */
  private static int handleAge(final Scanner sc) {
    System.out.println("Ηλικία: ");
    int age = 0;
    boolean flag = true;
    while (flag) {
       flag = false;
       try {
         age = sc.nextInt();
       } catch (InputMismatchException e) {
         flag = true;
         System.out.println("Εισάγετε σωστή ηλικία.");
       } catch (Exception e) {
         flag = true;
         System.out.println("Εισάγετε έγκυρο αριθμό.");
       }
       if (age < 0) {
         System.out.println("Εισάγετε έγκυρη ηλικία.");
         flag = true;
       }
       sc.nextLine();
    }
    return age;
  }
  /**
   * User declares whether he/she is susceptible.
   * @param sc
   * @return whether he/she susceptible
   */
  private static Boolean handleIsSusceptible(final Scanner sc) {
    System.out.println("Ανήκετε σε ευπαθή ομάδα; (Ν/Ο)");
    boolean w = true;
    String susceptible = null;

    while (w) {
      w = false;
      susceptible = sc.nextLine();
      if (!(susceptible.equals("N") || susceptible.equals("O")
         || susceptible.equals("Ν") || susceptible.equals("Ο")
         || susceptible.equals("n") || susceptible.equals("o")
         || susceptible.equals("ν") || susceptible.equals("ο"))) {
        System.out.println("Εισάγετε έγκυρο χαρακτήρα (N/O)");
        w = true;
      }
    }
    boolean isSuspectible;
    if (susceptible == "N" || susceptible == "n"
     || susceptible == "Ν" || susceptible == "ν") {
      isSuspectible = true;
    } else {
      isSuspectible = false;
    }
    return isSuspectible;
  }
  /**
   * User set his password.
   * @param sc
   * @return User's password
   */
  private static String handlePassword(final Scanner sc) {
    System.out.println("Εισάγετε τον κωδικό σας");
    boolean w = true;
    final int eight = 8;
    final int twenty = 20;
    String pass = "";
    while (w) {
      w = false;
      pass = sc.nextLine();

      if (pass.length() < eight || pass.length() > twenty) {
        System.out.println("Ο κωδικός πρέπει να περιέχει 8 - 20 χαρακτήρες.");
        w = true;
      }
    }
    return pass;
  }

  /**
  * User adds his email.
  * @param sc
  * @return User's email
  */
  private static String handleEmail(final Scanner sc) {
    boolean a = false;
    System.out.println("Email(μόνο gmail)\n"
    + "(μέχρι πριν @. πχ.: lookingPositive@gmail.com"
    + " -> lookingPositive): ");
    String email = sc.nextLine();
    String domain = null;
    while (!a) {
      if (email.contains("@") || email.contains(".com")
          || email.contains(".gr")) {
        System.out.println("Μη έγκυρη καταχώρηση email."
          + " Προσπαθήστε ξανά χωρίς την κατάληξη @...");
          email = sc.nextLine();
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
            System.out.println("Εισάγετε έγκυρο αριθμό(1,2)");
            break;
          }
          sc.nextLine();
        }
        a = true;
      }
    }
    System.out.println("Τα στοιχεία καταχωρήθηκαν επιτυχώς.");
    String usersEmail = email + domain;
    return usersEmail;
  }
  /**
   * Checks if the input matches a real name.
   * @param input
   * @return true or false(alphabetic or not)
   */
  public static boolean alphabetCheck(final String input) {
      return ((input != null)
              && (!input.equals(""))
              //Greek or Latin characters, plus spaces or - available
              && (input.matches("^[a-zA-Zα-ωΑ-Ωά-ώΆ-Ώ- ]*$")));
  }
  /**
   * Handles user name.
   * @param sc
   * @return user's name
   */
  public static String handleName(final Scanner sc) {
    String name = null;
    boolean flag = true;
    while (flag) {
      try {
        name = sc.nextLine();
        flag = false;
      } catch (Exception e) {
        flag = true;
        System.err.println("Λανθασμένη καταχώρηση. Προσπαθήστε ξανά." + e);
      }
      if (!alphabetCheck(name)) {
        flag = true;
        System.out.println("Λανθασμένη καταχώρηση. Προσπαθήστε ξανά.");
      }
    }
    return name;
  }
}
