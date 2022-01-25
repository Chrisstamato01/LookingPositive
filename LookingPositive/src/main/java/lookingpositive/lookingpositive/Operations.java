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
 * This class has the main thread of the program.
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

    FileManager.makeDirectory();
    try {
      FileManager.booleanReader();
      FileManager.dataReader();

    } catch (FileNotFoundException e) {

      FileManager.booleanWriter();
      FileManager.dataRetriever();
      FileManager.dataSaver();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (dateLastUserSignedIn != null) {
      Calendar.deleteExpiredEvents(LocalDate.now(), dateLastUserSignedIn);
    }

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
        FileManager.dataSaver();
        break;

      case choiceTwo:
        Health.chooseOperation(userId);
        FileManager.dataSaver();
        break;

      case choiceThree:
        Geography.showMunColor(dateLastUserSignedIn);
        FileManager.dataSaver();
        break;

      case choiceFour:
        Information.infoMenu();
        FileManager.dataSaver();
        break;

      case choiceFive:
        AddUser.change(userId);
        FileManager.dataSaver();
        break;

      case choiceSix:
        execution = false;
        FileManager.dataSaver();
        System.out.println("The program was terminated successfully.");
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
        System.out.println("Enter an integer.");
        choice = 0;
      } catch (Exception e) {
        choice = 0;
        System.out.println(e);
      }

      if (choice < smallerChoice || choice > biggerChoice) {
        System.out.println("Choose a number between [1-6].");
      }
      sc.nextLine();
    }

    return choice;
  }

  /**
   * This method prints the choices the user has.
   */
  private static void menu() {
    System.out.println("------------ Menu ------------ \n" + "1. Events \n"
        + "2. Health \n" + "3. Epidimiological Status \n"
        + "4. Informations about Covid-Sars-19 \n" + "5. Settings \n"
        + "6. Exit \n" + "Choose a number between [1-6].");

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
