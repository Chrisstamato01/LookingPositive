/**
  * Looking Positive Health.
  */
package lookingpositive.lookingpositive;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class processes Health informations about the user.
 */
public final class Health {
  /**
   * private constructor.
   */
  private Health() {
  }

  /**
   * choice three.
   */
  private static final int THREE = 3;
  /**
   * choice four.
   */
  private static final int FOUR = 4;
  /**
   * choice five.
   */
  private static final int FIVE = 5;
  /**
   * choice six.
   */
  private static final int SIX = 6;
  /**
   * choice seven.
   */
  private static final int SEVEN = 7;
  /**
   * choice eight.
   */
  private static final int EIGHT = 8;

  /**
   * @param userID current userID
   */
  public static void chooseOperation(final int userID) {
    System.out.println("If you want to update your health status, press 1");
    System.out.println("If you have Coronavirus, press 2 ");
    System.out.println("Press 0 to return to the home menu");
    Scanner sc = new Scanner(System.in);
    int answer = -1;
    while (answer != 1 && answer != 2 && answer != 0) {
      try {
        answer = sc.nextInt();
      } catch (InputMismatchException ex) {
        sc.next();
        System.out.println("Invalid value");
      } catch (Exception e) {
        System.out.println(e);
        sc.next();
      }

      if (answer != 1 && answer != 2 && answer != 0) {
        System.out.println("Enter an option [0-2]");
      }
    }
    if (answer == 2) {
      Geography.newCase(userID);
      Tracking.track(userID);
    } else if (answer == 1) {
      areYouOk();
    }
    if (answer == 0) {
      return;
    }
  }

  /**
   * this method records symptoms.
   */
  public static void areYouOk() {
    System.out.println("Do you feel good today? (YES/NO)");
    Scanner sc = new Scanner(System.in);
    String answer = null;
    boolean flag = true;
    while (flag) {
      try {
        answer = sc.next();
        if (answer.equalsIgnoreCase("NO") || answer.equalsIgnoreCase("YES")) {
        flag = false;
        } else {
          System.out.println("Enter (YES/NO)");
        }
      } catch (Exception e) {
        flag = true;
        System.out.println("Enter (YES/NO)");
      }
    }
    if (answer.equalsIgnoreCase("NO")) {
      flag = false;
      int countsymptoma = 0;
      while (!flag) {
        System.out.println("\nBelow are the symptoms you can report:\n");
        if (countsymptoma != 0) {
          System.out.println(
              "You can add more symptoms or you can exit by pressing 0");
        }
        System.out.println("If you have a fever, press 1 ");
        System.out.println("If you have a cough, press 2");
        System.out.println("If you feel tired, press 3");
        System.out.println("If you have a loss of taste, press 4");
        System.out.println("If you have a loss of smell, press 5");
        System.out.println("If you have a sore throat, press 6");
        System.out.println("If you have a headache, press 7");
        System.out.println("If you have dyspnea, press 8");
        if (countsymptoma == 0) {
        System.out.println("If you do not want to add a symptom, press 0");
        }
        int choice = -1;
        while (choice < 0 || choice > EIGHT) {
          try {
            choice = sc.nextInt();

          } catch (InputMismatchException ex) {
            sc.next();
            System.out.println("Invalid value");
          } catch (Exception ex) {
            System.out.println(ex);
            sc.next();
          }
          if (choice < 0 || choice > EIGHT) {
            System.out.println("Enter an option [0-8]");
          }

        }
        switch (choice) {
        case 0:
          flag = true;
          break;
        case 1:
          countsymptoma = countsymptoma + 2; // Some symptoms are
                                             // increase by two
                                             // because they are
                                             // considered to
                                             // have greater weight
          break;
        case 2:
          countsymptoma = countsymptoma + 2;
          break;
        case THREE:
          countsymptoma = countsymptoma + 1;
          break;
        case FOUR:
          countsymptoma = countsymptoma + 2;
          break;
        case FIVE:
          countsymptoma = countsymptoma + 2;
          break;
        case SIX:
          countsymptoma = countsymptoma + 1;
          break;
        case SEVEN:
          countsymptoma = countsymptoma + 1;
          break;
        case EIGHT:
          countsymptoma = countsymptoma + 1;
          break;
        default:
          break;
        }
      }
      if (countsymptoma == 0) {
        System.out.println("There is no reason to worry.\n");
      } else if (countsymptoma < THREE) {
        System.out.println(
            "Please contact your doctor and stay at home as a precaution.\n");
      } else {
        System.out.println(
            "Please contact your doctor as soon as possible,"
            + " you may have Covid-19.\n");
      }
    } else {
      System.out.println("Perfect! Have a nice day and be careful!\n");
    }
  }
}
