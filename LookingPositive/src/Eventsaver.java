import java.time.*;
public class Eventsaver {

protected static ArraylistofArraylist fourteendays[] = new ArraylistofArraylist[14];
protected static ArraylistofArraylist today = new ArraylistofArraylist();
	protected static ArraylistofArraylist future = new ArraylistofArraylist();
	LocalDate dayplusone ;
	//na sviso to localdate today gt to xrisimopoioumne gia ton sxediasmo kanonika sigrinoume tin simerini hmerominia
	public static String addevent(Event ev , int userid , LocalDate today) {

	if(LocalDate.of(2020, 12, 01) .compareTo(LocalDate.of(2020, 12, 01))==0) {
		today.eventlist.get(userid).add(ev);
	}else {
		future.eventlist.get(userid).add(ev);
	}
	return "Καταχωρήθηκε η εκδήλωση σας " + ev ;
	}

	public static void deleteexpiredevents(LocalDate newdate , LocalDate olddate) {
	int x = newdate.compareTo(olddate);
	System.out.println(x);
	if(x == 1) {

	for(int i = 13 ; i > 0 ; i--) {
	ArraylistofArraylist temp =  fourteendays[i-1];
	fourteendays[i] = temp;}
	fourteendays[0] = today;

	System.out.println("Beginfourteen");
	for(int i = 0 ; i < Eventsaver.fourteendays[0].eventlist.size() ; i++ ) {
	for(int j = 0; j < Eventsaver.fourteendays[0].eventlist.get(i).size(); j++) {

	System.out.println(Eventsaver.fourteendays[0].eventlist.get(i).get(j));
	}
	}
	System.out.println("ENDfourteen");


	today.deleteevent();

	System.out.println("Begintoday");
	for(int i = 0 ; i < Eventsaver.today.eventlist.size() ; i++ ) {
	for(int j = 0; j < Eventsaver.today.eventlist.get(i).size(); j++) {

	System.out.println(Eventsaver.today.eventlist.get(i).get(j));
	}
	}
	System.out.println("ENDtoday");


	for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
	for(int j = 0; j < future.eventlist.get(i).size(); j++) {
	if(newdate.compareTo(future.eventlist.get(i).get(j).getDate()) == 0) {
	today.eventlist.get(i).add(future.eventlist.get(i).get(j));
	future.eventlist.get(i).remove(j);
	}else {
	break;
	}
	}
	}

	System.out.println("Afterrefilltoday");
	for(int i = 0 ; i < Eventsaver.today.eventlist.size() ; i++ ) {
	for(int j = 0; j < Eventsaver.today.eventlist.get(i).size(); j++) {

	System.out.println(Eventsaver.today.eventlist.get(i).get(j));
	}
	}
	System.out.println("Afterrefilltoday");




	}else if(x < 14){

	System.out.println("else");

	for(int i = 13 ; i > x-1 ; i--) {
	ArraylistofArraylist temp =  fourteendays[i-1];
	fourteendays[i] = temp;
	}
	for(int i = 0 ; i < x ; i++) {
	fourteendays[i].deleteevent();
	}
	fourteendays[x] = today;
	for(int k = 1 ; k < x ; k++) {
	for(int i = 0 ; i < future.eventlist.size() ; i++ ) {
	for(int j = 0; j < future.eventlist.get(i).size(); j++) {
	if(newdate.plusDays(k) == future.eventlist.get(i).get(j).getDate()) {
	today.eventlist.get(i).add(future.eventlist.get(i).get(j));
	future.eventlist.get(i).remove(j);
	}
	}
	fourteendays[x-k]=today;
	}
	}
	// }else

	}
	}

	}

