package lookingpositive.lookingpositive;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class handles the user's events.
 */
public final class AddDelEvents {
  /**
   * This is the private default constructor.
   */
  private AddDelEvents() {
    // This class can not be initialized.
  }

  /**
   * This method is used as user's interface.
   *
   * @param userId is each user's id
   */
  public static void chooseFunction(final int userId) {
    Scanner sc = new Scanner(System.in);
    System.out
        .println("Choose one of the following options:" + "\n1. Event registry."
            + "\n2. Event deletion." + "\n3. Print of future events.");
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
          System.out.println("Please enter 1, 2 or 3.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Please enter an integer number.");
      } catch (Exception e) {
        System.err.println(e);
      }
      sc.nextLine();
    }
    switch (choice) {
    case firstCase:
      addEvent(userId);
      break;
    case secondCase:
      System.out.println(deleteEvent(userId));
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
   * @param userId the user whose event we want to add
   */
  private static void addEvent(final int userId) {
    System.out.println(Calendar.addToCalendar(
        new Event(dateInput(), addGeography(), profileListInput()), userId));

  }

  // the user chooses the day of the event (today/future)
  /**
   * This method asks the date of the event that the user wants to create.
   *
   * @return the date of the new event
   */
  private static LocalDate dateInput() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the date of your event (dd/MM/yyyy).");
    boolean flag = true;
    LocalDate date = null;
    while (flag) {
      flag = false;
      String sDate = sc.nextLine();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      try {
        date = LocalDate.parse(sDate, dateFormat);
        LocalDate now = LocalDate.now();
        if (now.until(date, ChronoUnit.DAYS) < 0) {
          flag = true;
          System.out.println("Your date input belongs to the past."
              + " Please enter future's or today's date.");
        }
      } catch (DateTimeParseException e) {
        System.out.println("Enter a date with the proper pattern (dd/MM/yyyy) "
            + "with range of days 01-31 and range of months 01-12.");
        flag = true;
      } catch (Exception e) {
        System.out.println("AN ERROR OCCURED " + e);
        flag = true;
      }

    }

    return date;
  }

  // the user gives the a list of names he/she will see at the event
  /**
   * This method asks the user which people he will meet at the event.
   *
   * @return the people he will meet
   */
  private static ArrayList<Profile> profileListInput() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Profile> contactedPeople = new ArrayList<Profile>();
    System.out.println("Will you meet up with other people during (Y/N).");
    boolean flag = true;
    String answer = null;
    while (flag) {
      answer = sc.nextLine();
      if (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))) {
        System.out.println("Your input is not valid.Please try again. Y/N");
      } else {
        flag = false;
      }
    }
    if (answer.equalsIgnoreCase("Y")) {
      System.out.println("Enter the people you will meet.");
      String innerAnswer = "Y";
      while (innerAnswer.equalsIgnoreCase("Y")) {
        System.out.println("Enter the person's first name.");
        String firstName = sc.nextLine();
        System.out.println("Enter the person's last name.");
        String lastName = sc.nextLine();
        contactedPeople.add(addContactedPeople(firstName, lastName));
        System.out.println("Will you meet other people ; (Y/N) ");
        flag = true;
        while (flag) {
          innerAnswer = sc.nextLine();
          if (!(innerAnswer.equalsIgnoreCase("Y")
              || innerAnswer.equalsIgnoreCase("N"))) {
            System.out.println("Your input is not valid." + " Chosese Y or N ");
          } else {
            flag = false;
          }
        }

      }
    }
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
  private static Profile addContactedPeople(final String firstName,
      final String lastName) {
    Iterator<Profile> it = Profile.getProfiles().iterator();
    Profile person;
    Profile person2 = null;
    while (it.hasNext()) {
      person = it.next();
      if (person.getFirstName().contentEquals(firstName)
          && person.getLastName().contentEquals(lastName)) {
        person2 = person;
        break;
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
  private static void viewEvents(final int userId) {
    int i;
    for (i = 0; i < Calendar.getToday().getUsersEventListsSize(userId); i++) {

      System.out.println(
          i + 1 + " " + Calendar.getToday().getCurrentEvent(userId, i));
    }
    int j;
    for (j = 0; j < Calendar.getFuture().getUsersEventListsSize(userId); j++) {

      System.out.println(
          j + 1 + i + " " + Calendar.getFuture().getCurrentEvent(userId, j));
    }
    if (i == 0 && j == 0) {
      System.out.println("There are no scheduled events.");
    }
  }

  // the user deletes a future event from his calendar
  /**
   * This method prints a user's Events so that the user can delete one of them.
   *
   * @param userId the id of a specific user
   * @return a message of successful deletion
   */
  private static String deleteEvent(final int userId) {

    System.out.println("The scheduled events are : ");
    viewEvents(userId);
    if (Calendar.getFuture().getUsersEventListsSize(userId) == 0
        && Calendar.getToday().getUsersEventListsSize(userId) == 0) {

      return "There are no events to be deleted.";
    } else {
      return deletingExistingEvent(userId);
    }
  }

  /**
   * This method deletes an Event.
   *
   * @param userId the Id of the user who wants to delete an Event
   * @return a message of success
   */
  private static String deletingExistingEvent(final int userId) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose the number of the event you wish to delete.");
    boolean foundException = true;
    boolean numberNotFound = true;
    int n = -1;
    while (foundException) {
      while (numberNotFound) {
        try {
          n = sc.nextInt();
          if (n > Calendar.getFuture().getUsersEventListsSize(userId)
              + Calendar.getToday().getUsersEventListsSize(userId) || n < 1) {

            System.out.println("Please enter a valid number.");
          } else {
            numberNotFound = false;
          }
          foundException = false;
        } catch (InputMismatchException e) {
          System.out.println("Please enter an integer number.");
        } catch (Exception e) {
          System.err.println(e);
        }
        sc.nextLine();
      }
    }
    if (n > Calendar.getToday().getUsersEventListsSize(userId)) {
      Calendar.getFuture().removeCurrentEvent(userId,
          n - 1 - Calendar.getToday().getUsersEventListsSize(userId));
    } else {
      Calendar.getToday().removeCurrentEvent(userId, n - 1);
    }
    return "The event" + n + " has been successfuly deleted.";
  }

  // the user chooses where his/her event will take place
  /**
   * This method asks the municipality the event will take place.
   *
   * @return the place of the event
   */
  private static Geography addGeography() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Which municipality do you want to visit "
        + "(Vari-Voula-Vouliagmeni(1) - Alimos(2) - Glyfada(3). ");
    boolean flag = true;
    String municipality = null;
    final int firstCase = 1;
    final int secondCase = 2;
    final int thirdCase = 3;
    int num = -1;
    boolean exceptionFound = true;
    while (flag) {
      exceptionFound = true;
      while (exceptionFound) {
        try {
          num = scanner.nextInt();
          exceptionFound = false;
        } catch (InputMismatchException e) {
          System.out.println("Please enter an integer number.");
        }
        scanner.nextLine();
      }
      switch (num) {
      case firstCase:
        municipality = "3B";
        printFacilities(municipality);
        flag = false;
        break;
      case secondCase:
        municipality = "Alimos";
        printFacilities(municipality);
        flag = false;
        break;
      case thirdCase:
        municipality = "Glyfada";
        printFacilities(municipality);
        flag = false;
        break;
      default:
        System.out.println("Enter 1, 2 or 3. ");
        break;
      }
    }
    return chooseFacility(municipality);
  }

  /**
   * This method allows the user to chose a facility.
   *
   * @param municipality the municipality the user wants to visit
   * @return the facility which he wants to visit
   */
  private static Geography chooseFacility(final String municipality) {
    Scanner scanner = new Scanner(System.in);
    System.out
        .println("Enter the number of the facility" + "you want to visit. ");
    boolean flag = true;
    int choice = -1;
    final int outOfBounds = 1;
    while (flag) {
      try {
        choice = scanner.nextInt();

        if (choice > Geography.getFacilitiesSize() || choice < outOfBounds) {
          System.out.println("Please enter a valid number.");
        } else {

          flag = validatingFacility(choice, municipality);
          if (flag) {
            System.out.println("The facility you chose to visit does "
                + "not belong to the municipality "
                + "you chose. Please enter a valid number.");
          }
        }
      } catch (InputMismatchException e) {
        System.out.println("Please enter an integer number.");
        flag = true;
      } catch (Exception e) {
        System.err.println(e);
        flag = true;
      }
      scanner.nextLine();
    }
    return Geography.getFacilitiesLine(choice - 1);
  }

  /**
   * This method checks that the facility the user chooses belongs to the chosen
   * municipality.
   *
   * @param choice       the facility the user chose
   * @param municipality the municipality the user has previously chosen
   * @return a boolean which shows if the chosen facility belongs to the certain
   *         municipality
   */
  private static boolean validatingFacility(final int choice,
      final String municipality) {

    boolean notFoundFacility = true;

    if (Geography.getFacilitiesLine(choice - 1).getMunicipality()
        .contentEquals(municipality)) {
      notFoundFacility = false;
    }
    return notFoundFacility;
  }

  /**
   * This method prints the facilities of a certain municipality.
   *
   * @param municipality the municipality the user wants to visit
   */
  private static void printFacilities(final String municipality) {
    for (int i = 0; i < Geography.getFacilitiesSize(); i++) {
      if (Geography.getFacilitiesLine(i).getMunicipality()
          .contentEquals(municipality)) {
        System.out.println((i + 1) + ". " + Geography.getFacilitiesLine(i));
      }
    }
  }
}
