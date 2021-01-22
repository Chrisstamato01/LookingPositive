package lookingpositive.lookingpositive;

import java.util.Scanner;

/**
 * This class is used to inform the user about Covid 19.
 */
public final class Information {

  /**
   * Case 3.
   */
  private static final int CASE_THREE = 3;
  /**
   * Case 4.
   */
  private static final int CASE_FOUR = 4;
  /**
   * Case 5.
   */
  private static final int CASE_FIVE = 5;
  /**
   * Case 6.
   */
  private static final int CASE_SIX = 6;

  /**
   * Information default constructor.
   */
  private Information() {

  }

  /**
   * Information method.
   */
  public static void infoMenu() {

    Scanner sc = new Scanner(System.in);
    int g = 0;
    while (g != -1) {
      System.out.println("FAQs: ");
      System.out.println("1.What is Covid? \r\n" + "2.Safety measures\r\n"
          + "3.Info 13033 in case of lockdown \r\n"
          + "4.Mask's right usage [Which masks are allowed?]\r\n"
          + "5.Fines\r\n" + "6.Back");
      System.out.println("Chose a question corresponding to a number(1-6).:");
      g = sc.nextInt();

      switch (g) {
      case 1:
        System.out.println(
            "The disease of coronavirus 2019 "
                + "(Corona virus disease 2019, COVID-19),"
                + " also known as accute respiratory disease 2019-nCoV, "
                + "is an infactory disease that is caused"
                + " by coronavirus SARS-CoV-2. "
                + "The virus first appeared in Wuhan,"
                + " China in the end of 2019.");
        break;
      case 2:
        System.out
            .println("How to keep yourself safe:\r\n"
                + "1.Avoid contact with patients that"
                + " show symptoms of the virus.\r\n"
                + "2.Obey the personal health measures, "
                + "such as washing you hands, "
                + "avoid handshakes and touching your face with your hands.\r\n"
                + "3.In case you show symptoms of the virus, avoid "
                + "contact with other people and take the test.");
        break;
      case CASE_THREE:
        System.out.println(
            "You can send a text SMS to the number "
                + "13033 " + "charge free \r\n"
                + "The SMS must be of format:\r\n"
                + "X [Space] fullname and residence adress \r\n"
                + "where X indicates the reason of exit with "
                + "the number 1, 2, 3, 4, 5, 6 that "
                + "corresponds to the reaons below:\r\n"
                + "where Χ indicates the reason "
                + "of exit with 1, 2, 3, 4, 5, 6 that "
                + "corresponds to the reaons below:\r\n"
                + "1.Transition to a pharmacy or visit to a doctor, "
                + "after having booked an appointment.\r\n"
                + "2.Transition to a store for first need goods "
                + "(σούπερ μάρκετ, μίνι μάρκετ), "
                + "where delivery is not applicable.\r\n"
                + "3.Transition to a bank, in case that "
                + "online transaction is not supported.\r\n"
                + "4.Transition to help people in need or "
                + "escort underage students to/from school.\r\n"
                + "5.Transition to a funeral under "
                + "the terms that the law states "
                + "or transition of separated parents"
                + " that is mantatory to ensure "
                + "communication between them and their children"
                + "according to existing provisions.\r\n "
                + "6.Physical exercise outdoors or walking"
                + " a pet alone or with a second "
                + "person, abbiding by the safety distance of 1,5 meter.\r\n"
                + "You will receive the response:\r\n"
                + "Transition [Space] X [Space] fullname "
                + "home adress");
        break;
      case CASE_FOUR:
        System.out
            .println("Allowed masks are the surgical, the "
                + "approved non surgical and the high protection masks."
                + "Masks should be used in every indoor space"
                + "and in crowdedn places(ex. bus stops)"
                + "The mask should cover your mouth and nose in every case.");
        break;
      case CASE_FIVE:
        System.out.println("The fine for not using a mask as well as not "
            + "following the transition rules comes to 300 euros.");
        break;
      case CASE_SIX:
        g = -1;
        break;
      default:
        System.out.println("Invalid selection. Try again.");
        break;
      }
    }
  }
}
