import java.time.LocalDate;
import java.util.ArrayList;

public class aeknfoeknf {

	public static void main(String[] args) {
		LocalDate veryoldDate = LocalDate.of(2020, 12, 01);
		LocalDate oldDate = LocalDate.of(2020, 12, 03);
		LocalDate newDate = LocalDate.of(2020, 12, 10);
		ArrayList<Profiles> contactedpeople = new ArrayList<>();
		Profiles katerina = new Profiles("katerina" , 0);
		Profiles elisavet = new Profiles("elisavet" , 1);
		Profiles mpampinos = new Profiles("mpampinos" , 2);
		
		//int x = c.compareTo(k);
		contactedpeople.add(katerina);
		contactedpeople.add(elisavet);
		contactedpeople.add(mpampinos);
		Eventsaver.today.createarraylistofevents(0);
		Eventsaver.today.createarraylistofevents(1);
		Eventsaver.today.createarraylistofevents(2);
		Eventsaver.future.createarraylistofevents(0);
		Eventsaver.future.createarraylistofevents(1);
		Eventsaver.future.createarraylistofevents(2);
		Eventsaver.fourteendays[0] = Eventsaver.day1;
		Eventsaver.fourteendays[1] = Eventsaver.day2;
		Eventsaver.fourteendays[2] = Eventsaver.day3;
		Eventsaver.fourteendays[3] = Eventsaver.day4;
		Eventsaver.fourteendays[4] = Eventsaver.day5;
		Eventsaver.fourteendays[5] = Eventsaver.day6;
		Eventsaver.fourteendays[6] = Eventsaver.day7;
		Eventsaver.fourteendays[7] = Eventsaver.day8;
		Eventsaver.fourteendays[8] = Eventsaver.day9;
		Eventsaver.fourteendays[9] = Eventsaver.day10;
		Eventsaver.fourteendays[10] = Eventsaver.day11;
		Eventsaver.fourteendays[11] = Eventsaver.day12;
		Eventsaver.fourteendays[12] = Eventsaver.day13;
		Eventsaver.fourteendays[13] = Eventsaver.day14;
		Eventsaver.day1.createarraylistofevents(0);
		Eventsaver.day1.createarraylistofevents(1);
		Eventsaver.day1.createarraylistofevents(2);
		Eventsaver.day2.createarraylistofevents(0);
		Eventsaver.day2.createarraylistofevents(1);
		Eventsaver.day2.createarraylistofevents(2);
		Eventsaver.day3.createarraylistofevents(0);
		Eventsaver.day3.createarraylistofevents(1);
		Eventsaver.day3.createarraylistofevents(2);
		Eventsaver.day4.createarraylistofevents(0);
		Eventsaver.day4.createarraylistofevents(1);
		Eventsaver.day4.createarraylistofevents(2);
		Eventsaver.day5.createarraylistofevents(0);
		Eventsaver.day5.createarraylistofevents(1);
		Eventsaver.day5.createarraylistofevents(2);
		Eventsaver.day6.createarraylistofevents(0);
		Eventsaver.day6.createarraylistofevents(1);
		Eventsaver.day6.createarraylistofevents(2);
		Eventsaver.day7.createarraylistofevents(0);
		Eventsaver.day7.createarraylistofevents(1);
		Eventsaver.day7.createarraylistofevents(2);
		Eventsaver.day8.createarraylistofevents(0);
		Eventsaver.day8.createarraylistofevents(1);
		Eventsaver.day8.createarraylistofevents(2);
		Eventsaver.day9.createarraylistofevents(0);
		Eventsaver.day9.createarraylistofevents(1);
		Eventsaver.day9.createarraylistofevents(2);
		Eventsaver.day10.createarraylistofevents(0);
		Eventsaver.day10.createarraylistofevents(1);
		Eventsaver.day10.createarraylistofevents(2);
		Eventsaver.day11.createarraylistofevents(0);
		Eventsaver.day11.createarraylistofevents(1);
		Eventsaver.day11.createarraylistofevents(2);
		Eventsaver.day12.createarraylistofevents(0);
		Eventsaver.day12.createarraylistofevents(1);
		Eventsaver.day12.createarraylistofevents(2);
		Eventsaver.day13.createarraylistofevents(0);
		Eventsaver.day13.createarraylistofevents(1);
		Eventsaver.day13.createarraylistofevents(2);
		Eventsaver.day14.createarraylistofevents(0);
		Eventsaver.day14.createarraylistofevents(1);
		Eventsaver.day14.createarraylistofevents(2);
		
		/*for(int i = 0 ; 13> i ; i++) {
		Eventsaver.fourteendays[i] = new ArraylistofArraylist();
		Eventsaver.fourteendays[i].createarraylistofevents(0);
		Eventsaver.fourteendays[i].createarraylistofevents(1);
		Eventsaver.fourteendays[i].createarraylistofevents(2);
		}*/
		
		Event event1 = new Event(veryoldDate,"karamanlis",contactedpeople);
		Event event2 = new Event(oldDate ,"koula",contactedpeople);
		Event event3 = new Event(newDate,"marina",contactedpeople);
		Event event4 = new Event(LocalDate.of(2020,12,07) , "koulis" , contactedpeople);
		Event event5 = new Event(LocalDate.of(2020,12,06) , "masalia" , contactedpeople);
		
		System.out.println(Eventsaver.addevent(event1, 0 , 1));
		
		System.out.println(Eventsaver.addevent(event2, 0 , 2));
		
		System.out.println(Eventsaver.addevent(event3, 1 , 2));
		
		System.out.println(Eventsaver.addevent(event4, 1 , 2));
		
		System.out.println(Eventsaver.addevent(event5, 2 , 2));
		
		
		
		//Eventsaver.deleteexpiredevents(p,c);
		
		Eventsaver.deleteexpiredevents(LocalDate.of(2020,12,06) ,LocalDate.of(2020, 12, 01));
		
		Eventsaver.deleteexpiredevents(LocalDate.of(2020,12,07) ,LocalDate.of(2020, 12, 06));
		
		Eventsaver.deleteexpiredevents(LocalDate.of(2020,12,11) ,LocalDate.of(2020, 12, 07));
		
		//Eventsaver.deleteexpiredevents(LocalDate.of(2020,12,05) ,LocalDate.of(2020, 12, 04));
		
		//Eventsaver.deleteexpiredevents(k,p);
		//System.out.println(x)
		//Eventsaver.future.deleteevent();
		/*System.out.println("BegintodayMain");
		for(int i = 0 ; i < Eventsaver.today.eventlist.size() ; i++ ) {
			for(int j = 0; j < Eventsaver.today.eventlist.get(i).size(); j++) {
				
				System.out.println(Eventsaver.today.eventlist.get(i).get(j));
				
			}
		}
		System.out.println("EndtodayMain");
		*/
		for(int kol = 0 ; kol < 14 ; kol++) {
			System.out.println("day" + kol);
		System.out.println("start");
			for(int i = 0 ; i < Eventsaver.fourteendays[kol].eventlist.size() ; i++ ) {
				System.out.println("person" + i);
				for(int j = 0; j < Eventsaver.fourteendays[kol].eventlist.get(i).size() ; j++) {
					System.out.println(Eventsaver.fourteendays[kol].eventlist.get(i).get(j));
		
				}}}
		
				}
			
	}
