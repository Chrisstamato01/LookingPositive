import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;   

public class AddDelevents {
	public static void addevent() {
		
	}

	public static LocalDate DateInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Εισάγεται ημερομηνία για την εκδήλωση σας (d/m/yyyy).");
		boolean flag = false;
		LocalDate date = null;
		while(flag==false) {
			flag=true;
			String sDate = sc.nextLine();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		try {
			 date = LocalDate.parse(sDate, dateFormat);}
		catch(DateTimeParseException e) {
			System.err.println("AN ERROR OCCURED " + e );
			flag=false;
		}
		catch(Exception e) {
			System.err.println("AN ERROR OCCURED");
			flag=false;}
		LocalDate now = LocalDate.now(); 
		if(now.until(date, ChronoUnit.DAYS)<0) {
			flag=false;
			System.out.println("Η ημερομηνία που εισάγατε ειναι παρελθονιτκή.");
			}
		}
		return date;
	}
}