package lookingpositive.lookingpositive;

public class chrisMain {
  public static void main(String[] args) {

    AddUser.add();

    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      System.out.println(Profile.profilesSaveLine(i));
    }
  }


}
