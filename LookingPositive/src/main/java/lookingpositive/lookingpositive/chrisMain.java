package lookingpositive.lookingpositive;

public class chrisMain {
  public static void main(String[] args) {
//    AddUser.add();
    
    
    Geography.fillTables();
//    System.out.println(Geography.getFacilities());
    for (int i = 0; i < Geography.getFacilitiesSize(); i++) {
      System.out.println(Geography.getFacilitiesLine(i));
    }
  }


}
