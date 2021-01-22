package lookingpositive.lookingpositive;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
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
        handleResidenceRegion(sc), handleBirthday(sc), handleIsSusceptible(sc),
        handlePassword(sc), handleEmail(sc));
  }

  /**
   * Changes the user's data.
   * @param id is the user's id
   */
  public static void change(final int id) {
    Scanner sc = new Scanner(System.in);
    boolean flag = false;
    System.out.println("Would you like to change your email or password? \n"
        + "1. Email \n"
        + "2. Password");
    while (!flag) {
      int choice = sc.nextInt();
      if (choice == 1) {
        changeEmail(id, sc);
        flag = true;
      } else if (choice == 2) {
        changePassword(id, sc);
        flag = true;
      } else {
        System.out.println("Insert valid number:\n"
            + "[1] for email ή [2] for password.");
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
    System.out.println("Your email has been changed successfully.");
  }

  /**
   * Requires user to add his name.
   * @param sc is a Scanner
   * @return first name
   */
  protected static String handleFirstName(final Scanner sc) {
      System.out.println("Enter your name: ");
      return handleName(sc);
  }
  /**
   * Requires user to add his surname.
   * @param sc is a Scanner
   * @return last name
   */
  protected static String handleLastName(final Scanner sc) {
    System.out.println("Enter your surname: ");
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
        "Enter Residence Region:\n"
        + "[Glyfada(1), Alimos(2), Vari-Voula-Vouliagmeni(3)]: ");
    while (flag) {
      flag = false;
      exceptionNotOccured = false;
      while (!exceptionNotOccured) {

        try {
          a = sc.nextInt();
          exceptionNotOccured = true;
        } catch (InputMismatchException e) {
          System.out.println("Enter valid number: (1,2,3)");
          sc.nextLine();
        }

      }
      switch (a) {

      case 1:
        residenceRegion = "Glyfada";
        break;

      case 2:
        residenceRegion = "Alimos";
        break;

      case THREE:
        residenceRegion = "Vari-Voula-Vouliagmeni";
        break;

      default:
        flag = true;
        System.out.println("Enter valid number(1,2,3)");
        break;

      }
      sc.nextLine();
    }

    return residenceRegion;
  }

  /**
   * Handles user's birthday.
   * @param sc is the scanner
   * @return user's birthday
   */
  private static LocalDate handleBirthday(final Scanner sc) {
    System.out
        .println("Enter birthday. (dd/MM/yyyy)");
    boolean flag = true;
    LocalDate date = null;
    while (flag) {
      flag = false;
      String sDate = sc.nextLine();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      try {
        date = LocalDate.parse(sDate, dateFormat);
        LocalDate now = LocalDate.now();
        if (now.until(date, ChronoUnit.DAYS) > 0) {
          flag = true;
          System.out.println("Enter valid birth date.");
        }
      } catch (DateTimeParseException e) {
        System.out.println("Enter valid date in this form: (dd/MM/yyyy)\n"
            + "Days can be 01-31 and months can be 01-12.");
        flag = true;
      } catch (Exception e) {
        System.out.println("AN ERROR OCCURED " + e);
        flag = true;
      }

    }

    return date;
  }

  /**
   * User declares whether he/she is susceptible.
   * @param sc is a Scanner
   * @return whether he/she susceptible
   */
  private static Boolean handleIsSusceptible(final Scanner sc) {
    System.out.println("Are you susceptible (Y/N)");
    boolean w = true;
    String susceptible = null;

    while (w) {
      w = false;
      susceptible = sc.nextLine();
      if (!(susceptible.equals("Y") || susceptible.equals("N")
         || susceptible.equals("y") || susceptible.equals("n")
         )) {
        System.out.println("Enter valid character (Y for yes/N for No)");
        w = true;
      }
    }
    boolean isSuspectible;
    if (susceptible == "Y" || susceptible == "y") {
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
    System.out.println("Create your password:");
    boolean w = true;
    final int eight = 8;
    final int twenty = 20;
    String pass = "";
    while (w) {
      w = false;
      pass = sc.nextLine();
      if (pass.length() < eight || pass.length() > twenty
          || !passwordCheck(pass)) {
        System.out.println("Password must be between 8 - 20 characters"
            + " without spaces.");
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
      System.out.println("This email is already in use,"
          + " try again.");
      email = makeEmail(sc);
    }
    System.out.println("Email entered successfully.");
    return email;
  }

  /**
  * User adds his email.
  * @param sc is a Scanner
  * @return User's email
  */
  private static String makeEmail(final Scanner sc) {
    boolean a = false;
    System.out.println("Email(only gmail)\n"
    + "(until @. exmaple: lookingPositive@gmail.com"
    + " -> lookingPositive):");
    String email = sc.nextLine();
    String domain = null;
    while (!a) {
      if (email.contains("@") || email.contains(".com")
          || email.contains(".gr")) {
        System.out.println("Invalid input."
          + " Try again without the suffix @...");
          email = sc.nextLine();
      } else {
        int b = -1;

        boolean flag = true;

        boolean exceptionNotOccured = false;
        System.out.println(
            "Domain: [@gmail.com(1), @gmail.gr(2)]: ");
        while (flag) {
          flag = false;
          exceptionNotOccured = false;
          while (!exceptionNotOccured) {

            try {
              b = sc.nextInt();
              exceptionNotOccured = true;
            } catch (InputMismatchException e) {
              System.out.println("Enter valid number (1,2)");
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
            System.out.println("Enter valid number (1,2)");
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
      System.out.println("This email is already in use,"
          + " try again.");
      email = newEmail(sc);
    }
    return email;
  }

  /**
   * Checks if email is already in use.
   * @param email is the user's email input
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
/*     final int shortestMail = 6;
     final int longestMail = 6;*/
     boolean a = false;
     System.out.println("Enter new e-mail (only gmail)\n"
     + "(until @. example: lookingPositive@gmail.com"
     + " -> lookingPositive): \n"
     + "If you include a space character, your email will "
     + "be entered until the space.");
     String email = sc.next();
     String domain = null;
     while (!a) {
       if (email.contains("@") || email.contains(".com")
           || email.contains(".gr")) {
         System.out.println("Invalid email input."
           + " Try again without the suffix @...");
           email = sc.next();
       } else {
         int b = -1;

         boolean flag = true;

         boolean exceptionNotOccured = false;
         System.out.println(
             "Domain: [@gmail.com(1), @gmail.gr(2)]: ");
         while (flag) {
           flag = false;
           exceptionNotOccured = false;
           while (!exceptionNotOccured) {

             try {
               b = sc.nextInt();
               exceptionNotOccured = true;
             } catch (InputMismatchException e) {
               System.out.println("Enter valid number (1,2)");
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
             System.out.println("Enter valid number (1,2)");
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
              && (input.matches("^[a-zA-Z- ]*$")));
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
            && (input.matches("^[a-zA-Z0-9!@#$%&-_]*$")));
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
        System.err.println("Invalid input. Try again." + e);
      }
      if (!alphabetCheck(name)) {
        flag = true;
        System.out.println("Invalid input. Try again.");
      }
    }
    return name;
  }
}
