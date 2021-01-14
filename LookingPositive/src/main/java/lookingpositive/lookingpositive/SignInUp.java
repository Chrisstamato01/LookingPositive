package lookingpositive.lookingpositive;

import java.util.Scanner;

/**
 * This method is used to implement the user's Sign In and Sign Up.
 */
public final class SignInUp {

  private SignInUp() {

  }

 /**
  * This method handles the user's sing in or register.
  * @return user's id
  */
  public static int login() {
    System.out.println("Εισάγετε email\nΓια εγγραφή εισάγετε 1");
    Scanner scanner = new Scanner(System.in);
    String password = null;
    String email = null;
    boolean flag = true;
    email = scanner.nextLine();
    while (flag) {
      
      
      if (email.equals("1")) {
        AddUser.add();
      } 
        System.out.println("\nΕισάγετε email:");
        email = scanner.nextLine();
        System.out.println("Εισάγετε κωδικό");
        password = scanner.nextLine();
        checkUser(email, password);
        if (checkUser(email, password) == -1) {
          System.out.println(
              "Τα στοιχεία σας δεν αντιστοιχούν σε κάποιο χρήστη.");
          System.out.println("Εισάγετε email/n Για εγγραφή εισάγετε 1");
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
    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      if (email.equals(Profile.profilesSaveLine(i).getEmail())
          && password.equals(Profile.profilesSaveLine(i).getPassword())) {
        id = Profile.profilesSaveLine(i).getUserID();
      }
    }
    return id;
  }

}
