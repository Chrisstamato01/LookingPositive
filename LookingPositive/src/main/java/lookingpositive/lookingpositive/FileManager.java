package lookingpositive.lookingpositive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 *
 * This class handles the files.
 *
 */
public final class FileManager {
  /**
   * This is the private default constructor.
   */
  private FileManager() {
    // This class can not be initialized.
  }

  /**
   * This method converts an InputStream to a String.
   *
   * @param path name of the file
   * @return the file in String form
   */
  protected static String streamToString(final String path) {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    StringBuffer sb = new StringBuffer();
    try {
      InputStream in = cl.getResourceAsStream(path);
      // Creating a Scanner object
      Scanner sc = new Scanner(in);
      // Reading line by line from scanner to StringBuffer

      while (sc.hasNext()) {
        sb.append(sc.nextLine());
      }

    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
    // System.out.print(sb.toString());
    return sb.toString();
  }

  /**
   * This method creates a Directory in which our data is stored.
   *
   */
  public static void makeDirectory() {
    try {
      String path = getHomePath();

      String fileSeparator = System.getProperty("file.separator");
      String newDir = path + fileSeparator + "LookingPositiveAppData"
          + fileSeparator;

      File file = new File(newDir);
      file.mkdir();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method returns the path of our users home directory.
   *
   * @return the path as String
   *
   */
  public static String getHomePath() {

    String homedir = System.getProperty("user.home");
    homedir = homedir.replace("\\", "/");
    return homedir;
  }

  /**
   *
   * This method retrieves the date the last user signed in.
   */
  protected static void dateRetriever() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      Operations.setDateLastUserSignedIn(objectMapper
          .readValue(FileManager.streamToString("date.json"), LocalDate.class));
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
   * This method saves the date user singed in in a JSON file.
   */
  private static void dateSaver() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      objectMapper.writeValue(
          new File(getHomePath() + "/LookingPositiveAppData/date.json"),
          LocalDate.now());
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
   * This method reads a date from a JSON file.
   */
  private static void dateReader() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      Operations.setDateLastUserSignedIn(objectMapper.readValue(
          new File("LookingPositiveAppData/date.json").getAbsoluteFile(),
          new TypeReference<LocalDate>() {
          }));
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
   * This method retrieves all the data from the files.
   */
  public static void dataRetriever() {
    Calendar.eventRetriever();
    dateRetriever();
    Geography.facilitiesRetriever();
    Profile.profilesRetriever();
    Calendar.fillingFourteenDays();
    Geography.casesRetriever();
  }

  /**
   * This method saves any data created during the execution of the program
   * after the user chose to terminate it.
   */
  public static void dataSaver() {
    Calendar.eventSaver();
    dateSaver();
    Profile.profilesSaver();
    Geography.casesSaver();
  }

  /**
   * This method is used for updating the files.
   */
  public static void dataReader() {
    dateReader();
    Calendar.eventReader();
    Geography.facilitiesRetriever();
    Geography.casesReader();
    Profile.profilesReader();
    Calendar.fillingFourteenDays();
  }

  /**
   * This method show if the data from the archive has been retrieved.
   *
   * @return true if the data has been installed.
   * @throws FileNotFoundException if the file is not found
   * @throws IOException           if a problem occurs
   */
  public static boolean booleanReader()
      throws FileNotFoundException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    return (objectMapper.readValue(
        new File(getHomePath() + "LookingPositiveAppData/dataRetrieved.json"),
        Boolean.class));
  }

  /**
   * This method changes the dataRetrieved file to show that the data has been
   * retrieved.
   */
  public static void booleanWriter() {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      objectMapper.writeValue(
          new File(
              getHomePath() + "/LookingPositiveAppData/dataRetrieved.json"),
          true);
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
}
