import java.util.ArrayList;

public class ArraylistofArraylist {
	
	protected ArrayList<ArrayList<Event> > eventlist =  
            new ArrayList<ArrayList<Event> >();
	
	public void createarraylistofevents(int userid) {
		
		ArrayList<Event> usereventlist = new ArrayList<>();
		eventlist.add(usereventlist);
	}
	
	public void deleteevent () {
		for (int i = 0 ; i < eventlist.size() ; i++) {
			for ( int j=0 ; j < eventlist.get(i).size(); j++) {
				eventlist.get(i).set(j, null);
			}
		}
	}
	//@Override
	//public String toString() {
		
	//}


}