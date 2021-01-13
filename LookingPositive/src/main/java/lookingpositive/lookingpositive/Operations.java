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

public class Operations {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private static LocalDate dateLastUserSignedIn = LocalDate.of(2021, 02, 12);

  public static void main(String[] args) {
   // dateSaver();// πρεπει να κελιθη την πρωτη φορα του ινσταλλ
    dataRetriver();
    Geography.fillTables();
    if (dateLastUserSignedIn != null) {
      Calendar.deleteExpiredEvents(LocalDate.now(), dateLastUserSignedIn);
    }
    Profile pr1 = new Profile("elisavet", "exarxopoulou", "voula", 44, false,
        "pass1", "papadopoulos@gmail.com");
    Profile pr2 = new Profile("maria", "exarxopoulou", "glyfada", 47, false,
        "pass2", "papadakis@gmail.com");
    run(SignInUp.login());

  }

  public static void run(int userId) {

    boolean execution = true;

    while (execution) {

      menu();

      int menuChoice = menuChoice();

      switch (menuChoice) {

      case 1:
        AddDelEvents.chooseFunction(userId);
        break;

      case 2:

        break;

      case 3:

        break;

      case 4:

        break;

      case 5:

        break;

      case 6:

        break;

      case 7:
        execution = false;
        dataSaver();
        System.out.println("Τερματισμός Προγράμματος...");
        break;

      }

    }

  }

  private static int menuChoice() {

    Scanner sc = new Scanner(System.in);

    int choice = 0;

    while (choice < 1 || choice > 7) {

      try {

        choice = sc.nextInt();

      } catch (InputMismatchException e) {
        System.out.println("Εισάγετε έναν ακέραιο αριθμό.");
        choice = 0;
      } catch (Exception e) {
        choice = 0;
        System.out.println(e);
      }

      if (choice < 1 || choice > 7) {
        System.out.println("Εισάγετε επιλογή [1-7]");
      }
      sc.nextLine();
    }

    return choice;
  }

  private static void menu() {
    System.out.println("------------Μενού Επιλογών------------ \n"
        + "1. Γεγονότα \n" + "2. Υγεία \n" + "3. Γεωγραφική περιγραφή \n"
        + "4. Πληροφορίες για τον ιό \n" + "5. Ειδοποιήσεις \n"
        + "6. Ρυθμίσεις \n" + "7. Έξοδος \n" + "Εισάγετε επιλογή [1-7]");

  }

  private static void dataRetriver() {
    Calendar.eventRetriever();
    dateRetriever();
  }

  private static void dataSaver() {
    Calendar.eventSaver();
    dateSaver();
  }

  private static void dateSaver() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      File date = new File("calendar\\date.json").getAbsoluteFile();
      objectMapper.writeValue(date, LocalDate.now());
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

  private static void dateRetriever() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      File date = new File("calendar\\date.json").getAbsoluteFile();
      dateLastUserSignedIn = objectMapper.readValue(date, LocalDate.class);
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

  public static LocalDate getDateLastUserSignedIn() {
    return dateLastUserSignedIn;
  }
}
