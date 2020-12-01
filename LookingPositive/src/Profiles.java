
public class Profiles {		
	
	private String firstName, lastName, mobilePhone, residenceRegion, gender, dateOfInfection;
	private int age ,userId;
	private boolean isSusceptible;
	private String[] closeContactWith;
	private static int counterforus = 0 ;
	public Profiles(String firstName , int userId ) { 
		
		
			this.firstName = firstName;
			this.userId = userId ; }
	
	
	/*public void modelCase(String firstName, String lastName, String mobilePhone, 
					 String residenceRegion, String userID, String gender, 
					 String dateOfInfection, int age, boolean isSusceptible, String[]closeContactWith) {
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

	}*/

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public String getMobilePhone() { return mobilePhone; }

	public String getResidenceRegion() { return residenceRegion; }

	public int getUserID() { return userId; }

	public String getGender() { return gender; }

	public String getDateOfInfection() { return dateOfInfection; }

	public int getAge() { return age; }

	public boolean isSusceptible() { return isSusceptible; }

	public String[] getCloseContactWith() { return closeContactWith; }

}
