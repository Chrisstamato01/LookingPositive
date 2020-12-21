import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Tracking {
private ArrayList<Profiles> contactstoinform = new ArrayList<Profiles>();
public  void track(Profiles a ) { //το α είναι το τρέχων αντικείμενο
	for (int k = 0 ; Eventsaver.fourteendays.length < 14; k++ ) {
		for (int i = 0; i < Eventsaver.fourteendays[k].eventlist.size(); i++) {
			if ( a.getUserID() == i) {
			for (int j = 0; j < Eventsaver.fourteendays[k].eventlist.get(i).size(); j ++) {
				for (int l = 0; l< Eventsaver.fourteendays[k].eventlist.get(i).get(j).size(); l++) {
					contactstoinform.add(Eventsaver.fourteendays[k].eventlist.get(i).profiles.get(l).getemail();
				}
			}
		}
		}
	}
}

public <Profiles> ArrayList<Profiles> removeDuplicates(ArrayList<Profiles> list) {
Set<Profiles> set = new LinkedHashSet<>();
set.addAll(list);
list.clear();
list.addAll(set);
return list;

}
public ArrayList<Profiles> newContacts = removeDuplicates(contactstoinform);
}
