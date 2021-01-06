package lookingpositive.lookingpositive;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public final class AddDelEvents {

  private AddDelEvents() {
  }

  /**
   * This method is used as user's interface.
   *
   * @param userId is each user's id
   */
  public static void chooseFunction(final int userId) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Επιλέξτε μία απο τις παρακάτω ενέργειε:"
        + "\n1.Δημιουργία γεγονότος." + "\nΔιαγραφή γεγονότος."
        + "\nΕμφανιση των μελλοντικων γεγονότων.");
    int choice = -1;
    boolean flag = true;
    final int firstCase = 1;
    final int secondCase = 2;
    final int thirdCase = 3;
    while (flag) {
      try {
        choice = sc.nextInt();
        if (choice == firstCase || choice == secondCase
            || choice == thirdCase) {
          flag = false;
        } else {
          System.out.println("Παρακαλώ εισάγεται αριθμό μεταξύ των 1,2,3.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Παρακαλώ εισάγεται αριθμό.");
      } catch (Exception e) {
        System.err.println(e);
      }
    }
    switch (choice) {
    case firstCase:
      addEvent(userId);
      break;
    case secondCase:
      delEvent(userId);
      break;
    case thirdCase:
      viewEvents(userId);
      break;
    default:
      break;
    }

  }

  // the event is created and registered in the calendar
  /**
   * This method adds an event to the calendar.
   *
   * @param userId         the user whose event we want to add
   */
  public static void addEvent(final int userId) {
    Calendar.addToCalendar(
        new Event(dateInput(), addGeography(), profileListInput()), userId);

  }

  // the user chooses the day of the event (today/future)
  /**
   * This method asks the date of the event that the user wants to create.
   *
   * @return the date of the new event
   */
  public static LocalDate dateInput() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Εισάγεται ημερομηνία για την εκδήλωση σας (d/m/yyyy).");
    boolean flag = true;
    LocalDate date = null;
    while (flag) {
      flag = false;
      String sDate = sc.nextLine();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
      try {
        date = LocalDate.parse(sDate, dateFormat);
      } catch (DateTimeParseException e) {
        System.err.println("AN ERROR OCCURED " + e);
        flag = true;
      } catch (Exception e) {
        System.err.println("AN ERROR OCCURED");
        flag = true;
      }
      LocalDate now = LocalDate.now();
      if (now.until(date, ChronoUnit.DAYS) < 0) {
        flag = true;
        System.out.println("Η ημερομηνία που εισάγατε ειναι παρελθονιτκή.");
      }
    }
    sc.close();
    return date;
  }

  // the user gives the a list of names he/she will see at the event
  /**
   * This method asks the user which people he will meet at the event.
   *
   * @return the people he will meet
   */
  public static ArrayList<Profile> profileListInput() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Profile> contactedPeople = new ArrayList<Profile>();
    System.out.println(
        "Θα συναναστραφείτε και με αλλα άτομα κατά την έξοδο σας; (ΝΑΙ/ΟΧΙ).");
    boolean flag = true;
    String answer = "Ν";
    while (flag) {
      answer = sc.nextLine();
      if (!(answer.equals("ΝΑΙ") || answer.equals("ΟΧΙ"))) {
        System.out.println(
            "Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
      } else {
        flag = false;
      }
    }
    if (answer.equals("ΝΑΙ")) {
      System.out.println("Εισάγεται τα άτομα με τα οποία θα συναντηθείτε.");
      String innerAnswer = "ΝΑΙ";
      while (innerAnswer.equals("ΝΑΙ")) {
        System.out.println("Εισάγεται το όνομα του ατόμου.");
        String firstName = sc.nextLine();
        System.out.println("Εισάγεται το επίθετο του ατόμου.");
        String lastName = sc.nextLine();
        contactedPeople.add(addContactedPeople(firstName, lastName));
        System.out.println("Θα συναντηθείτε και με άλλα άτομα ; (ΝΑΙ/ΟΧΙ) ");
        flag = true;
        while (flag) {
          innerAnswer = sc.nextLine();
          if (!(innerAnswer.equals("ΝΑΙ") || innerAnswer.equals("ΟΧΙ"))) {
            System.out.println(
                "Τα δεδομένα που εισάγατε δεν είναι σωστά επιλέξτε ΝΑΙ / ΟΧΙ ");
          } else {
            flag = false;
          }
        }

      }
    }
    sc.close();
    return contactedPeople;
  }

  // checks if the names exist as users otherwise creates the profiles
  /**
   * This method validates the profile that are being added to the
   * contactedPeople list.
   *
   * @param firstName the name of the person
   * @param lastName  the last name of the person
   * @return the profiles he/she will meet
   */
  public static Profile addContactedPeople(final String firstName,
      final String lastName) {
    Iterator<Profile> it = Profile.profilesSave.iterator();
    Profile person;
    Profile person2 = null;
    while (it.hasNext()) {
      person = it.next();
      if (person.getFirstName().equals(firstName)
          && person.getLastName().equals(lastName)) {
        person2 = person;
      } else {
        person = new Profile(firstName, lastName);
        person2 = person;
      }
    }
    return person2;
  }

  /**
   * This method prints all the events a user has planed.
   *
   * @param userId specific user
   */
  public static void viewEvents(final int userId) {
    for (int i = 0; i < Calendar.getFuture()
        .getUsersEventListsSize(userId); i++) {

      System.out.println(
          i + 1 + " " + Calendar.getFuture().getCurrentEvent(userId, i));
    }
  }

  // the user deletes a future event from his calendar
  /**
   * This method deletes an event for a specific user.
   *
   * @param userId the id of a specific user
   * @return a message of success
   */
  public static String delEvent(final int userId) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Οι προγραμματισμένες σας εκδηλώσεις είναι οι εξής : ");
    viewEvents(userId);
    System.out
        .println("Επιλέξτε τον αριθμό της εκδήλωσης που θέλετε να διαγράψετε.");
    boolean foundException = true;
    boolean numberNotFound = true;
    int n = -1;
    while (foundException) {
      while (numberNotFound) {
        try {
          n = sc.nextInt();
          if (n > Calendar.getFuture().getUsersEventListsSize(userId) - 1
              || n < 1) {

            System.out.println("Παρακαλώ εισάγεται έγκειρο αριθμό.");
          } else {
            numberNotFound = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("Παρακαλώ εισάγεται αριθμό.");
        } catch (Exception e) {
          System.err.println(e);
        }
      }
    }
    Calendar.getFuture().removeCurrentEvent(userId, n - 1);
    sc.close();
    return "Η εκδήλωση " + n + " διαγράφηκε επιτυχώς. ";
  }

  // the user chooses where his/her event will take place
  /**
   * This method asks the place the event will take place.
   *
   * @return the place of the event
   */
  public static Geography addGeography() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ποιόν δήμο θα θέλατε να επισκευτείτε"
        + "(δήμος Βάρης/Βούλας/Βουλιαγμένης(1) - Άλιμος(2) - Γλυφάδα(3). ");
    boolean flag = true;
    int number = 0;
    final int firstCase = 1;
    final int secondCase = 2;
    final int thirdCase = 3;
    while (flag) {
      number = sc.nextInt();
      switch (number) {
      case firstCase:
        for (int i = 0; i < Geography.facilities.length; i++) {
          if (Geography.facilities[i].getMunicipality() == "3Β") {
            System.out.println(i + " " + Geography.facilities[i]);
          }
        }
        flag = false;
        break;
      case secondCase:
        for (int i = 0; i < Geography.facilities.length; i++) {
          if (Geography.facilities[i].getMunicipality() == "Άλιμος") {
            System.out.println(i + " " + Geography.facilities[i]);
          }
        }
        flag = false;
        break;
      case thirdCase:
        for (int i = 0; i < Geography.facilities.length; i++) {
          if (Geography.facilities[i].getMunicipality() == "Γλυφάδα") {
            System.out.println(i + " " + Geography.facilities[i]);
          }
        }
        flag = false;
        break;
      default:
        System.out.println("Εισάγεται έγκυρο αριθμό. ");
        break;
      }
    }
    System.out.println("Εισάγεται τον αριθμό του/της κατάστημος"
        + "/υπηρεσίας που θα θέλατε να επισκευτειτε. ");
    flag = true;
    int choice = -1;
    while (flag) {
      try {
        choice = sc.nextInt();
        if (choice >= Geography.facilities.length) {
          System.out.println("Παρακαλώ εισάγεται έγκειρο αριθμό.");
        } else {
          flag = false;
        }
      } catch (InputMismatchException e) {
        System.out.println("Παρακαλώ εισάγεται αριθμό.");
      } catch (Exception e) {
        System.err.println(e);
      }

    }

    return Geography.facilities[choice];
  }
}
