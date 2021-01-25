package lookingpositive.lookingpositive;

import java.util.Scanner;

/**
 * This class regulates the user's Sign In and Sign Up.
 */
public final class SignInUp {
  /**
   * This method is the private Default constructor.
   */
  private SignInUp() {
    // This class can not be initialized.
  }

  /**
   * This method handles the user's sing in or registration.
   * @return user's id
   */
  public static int login() {

    Scanner scanner = new Scanner(System.in);
    String password = null;
    String email = null;
    boolean flag = true;

    while (flag) {
      System.out.println("Enter email or to Sign Up enter 1.");
      email = scanner.nextLine();
      if (email.equals("1")) {
        AddUser.add();
        System.out.println("Enter the data with which you signed up.");
      } else {
      System.out.println("Enter password.");
      password = scanner.nextLine();
      checkUser(email, password);
      if (checkUser(email, password) == -1) {
        System.out
            .println("Your data do not correspond to a user.");
      } else {
        flag = false;
      }
    }
    }
    return checkUser(email, password);
  }

  /**
   * This method checks if the user already exists.
   *
   * @param email the User's email
   * @param password the User's password
   * @return the user's validated id
   */
  public static int checkUser(final String email, final String password) {
    int id = -1;
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (email.equals(Profile.profilesLine(i).getEmail())
          && password.equals(Profile.profilesLine(i).getPassword())) {
        id = Profile.profilesLine(i).getUserID();
      }
    }
    return id;
  }

}
