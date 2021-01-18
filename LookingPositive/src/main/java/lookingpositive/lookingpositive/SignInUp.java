package lookingpositive.lookingpositive;

import java.util.Scanner;

/**
 * This method is used to implement the user's Sign In and Sign Up.
 */
public final class SignInUp {
/**
 * This method is private Default constructor.
 */
  private SignInUp() {
  //This class can not be initialized.
  }

 /**
  * This method handles the user's sing in or register.
  * @return user's id
  */
  public static int login() {
    System.out.println("Εισάγετε email ή\nΓια εγγραφή εισάγετε 1");
    Scanner scanner = new Scanner(System.in);
    String password = null;
    String email = null;
    boolean flag = true;
    email = scanner.nextLine();
    while (flag) {
      if (email.equals("1")) {
        AddUser.add();
        System.out.println("Εισάγετε τα στοιχεία με τα οποία εγγραφήκατε.");
      }
        System.out.println("\nΕισάγετε email:");
        email = scanner.nextLine();
        System.out.println("Εισάγετε κωδικό");
        password = scanner.nextLine();
        checkUser(email, password);
        if (checkUser(email, password) == -1) {
          System.out.println(
              "Τα στοιχεία σας δεν αντιστοιχούν σε κάποιο χρήστη.");
          System.out.println("Εισάγετε email\n Για εγγραφή εισάγετε 1");
        } else {
          flag = false;
        }
      }
    return checkUser(email, password);
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
    for (int i = 0; i < Profile.profilesSize(); i++) {
      if (email.equals(Profile.profilesLine(i).getEmail())
          && password.equals(Profile.profilesLine(i).getPassword())) {
        id = Profile.profilesLine(i).getUserID();
      }
    }
    return id;
  }

}
