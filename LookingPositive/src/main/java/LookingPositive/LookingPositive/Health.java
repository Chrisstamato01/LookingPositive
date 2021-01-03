package LookingPositive.LookingPositive;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Health {
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
   * @exception InputMismatchException
   */
  public static void chooseOperation(final int userID) {
    System.out.println(
        " Αν θέλετε να ενημερώσετε την κατάσταση υγεία σας, πιέστε 1 ");
    System.out.println(" Αν είστε θετικός στο Κορωνοϊό, πιέστε 2 ");
    Scanner sc = new Scanner(System.in);
    int answer = 0;
    while (answer != 1 || answer != 2) {
      try {
        answer = sc.nextInt();

      } catch (Exception ex) {
        sc.next();
        System.out.println("Μη έγκυρη τιμή");
      }

      if (answer != 1 || answer != 2) {
        System.out.println("Εισάγετε επιλογή [1-2]");
      }
    }
    if (answer == 2) {
      Tracking.track(userID);
    } else {
      areYouOk();
    }
  }

  /**
   * this method records symptoms.
   *
   * @exception InputMismatchException
   */
  public static void areYouOk() {
    System.out.println(" Νιώθετε καλά σήμερα ;(ΝΑΙ/ΟΧΙ) ");
    Scanner sc = new Scanner(System.in);
    String answer = null;
    boolean flag = true;
    while (flag) {
      try {
        answer = sc.next();
        flag = false;
      } catch (Exception e) {
        flag = true;
        System.out.println("Εισάγετε (ΝΑΙ/ΟΧΙ) ");
      }
    }
    if (answer.equalsIgnoreCase("ΟΧΙ")) {
      flag = false;
      int countsymptoma = 0;
      while (!flag) {
        System.out.println("Άν έχετε πυρετό πατήστε 1");
        System.out.println("Άν έχετε βήχα πατήστε 2");
        System.out.println("Άν αισθάνεστε κόπωση πατήστε 3");
        System.out.println("Άν έχετε απώλεια γεύσης πατήστε 4");
        System.out.println("Άν έχετε απώλεια όσφρισης πατήστε 5");
        System.out.println("Άν έχετε λαιμόπονο πατήστε 6");
        System.out.println("Άν έχετε πονοκέφαλο πατήστε 7");
        System.out.println("Άν έχετε δύσποια πατήστε 8");
        System.out.println(
            "Άν δεν επιθυμείτε να προσθέσετε κάποιο σύμπτωμα πατήστε 0");
        int choice = -1;
        while (choice < 0 || choice > EIGHT) {
          try {
            choice = sc.nextInt();

          } catch (InputMismatchException ex) {
            sc.next();
            System.out.println("Μη έγκυρη τιμή");
          }
// yparxi alli ejairesi???
          if (choice < 0 || choice > EIGHT) {
            System.out.println("Εισάγετε επιλογή [0-8]");
          }

        }
        switch (choice) {
        case 0:
          flag = true;
          break;
        case 1:
          countsymptoma = countsymptoma + 2; // Σε κάποια συμπτώματα
                                             // προστίθονται δύο γιατι θεωρείται
                                             // οτι
                                             // έχουν μεγαλύτερη βαρύτητα
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
        // ΝΑ ΞΑΝΑ ΕΛΕΓΞΟΥΜΕ ΤΗ SWITCH
      }
      if (countsymptoma == 0) {
        System.out.println("Δεν υπάρχει λόγος ανησυχίας");
      } else if (countsymptoma < THREE) {
        System.out.println("Παρακαλώ επικοινωνίστε με τον γιατρό σας και "
            + "μέινετε προληπτικά σπιτι και να είστε σε επιφυλακή");
      } else {
        System.out.println("Παρακαλώ επικοινωνίστε το συντομότερο με το "
            + "γιατρό σας, πιθανως να εχετε Covid-19");
      }
    } else {
      System.out.println("Τέλεια! Να έχετε μια καλή μέρα και να προσέχετε!");
    }
  }
}