package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;

public class chrisMain {
  public static void main(String[] args) {
    
    
    
    Profile.profilesRetriever();
    AddUser.add();
    
    
    
    for (int i = 0; i < Profile.profilesSaveSize(); i++) {
      System.out.println(Profile.profilesSaveLine(i));
    }
  
    Profile.profilesSaver();
    
    //System.out.println(Profile.profilesSaveSize());
  }


}
