package LookingPositive.LookingPositive;
import java.util.*;

public class ArraylistofArraylist {
	
	protected ArrayList<ArrayList<Event> > eventlist =  new ArrayList<ArrayList<Event> >();
	//ΔΗΜΙΟΥΡΓΕΙ ΤΙΣ ΕΠΙΜΕΡΟΥΣ ΛΙΣΤΕΣ ΠΟΥ ΑΝΤΙΣΤΟΙΧΟΥΝ ΣΤΟΝ ΚΑΘΕ ΧΡΗΣΤΗ 
	public void createarraylistofevents() {
		
		ArrayList<Event> usereventlist = new ArrayList<Event>();
		eventlist.add(usereventlist);
		
	
	}
	//ΑΝΤΙΓΡΑΦΗ ΜΙΑΣ ΔΙΣΔΙΑΣΤΑΤΗΣ ΛΙΣΤΑΣ ΣΤΟ ΑΝΤΙΚΕΙΜΕΝΟ
	public void copydoublearralist(ArraylistofArraylist tocopy ) {
		for (int i = 0 ; i < tocopy.eventlist.size() ; i++) {
			for(int j = 0; j < tocopy.eventlist.get(i).size(); j++) {
				eventlist.get(i).add(tocopy.eventlist.get(i).get(j));
			}
		}
	}
	//ΔΙΑΓΡΑΦΗ ΤΟΥ ΠΕΡΙΕΧΟΜΕΝΟΥ ΜΙΑΣ ΔΙΣΔΙΑΣΤΑΤΗΣ ΛΙΣΤΑΣ
	public void deleteevent () {
		for (int i = 0 ; i < eventlist.size() ; i++) {
			for ( int j=eventlist.get(i).size()-1 ; j >= 0; j--) {
				eventlist.get(i).remove(j);
			}
		}
	}
	//ΜΕΘΟΔΟΣ ΓΙΑ ΕΜΦΑΝΗΣΗ ΣΤΟΙΧΕΙΩΝ
	public void printcheck() {
		for (int i = 0 ; i < eventlist.size() ; i++ ) {
			for(int j = 0; j < eventlist.get(i).size(); j++) {
					System.out.println(eventlist.get(i).get(j));
				}
			}
		}
	}

