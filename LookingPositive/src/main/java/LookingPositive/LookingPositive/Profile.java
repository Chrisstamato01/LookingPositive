package LookingPositive.LookingPositive;

import java.util.ArrayList;

public class Profile {
  private String firstName, lastName, residenceRegion,
      /* gender, */ /* dateOfInfection, */ email, password;
  private int age, userID, mobilePhone;
  private boolean isSusceptible;
  private String[] closeContactWith;
  public static int counter = 0;

  protected static ArrayList<Profile> profilesSave = new ArrayList<Profile>();

  public Profile(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Profile(String firstName, String lastName, int mobilePhone,
      String residenceRegion, int userID, /* String gender, */
      /* String dateOfInfection, */ int age, boolean isSusceptible,
      String password, String email) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.mobilePhone = mobilePhone;
    this.residenceRegion = residenceRegion;
    this.userID = counter;
    counter++;
    /* this.gender = gender; */
    /* this.dateOfInfection = dateOfInfection; */
    this.age = age;
    this.isSusceptible = isSusceptible;
    this.closeContactWith = closeContactWith;
    this.password = password;
    this.email = email;
    profilesSave.add(this);
//		createarraylistofevents();
    Eventsaver.today.createarraylistofevents();

    Eventsaver.future.createarraylistofevents();

    Eventsaver.day1.createarraylistofevents();

    Eventsaver.day2.createarraylistofevents();

    Eventsaver.day3.createarraylistofevents();

    Eventsaver.day4.createarraylistofevents();

    Eventsaver.day5.createarraylistofevents();

    Eventsaver.day6.createarraylistofevents();

    Eventsaver.day7.createarraylistofevents();

    Eventsaver.day8.createarraylistofevents();

    Eventsaver.day9.createarraylistofevents();

    Eventsaver.day10.createarraylistofevents();

    Eventsaver.day11.createarraylistofevents();

    Eventsaver.day12.createarraylistofevents();

    Eventsaver.day13.createarraylistofevents();

    Eventsaver.day14.createarraylistofevents();

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getMobilePhone() {
    return mobilePhone;
  }

  public String getResidenceRegion() {
    return residenceRegion;
  }

  public int getUserID() {
    return userID;
  }

  /* public String getGender() { return gender; } */

  /* public String getDateOfInfection() { return dateOfInfection; } */

  public int getAge() {
    return age;
  }

  public boolean isSusceptible() {
    return isSusceptible;
  }

  public String[] getCloseContactWith() {
    return closeContactWith;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

}
