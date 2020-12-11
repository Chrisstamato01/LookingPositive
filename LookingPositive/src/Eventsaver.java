import java.time.*;
import java.util.Collections;
public class Eventsaver {

	protected static ArraylistofArraylist fourteendays[] = new ArraylistofArraylist[14];
	protected static ArraylistofArraylist today = new ArraylistofArraylist();
	protected static ArraylistofArraylist future = new ArraylistofArraylist();
	protected static ArraylistofArraylist day1 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day2 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day3 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day4 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day5 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day6 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day7 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day8 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day9 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day10 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day11 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day12 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day13 = new ArraylistofArraylist();
	protected static ArraylistofArraylist day14 = new ArraylistofArraylist();
	LocalDate dayplusone ;
	
	//na sviso to localdate today gt to xrisimopoioumne gia ton sxediasmo kanonika sigrinoume tin simerini hmerominia
	public static String addevent(Event ev , int userid , int x) {

	if(x==1) {
		today.eventlist.get(userid).add(ev);
	}else {
		future.eventlist.get(userid).add(ev);
	}
	return "Καταχωρήθηκε η εκδήλωση σας " + ev ;
	}

	public static void deleteexpiredevents(LocalDate newdate , LocalDate olddate) {
		//ΒΡΙΣΚΟΥΜΕ ΤΗΝ ΔΙΑΦΟΡΑ ΜΕΤΑΞΥ ΤΩΝ ΗΜΕΡΟΜΗΝΙΩΝ
		int x = newdate.compareTo(olddate);
		LocalDate replicaolddate ;
	System.out.println(x);
		//ΔΗΜΙΟΘΡΓΙΑ ΒΡΟΓΧΟΥ ΓΙΑ ΤΗΝ ΔΙΑΧΕΙΡΗΣΗ ΔΕΔΟΜΕΝΩΝ ΠΟΥ ΑΠΕΧΟΥΝ ΠΟΛΛΕΣ ΜΕΡΕΣ ΜΕΤΑΞΥ ΤΟΥΣ 
		for(int p = 0 ; p<x ; p++) {
			
		//ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ Ο ΧΡΗΣΤΗΣ ΜΠΑΙΝΕΙ ΚΑΘΕ ΜΕΡΑ
	System.out.println(p);
			
			//ΜΕΤΑΚΙΝΗΣΗ ΟΛΩΝ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ 14DAYS ΜΙΑ ΘΕΣΗ ΠΑΡΑΚΑΤΩ ΚΑΙ ΜΕΤΑΦΟΡΑ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΑΠΟ ΤΟΝ TODAY ΣΤΟΝ 14DAYS[0]
			//ΔΟΚΙΜΑΣΑΜΕ ΑΥΤΗ Η ΔΙΑΧΕΙΡΗΣΗ ΝΑ ΓΙΝΕΤΑΙ ΜΕ ΠΙΝΑΚΑ ΑΛΛΑ ΜΑΣ ΔΗΜΙΥΡΓΟΥΣΕ ΠΟΛΛΑ ΠΡΟΒΛΗΜΑΤΑ ΟΠΩΣ NULLPOINTEREXCEPTION
			//ΑΛΛΑ ΚΑΙ ΠΡΟΒΛΗΜΑΤΑ ΔΙΑΧΕΙΡΗΣΕΙΣ ΤΩΝ ΔΕΔΟΜΕΝΩΝ 
			day14.deleteevent();
			day14.copydoublearralist(day13);
			day13.deleteevent();
			day13.copydoublearralist(day12);
			day12.deleteevent();
			day12.copydoublearralist(day11);
			day11.deleteevent();
			day11.copydoublearralist(day10);
			day10.deleteevent();
			day10.copydoublearralist(day9);
			day9.deleteevent();
			day9.copydoublearralist(day8);
			day8.deleteevent();
			day8.copydoublearralist(day7);
			day7.deleteevent();
			day7.copydoublearralist(day6);
			day6.deleteevent();
			day6.copydoublearralist(day5);
			day5.deleteevent();
			day5.copydoublearralist(day4);
			day4.deleteevent();
			day4.copydoublearralist(day3);
			day3.deleteevent();
			day3.copydoublearralist(day2);
			day2.deleteevent();
			day2.copydoublearralist(day1);
			day1.deleteevent();
			day1.copydoublearralist(today);
			
		
		System.out.println("Beginfourteen cell[0]");
		fourteendays[0].printcheck();
		System.out.println("ENDfourteen cell[0]");
			//ΔΙΑΓΡΑΦΗ ΤΟΥ ΠΕΡΙΕΧΟΜΕΝΟΥ ΤΟΥ TODAY 
			today.deleteevent();

		System.out.println("Begintoday");
		today.printcheck();
		System.out.println("ENDtoday");
			//ΔΙΑΧΕΙΡΗΣΕΙ ΤΩΝ ΗΜΕΡΟΜΙΝΙΩΝ ΜΕΣΩ ΤΟΥ REPLICAOLDDATE
			replicaolddate = olddate.plusDays(p+1);
		System.out.println(replicaolddate);
		
			//ΓΕΜΙΣΜΑ ΤΟΥ TODAY ΜΕ ΤΑ ΑΝΑΝΕΟΜΕΝΑ ΣΤΟΙΧΕΙΑ ΤΗΣ ΕΠΟΜΕΝΗΣ ΜΕΡΑΣ ΠΟΥ ΒΡΙΣΚΟΝΤΑΙ ΣΤΟΝ FUTURE
		System.out.println("filling today");
			for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
				for(int j = 0; j < future.eventlist.get(i).size(); j++) {
					if(replicaolddate.compareTo(future.eventlist.get(i).get(j).getDate())==0) {
						today.eventlist.get(i).add(future.eventlist.get(i).get(j));
						
					}
				}
			}
		System.out.println("end filling today");
			//ΔΙΑΓΡΑΦΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΠΟΥ ΜΠΗΚΑΝ ΣΤΟΝ TODAY ΑΡΑ Η ΗΜΕΡΟΜΗΝΙΑ ΤΟΥΣ ΔΕΝ ΑΝΟΙΚΕΙ ΠΛΕΟΝ ΣΤΟ ΜΕΛΛΟΝ 
		System.out.println("removing future of day");
			for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
				for(int j = future.eventlist.get(i).size()-1; j >= 0; j-- ) {
					if(replicaolddate.compareTo(future.eventlist.get(i).get(j).getDate())==0) {
						System.out.println(future.eventlist.get(i).size()+"before");
						future.eventlist.get(i).remove(j);
						System.out.println(future.eventlist.get(i).size()+"after");
					}
				}
			}
			
