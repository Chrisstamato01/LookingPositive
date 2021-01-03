package LookingPositive.LookingPositive;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class aeknfoeknf {

  public static void main(String[] args) {
    LocalDate veryoldDate = LocalDate.of(2020, 9, 25);
    LocalDate oldDate = LocalDate.of(2020, 8, 14);
    LocalDate newDate = LocalDate.of(2020, 12, 10);
    ArrayList<Profile> contactedpeople = new ArrayList<>();
    Profile katerina = new Profile("katerina", "papadopoulou", "6985078444",
        "glyafada", 0, "f", "oxi", 34, false, 0, "papadopoulos@gmail.com");
    Profile elisavet = new Profile("elisavet", "exarxopoulou", "6985078422",
        "voula", 1, "f", "oxi", 44, false, 1, "papadopoulos@gmail.com");
    Profile mpampinos = new Profile("mpampinos", "mpazndekas", "6985078434",
        "alimos", 2, "m", "oxi", 55, false, 2, "papadopoulos@gmail.com");

    // int x = c.compareTo(k);
    contactedpeople.add(katerina);
    contactedpeople.add(elisavet);
    contactedpeople.add(mpampinos);
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

    /*
     * for(int i = 0 ; 13> i ; i++) { Eventsaver.fourteendays[i] = new
     * ArraylistofArraylist();
     * Eventsaver.fourteendays[i].createarraylistofevents(0);
     * Eventsaver.fourteendays[i].createarraylistofevents(1);
     * Eventsaver.fourteendays[i].createarraylistofevents(2); }
     */

    Event event1 = new Event(veryoldDate, "karamanlis", contactedpeople);
    Event event2 = new Event(oldDate, "koula", contactedpeople);
    Event event3 = new Event(newDate, "marina", contactedpeople);
    Event event4 = new Event(LocalDate.of(2020, 12, 07), "koulis",
        contactedpeople);
    Event event5 = new Event(LocalDate.of(2020, 12, 06), "masalia",
        contactedpeople);

    System.out.println(Eventsaver.addevent(event1, 0, 1));

    System.out.println(Eventsaver.addevent(event2, 0, 2));

    System.out.println(Eventsaver.addevent(event3, 1, 2));

    System.out.println(Eventsaver.addevent(event4, 1, 2));

    System.out.println(Eventsaver.addevent(event5, 2, 2));

    // Eventsaver.deleteexpiredevents(p,c);

    Eventsaver.deleteexpiredevents(LocalDate.of(2020, 12, 06),
        LocalDate.of(2020, 11, 25));

    Eventsaver.deleteexpiredevents(LocalDate.of(2020, 12, 07),
        LocalDate.of(2020, 12, 06));

    Eventsaver.deleteexpiredevents(LocalDate.of(2020, 12, 14),
        LocalDate.of(2020, 12, 07));

    // Eventsaver.deleteexpiredevents(LocalDate.of(2020,12,05)
    // ,LocalDate.of(2020, 12, 04));

    // Eventsaver.deleteexpiredevents(k,p);
    // System.out.println(x)
    // Eventsaver.future.deleteevent();
    /*
     * System.out.println("BegintodayMain"); for(int i = 0 ; i <
     * Eventsaver.today.eventlist.size() ; i++ ) { for(int j = 0; j <
     * Eventsaver.today.eventlist.get(i).size(); j++) {
     * 
     * System.out.println(Eventsaver.today.eventlist.get(i).get(j));
     * 
     * } } System.out.println("EndtodayMain");
     */
    for (int kol = 0; kol < 14; kol++) {
      System.out.println("day" + kol);
      System.out.println("start");
      for (int i = 0; i < Eventsaver.fourteendays[kol].eventlist.size(); i++) {
        System.out.println("person" + i);
        for (int j = 0; j < Eventsaver.fourteendays[kol].eventlist.get(i)
            .size(); j++) {
          System.out
              .println(Eventsaver.fourteendays[kol].eventlist.get(i).get(j));

        }
      }
    }
    System.out.println(veryoldDate.until(oldDate, ChronoUnit.DAYS));
    System.out.println(LocalDate.of(2020, 12, 14)
        .until(LocalDate.of(2020, 114, 78), ChronoUnit.DAYS));
  }

}
