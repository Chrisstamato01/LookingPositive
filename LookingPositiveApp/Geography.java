//import java.util.Scanner;

public class Geography {
	public String type; //π.χ. Νοσοκομειο, φαραμακειο, σουπερ μαρκετ κτλ.
	public String name; 
	public String municipality;
	public int count = 0;

	public Geography(String type, String name, String municipality) {
		this.type = type;
		this.name = name;
		this.municipality = municipality;
	}

}