		System.out.println("Afterrefilltoday");
		today.printcheck();
		System.out.println("Afterrefilltoday");
	/*}else if(x < 14){
			LocalDate replicaolddate = olddate;
			System.out.println("else");

			for(int i = 13 ; i > x-1 ; i--) {
				fourteendays[i].deleteevent();
				fourteendays[i].copydoublearralist(fourteendays[i-1]);
			}
			for(int i = 0 ; i < x ; i++) {
				fourteendays[i].deleteevent();
			}
			fourteendays[x-1].copydoublearralist(today);
			for(int k = 2 ; k <= x ; k++) {
				for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
					for(int j = 0; j < future.eventlist.get(i).size(); j++) {
						if(olddate.plusDays(1).equals(future.eventlist.get(i).get(j).getDate())) {
							today.eventlist.get(i).add(future.eventlist.get(i).get(j));
							future.eventlist.get(i).remove(j);
						}
					}
					fourteendays[x-k].copydoublearralist(today);
				}
			}
			for(int k = 2 ; k <= x ; k++) {
				for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
					for(int j = future.eventlist.get(i).size()-1; j >= 0; j--) {
						if(replicaolddate.plusDays(1).equals(future.eventlist.get(i).get(j).getDate())) {
							future.eventlist.get(i).remove(j);
						}
					}
				}
			}

			// }else

		
	}*/
		}
}
	}


