/**
 * Info about this package doing something for  file.
 */
package lookingpositive.lookingpositive;

import java.io.File;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
/**
 *This class is the main and only thread of the program.
 */
public final class Operations {
  /**
   * This is the private default constructor.
   */
  private Operations() {
  //This class can not be initialized.
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
   * @param args is not used
   */
  public static void main(final String[] args) {
    // dateSaver();// πρεπει να κελιθη την πρωτη φορα του ινσταλλ
    // dataSaver();πρεπει να κελιθη την πρωτη φορα του ινσταλλ
    dataRetriver();

    if (dateLastUserSignedIn != null) {
      Calendar.deleteExpiredEvents(LocalDate.now(), dateLastUserSignedIn);
    }

     Profile pr1 = new Profile("elisavet", "exarxopoulou", "voula", 44, false,
     "pass1", "papadopoulos@gmail.com");
     Profile pr2 = new Profile("maria", "exarxopoulou", "glyfada", 47, false,
     "pass2", "papadakis@gmail.com");
    run(SignInUp.login());

  }

  /**
   * This method is used to regulate the methods executed.
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
        dataSaver();
        System.out.println("Το πρόγραμμα τερματίστηκε επιτυχώς.");
        break;
      default:
      }

    }

  }
/**
 * This method handles user's input.
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
        + "4. Πληροφορίες για τον ιό \n"
        + "5. Ρυθμίσεις \n" + "6. Έξοδος \n" + "Εισάγετε επιλογή [1-6]");

  }
/**
 * This method retrieves all the data from the files.
 */
  private static void dataRetriver() {
    Calendar.eventRetriever();
    dateRetriever();
    Geography.facilitiesRetriever();
    Profile.profilesRetriever();
    Calendar.fillingFourteenDays();
    Geography.casesRetriever();
  }
/**
 * This method saves any data created during the execution of the
 * program after the user chose to terminate it.
 */
  private static void dataSaver() {
    Calendar.eventSaver();
    dateSaver();
    Profile.profilesSaver();
    Geography.casesSaver();
  }
/**
 * This method saves the date the last user singed in.
 */
  private static void dateSaver() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      objectMapper
          .writeValue(new File("src\\main\\resourses\\calendar\\date.json")
              .getAbsoluteFile(), LocalDate.now());
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
/**
 * This method retrieves the date the last user signed in.
 */
  private static void dateRetriever() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      dateLastUserSignedIn = objectMapper
          .readValue(new File("src\\main\\resourses\\calendar\\date.json")
              .getAbsoluteFile(), LocalDate.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }

  /**
   * This method gets the date the last person singed in.
   * @return the last date the last person singed in
   */
  public static LocalDate getDateLastUserSignedIn() {
    return dateLastUserSignedIn;
  }
}
