package lookingpositive.lookingpositive;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class creates users' profiles.
 *
 */
public final class AddUser {
  /**
   * AddUser default constructor.
   */
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
  }

  /**
   * Changes the user's data.
   * @param id is the user's id
   */
  public static void change(final int id) {
    Scanner sc = new Scanner(System.in);
    boolean flag = false;
    System.out.println("Θα θέλατε να αλλάξετε email ή κωδικό; \n"
        + "1. Email \n"
        + "2. Κωδικό");
    while (!flag) {
      int choice = sc.nextInt();
      if (choice == 1) {
        changeEmail(id, sc);
        flag = true;
      } else if (choice == 2) {
        changePassword(id, sc);
        flag = true;
      } else {
        System.out.println("Εισάγετε έγκυρη επιλογή:\n"
            + "[1] για mail ή [2] για κωδικό");
      }
    }
  }

  /**
   * Changes user's password.
   * @param id is the user's id
   * @param sc is the Scanner
   */
  public static void changePassword(final int id, final Scanner sc) {
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (Profile.profilesLine(i).getUserID() == id) {
        Profile profile = Profile.profilesLine(i);
        profile.setPassword(handlePassword(sc));
      }
    }
  }

  /**
   * Changes user's mail.
   * @param id is the user's id
   * @param sc is the Scanner
   */
  public static void changeEmail(final int id, final Scanner sc) {
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (Profile.profilesLine(i).getUserID() == id) {
        Profile profile = Profile.profilesLine(i);
        profile.setEmail(mailChanger(sc));
      }
    }
    System.out.println("Το email άλλαξε επιτυχώς.");
  }

  /**
   * Requires user to add his name.
   * @param sc is a Scanner
   * @return first name
   */
  protected static String handleFirstName(final Scanner sc) {
      System.out.println("Εισάγετε όνομα: ");
      return handleName(sc);
  }
  /**
   * Requires user to add his surname.
   * @param sc is a Scanner
   * @return last name
   */
  protected static String handleLastName(final Scanner sc) {
    System.out.println("Εισάγετε επώνυμο: ");
    return handleName(sc);
  }

  /**
   * Case 3 constant.
   */
  private static final int THREE = 3;
  /**
   * User adds his residence region.
   * @param sc is a Scanner
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
   * @param sc is a Scanner
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
   * @param sc is a Scanner
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
   * @param sc is a Scanner
   * @return User's password
   */
  private static String handlePassword(final Scanner sc) {
    System.out.println("Δημιουργείστε τον κωδικό σας");
    boolean w = true;
    final int eight = 8;
    final int twenty = 20;
    String pass = "";
    while (w) {
      w = false;
      pass = sc.nextLine();
      if (pass.length() < eight || pass.length() > twenty
          || !passwordCheck(pass)) {
        System.out.println("Ο κωδικός πρέπει να περιέχει 8 - 20 χαρακτήρες"
            + " χωρίς κενά.");
        w = true;
      }
    }
    return pass;
  }

  /**
   * Handles the email.
   * @param sc Scanner
   * @return the email of the user.
   */
  private static String handleEmail(final Scanner sc) {
    String email = makeEmail(sc);
    while (checkEmail(email)) {
      System.out.println("Υπάρχει ήδη χρήστης με αυτό το email."
          + " Προσπαθήστε ξανά.");
      email = makeEmail(sc);
    }
    System.out.println("Τα στοιχεία καταχωρήθηκαν επιτυχώς.");
    return email;
  }

  /**
  * User adds his email.
  * @param sc is a Scanner
  * @return User's email
  */
  private static String makeEmail(final Scanner sc) {
    boolean a = false;
    System.out.println("Email(μόνο gmail)\n"
    + "(μέχρι πριν @. πχ.: lookingPositive@gmail.com"
    + " -> lookingPositive):");
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
    String usersEmail = email + domain;
    return usersEmail;
  }

  /**
   * Handles the email.
   * @param sc Scanner
   * @return the email of the user.
   */
  private static String mailChanger(final Scanner sc) {
    String email = newEmail(sc);
    while (checkEmail(email)) {
      System.out.println("Αυτό το email είναι ήδη σε χρήση."
          + " Προσπαθήστε ξανά.");
      email = newEmail(sc);
    }
    return email;
  }

  /**
   * Checks if email is already in use.
   * @param email
   * @return true or false
   */
  public static boolean checkEmail(final String email) {
    boolean flag = false;
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (email.equals(Profile.profilesLine(i).getEmail())) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * User changes his email.
   * @param sc is a Scanner
   * @return User's email
   */
   private static String newEmail(final Scanner sc) {
     final int shortestMail = 6;
     final int longestMail = 6;
     boolean a = false;
     System.out.println("Εισαγετε νεο e-mail(μόνο gmail)\n"
     + "(μέχρι πριν @. πχ.: lookingPositive@gmail.com"
     + " -> lookingPositive): \n"
     + "Aν εισάγετε κενό, το mail σας θα καταχωρηθεί μέχρι αυτό.");
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
             System.out.println("Εισάγετε έγκυρο αριθμό(1,2)");
             break;
           }
           sc.nextLine();
         }
         a = true;
       }
     }
     String usersEmail = email + domain;
     return usersEmail;
   }

  /**
   * Checks if the input matches a real name.
   * @param input is the word to be checked
   * @return true or false(alphabetic or not)
   */
  public static boolean alphabetCheck(final String input) {
      return ((input != null)
              && (!input.equals(""))
              //Greek or Latin characters, plus spaces or - available
              && (input.matches("^[a-zA-Zα-ωΑ-Ωά-ώΆ-Ώ- ]*$")));
  }
/**
 * Checks if the password is valid.
 * @param input is the password to be checked
 * @return true or false
 */
  public static boolean passwordCheck(final String input) {
    return ((input != null)
            && (!input.equals(""))
            //Greek or Latin characters, plus spaces or symbols available
            && (input.matches("^[a-zA-Zα-ωΑ-Ωά-ώΆ-Ώ0-9!@#$%&-_]*$")));
  }
  /**
   * Handles user name.
   * @param sc is a Scanner
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
