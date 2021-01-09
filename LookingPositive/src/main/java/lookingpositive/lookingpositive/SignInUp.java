package lookingpositive.lookingpositive;

import java.util.Scanner;

/**
 * This method is used to implement the user's Sign In and Sign Up.
 */
public final class SignInUp {

  private SignInUp() {

  }

  /**
   * User Sign Up method.
   */
  public static void login() {
    System.out.println("Εισάγετε email/n Για εγγραφή εισάγετε 1");
    Scanner sc = new Scanner(System.in);
    String email = sc.next();
    String password = null;
    if (email.equals("1")) {
      AddUser.add();
    } else {
      System.out.println("Εισάγετε κωδικό");
      password = sc.next();
      checkUser(email, password);
      if (checkUser(email, password) == -1) {
        while (checkUser(email, password) == -1) {
          System.out.println("Τα στοιχεία σας δεν αντιστοιχούν.");
          System.out.println("Εισάγετε email/n Για εγγραφή εισάγετε 1");
          email = sc.next();
          if (email.equals("1")) {
            AddUser.add();
          } else {
            password = sc.next();
            checkUser(email, password);
          }
        }
      }
    }
    Operations.run(checkUser(email, password));
  }

  /**
   * Checks if the user already exists.
   *
   * @param email    is User's email
   * @param password is User's password
   * @return integer
   */
  public static int checkUser(final String email, final String password) {
    int id = -1;
    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      if (email.equals(Profile.profilesSaveLine(i).getEmail())
          && password.equals(Profile.profilesSaveLine(i).getPassword())) {
        id = Profile.profilesSaveLine(i).getUserID();
      }
    }
    return id;
  }

}
