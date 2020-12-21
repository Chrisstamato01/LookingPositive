package idk;
import java.util.ArrayList;

<<<<<<< HEAD:LookingPositive/src/Profiles.java
public class Profiles {		
	
	private String firstName, lastName, mobilePhone, residenceRegion, gender, dateOfInfection,email;
	private int age,userID;
	private boolean isSusceptible;
	private String[] closeContactWith;
	
	public void modelCase(String firstName, String lastName, String mobilePhone, 
					 String residenceRegion, int userID, String gender,String email, 
					 String dateOfInfection, int age, boolean isSusceptible, String[]closeContactWith) {
=======
public class Profile {
	private String firstName, lastName, mobilePhone, residenceRegion, gender, dateOfInfection;
	private int age, userID, password;
	private boolean isSusceptible;
	private String[] closeContactWith;
	
	protected static ArrayList<Profile> profilesSave = new ArrayList<>();
	
	public Profile(String firstName, String lastName, String mobilePhone, 
					String residenceRegion, int userID, String gender, 
					String dateOfInfection, int age, boolean isSusceptible, 
					int password) {

>>>>>>> 98327d9d9896e80629eba6085c368bd3a10b39a5:LookingPositive/idk/src/idk/Profile.java
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobilePhone = mobilePhone;
		this.residenceRegion = residenceRegion;
		this.userID = userID;
		this.gender = gender;
		this.dateOfInfection = dateOfInfection;
		this.age = age;
		this.isSusceptible = isSusceptible;
		this.closeContactWith = closeContactWith;
<<<<<<< HEAD:LookingPositive/src/Profiles.java
		this.email = email;
=======
		this.password = password;
		profilesSave.add(this);
//		createarraylistofevents();

>>>>>>> 98327d9d9896e80629eba6085c368bd3a10b39a5:LookingPositive/idk/src/idk/Profile.java
	}
	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public String getMobilePhone() { return mobilePhone; }

	public String getResidenceRegion() { return residenceRegion; }

	public int getUserID() { return userID; }

	public String getGender() { return gender; }

	public String getDateOfInfection() { return dateOfInfection; }

	public int getAge() { return age; }

	public boolean isSusceptible() { return isSusceptible; }

	public String[] getCloseContactWith() { return closeContactWith; }
<<<<<<< HEAD:LookingPositive/src/Profiles.java
	public String getEmail() {
		return email;
	}
	
=======


>>>>>>> 98327d9d9896e80629eba6085c368bd3a10b39a5:LookingPositive/idk/src/idk/Profile.java
}




