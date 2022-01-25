/**
 * Looking Positive Tracking.
 */
package lookingpositive.lookingpositive;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class tracks the contacts that need to be informed.
 */
public final class Tracking {
  /**
   * private constructor.
   */
  private Tracking() {
    // not called
  }

  /**
   * declaring how many days are tracked.
   */
  private static final int DAYS = 14;

  /**
   * list with unique E-mails.
   */
  private static ArrayList<String> contactstoinform = new ArrayList<String>();

  /**
   * this method tracks.
   * @param userID case ID
   */
  public static void track(final int userID) {
    for (int k = 0; k < DAYS; k++) {
      for (int l = 0; l < Calendar.getFourteenDaysCell(k)
          .getUsersEventListsSize(userID); l++) {
        for (int p = 0; p < Calendar.getFourteenDaysCell(k)
            .getCurrentEvent(userID, l).getProfiles().size(); p++) {
          if (Calendar.getFourteenDaysCell(k).getCurrentEvent(userID, l)
              .getProfiles().get(p).getEmail() != null) {
            contactstoinform.add(Profile.profilesLine(
                Calendar.getFourteenDaysCell(k).getCurrentEvent(userID, l)
                    .getProfiles().get(p).getUserID())
                .getEmail());
          }
        }
      }
    }
    if (contactstoinform.size() != 0) {
    Tracking.removeDuplicates(contactstoinform);
    Mail.email(contactstoinform);
    } else {
    System.out.println("Thanks for the update!");
    }
  }

  /**
   * this method removes duplicates.
   * @param <String> contains E-mails
   * @param list     contains unique E-mails
   * @return unique E-mails
   */
  public static <String> ArrayList<String> removeDuplicates(
      final ArrayList<String> list) {
    Set<String> set = new LinkedHashSet<String>();
    set.addAll(list);
    list.clear();
    list.addAll(set);
    return list;
  }
}
