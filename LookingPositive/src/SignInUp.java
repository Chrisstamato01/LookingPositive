import java.util.Scanner;

public class SignInUp {
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
			checkUser(email,password);
			if(checkUser(email,password) == -1) {
				while(checkUser(email,password) == -1) {
					System.out.println("Τα στοιχεία σας δεν αντιστοιχούν.");
					System.out.println("Εισάγετε email/n Για εγγραφή εισάγετε 1");
					email = sc.next();
					if (email.equals("1")) {
						AddUser.add();
					} else {
						password = sc.next();
						checkUser(email,password);
					}
				}				
			}
		}
		Operations.run(checkUser(email,password));
	}
	
	public static int checkUser(String email, String password) {
		int id = -1;
		for(int i = 0; i < Profile.profilesSave.size(); i ++) {
			if (email.equals(Profile.profilesSave.get(i).getEmail())&&password.equals(Profile.profilesSave.get(i).getPassword())) {
				id = Profile.profilesSave.get(i).getUserID();
			}
		}
		return id;
	}

}
