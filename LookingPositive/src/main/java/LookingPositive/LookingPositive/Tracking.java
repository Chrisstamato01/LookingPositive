package LookingPositive.LookingPositive;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
public class Tracking {
	
	private static ArrayList<String> contactstoinform = new ArrayList<String>();
	/**
	 * this method tracks
	 * @param userID case ID
	 */
	public static void track(int userID) {
		for (int k = 0; Eventsaver.fourteendays.length < 14; k++) {
			for (int j = 0; j < Eventsaver.fourteendays[k].eventlist.get(userID).size(); j++) {
				for (int l = 0; l < Eventsaver.fourteendays[k].eventlist.get(userID).get(j).getProfiles().size(); l++) {
					contactstoinform.add(Eventsaver.fourteendays[k].eventlist.get(userID).get(j).getProfiles().get(l).getEmail());
				}
			}
		}
		Tracking.removeDuplicates(contactstoinform);
		Mail.email(contactstoinform);
	}
    
	/**
	 * this method removes duplicates
	 * @param <String> contains emails
	 * @param list contains unique emails
	 * @return unique emails
	 */
	public static <String> ArrayList<String> removeDuplicates(ArrayList<String> list) {
		Set<String> set = new LinkedHashSet<String>();
		set.addAll(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
