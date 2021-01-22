/**
 * Info about this package doing something for  file.
 */
package lookingpositive.lookingpositive;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * This class is the main and only thread of the program.
 */
public final class Operations {
  /**
   * This is the private default constructor.
   */
  private Operations() {
    // This class can not be initialized.
  }

  /**
   * Annotation that regulates the pattern of the date.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private static LocalDate dateLastUserSignedIn = null;

  /**
   * This method retrieves the data and run the method which regulates the other
   * methods.
   *
   * @param args is not used
   */
  public static void main(final String[] args) {

    // dataRetrieved =FileManager.booleanRetriever();
    FileManager.makeDirectory();
    try {
      FileManager.booleanReader();
      FileManager.dataReader();

    } catch (FileNotFoundException e) {

      FileManager.booleanWriter();
      FileManager.dataRetriever();

    } catch (IOException e) {
      e.printStackTrace();
    }

    if (dateLastUserSignedIn != null) {
      Calendar.deleteExpiredEvents(LocalDate.now(), dateLastUserSignedIn);
    }

    // dataReader καθε φορά εκτοσ απ την πρωτη δεν θα διαβαζει απο τζαρ
    run(SignInUp.login());

  }

  /**
   * This method is used to regulate the methods executed.
   *
   * @param userId is the id of the current user who logged in
   */
  public static void run(final int userId) {
    final int choiceOne = 1;
    final int choiceTwo = 2;
    final int choiceThree = 3;
    final int choiceFour = 4;
    final int choiceFive = 5;
    final int choiceSix = 6;
    boolean execution = true;

    while (execution) {

      menu();

      int menuChoice = menuChoice();

      switch (menuChoice) {

      case choiceOne:
        AddDelEvents.chooseFunction(userId);
        break;

      case choiceTwo:
        Health.chooseOperation(userId);
        break;

      case choiceThree:
        Geography.showMunColor(dateLastUserSignedIn);
        break;

      case choiceFour:
        Information.infoMenu();
        break;

      case choiceFive:
        AddUser.change(userId);
        break;

      case choiceSix:
        execution = false;
        FileManager.dataSaver();
        System.out.println("Το πρόγραμμα τερματίστηκε επιτυχώς.");
        break;
      default:
      }

    }

  }

  /**
   * This method handles user's input.
   *
   * @return an integer which is the user's choice
   */
  private static int menuChoice() {

    Scanner sc = new Scanner(System.in);
    int choice = 0;
    final int smallerChoice = 1;
    final int biggerChoice = 6;
    while (choice < smallerChoice || choice > biggerChoice) {

      try {

        choice = sc.nextInt();

      } catch (InputMismatchException e) {
        System.out.println("Εισάγετε έναν ακέραιο αριθμό.");
        choice = 0;
      } catch (Exception e) {
        choice = 0;
        System.out.println(e);
      }

      if (choice < smallerChoice || choice > biggerChoice) {
        System.out.println("Εισάγετε επιλογή [1-6]");
      }
      sc.nextLine();
    }

    return choice;
  }

  /**
   * This method prints the choices the user has.
   */
  private static void menu() {
    System.out.println("------------Μενού Επιλογών------------ \n"
        + "1. Γεγονότα \n" + "2. Υγεία \n" + "3. Γεωγραφική περιγραφή \n"
        + "4. Πληροφορίες για τον ιό \n" + "5. Ρυθμίσεις \n" + "6. Έξοδος \n"
        + "Εισάγετε επιλογή [1-6]");

  }

  /**
   * This method gets the date the last person singed in.
   *
   * @return the last date the last person singed in
   */
  public static LocalDate getDateLastUserSignedIn() {
    return dateLastUserSignedIn;
  }

  /**
   * This is a setter for dateLastUserSignedIn.
   *
   * @param newdate the new date
   */
  public static void setDateLastUserSignedIn(final LocalDate newdate) {
    dateLastUserSignedIn = newdate;
  }

}
