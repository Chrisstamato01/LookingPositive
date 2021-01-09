package lookingpositive.lookingpositive;

import java.util.ArrayList;

/**
 * This class is the model for users' profiles. It includes the private
 * variables that make up the object, two constructors and getters.
 *
 */
public class Profile {
  /**
   * User's first name.
   */
  private String firstName;
  /**
   * User's last name.
   */
  private String lastName;
  /**
   * User's residence region.
   */
  private String residenceRegion;
  /**
   * User's email.
   */
  private String email;
  /**
   * User's password.
   */
  private String password;
  /**
   * User's mobile phone.
   */
  private String mobilePhone;
  /**
   * User's age.
   */
  private int age;
  /**
   * User's ID.
   */
  private int userID;
  /**
   * Susceptible or not.
   */
  private boolean isSusceptible;
  /**
   * Counter variable.
   */
  private static int counter = 0;       //was public
  /**
   * Array list in which profiles are saved.
   */
  private static ArrayList<Profile> profilesSave = new ArrayList<Profile>();
  //was protected

  /**
   * This constructor is used to create objects of people who are not users of
   * the app, in case that a user declares that they were in contact with them.
   * It keeps their first and last names.
   *
   * @param name user's first name
   * @param surname  user's last name
   */
  public Profile(final String name, final String surname) {
    firstName = name;
    lastName = surname;
    email = null;
  }

  /**
   * This constructor creates the profiles using the private variables.
   *
   * @param name     is the user's first name
   * @param surname      is the user's last name
   * @param residenceReg is the user's residence region
   * @param usersAge     is the user's age
   * @param isSus      if the user belongs to high risk groups
   * @param pass       is the user's password
   * @param mail       is the user's email
   */
  public Profile(final String name, final String surname,
      final String residenceReg, final int usersAge, final boolean isSus,
      final String pass, final String mail) {

    firstName = name;
    lastName = surname;
    residenceRegion = residenceReg;
    userID = counter;
    counter++;
    age = usersAge;
    isSusceptible = isSus;
    password = pass;
    email = mail;
    profilesSave.add(this);

    Calendar.daysInitializer();

  }
  /**
   * Returns first name.
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * Returns last name.
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * Returns mobile number.
   *
   * @return mobile number
   */
  public String getMobilePhone() {
    return mobilePhone;
  }
  /**
   * Returns residence region.
   *
   * @return residence region
   */
  public String getResidenceRegion() {
    return residenceRegion;
  }
  /**
   * Returns user ID.
   *
   * @return user ID
   */
  public int getUserID() {
    return userID;
  }
  /**
   * Returns age.
   *
   * @return age
   */
  public int getAge() {
    return age;
  }
  /**
   * Returns whether susceptible or not.
   *
   * @return whether susceptible or not
   */
  public boolean isSusceptible() {
    return isSusceptible;
  }
  /**
   * Returns user's email.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }
  /**
   * Returns user's password.
   *
   * @return password
   */
  public String getPassword() {
    return password;
  }
  /**
   * Returns the line from profileSave.
   * @param i
   * @return profile line
   */
  public static Profile profilesSaveLine(final int i) {
    //na eksigisw sholio (param)
    return profilesSave.get(i);
  }
  /**
   * Returns the size of profileSave.
   * @return profile size
   */
  public static int profilesSaveSize() {
    return profilesSave.size();
  }
  /**
   * Returns profilesSave.
   * @return ArrayList
   */
  public static ArrayList<Profile> getProfilesSave() {
    return profilesSave;
  }
}
