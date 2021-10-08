package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Makes uniqe ids for members.
 */
public class MemberIds {
  ArrayList<String> ids;

  public MemberIds() {
    this.ids = new ArrayList<>();
  }

  /**
   * Makes ids for members.
   */
  public String generateUniqueId() {
    Random random = new Random();
    Integer randomIdNumber = random.nextInt();

    String id = Integer.toString(randomIdNumber);

    return id;
  }

  /**
   * Checks that the id isnt used before.

   * @param randomId       - generated member-id.
   * 
   */
  public boolean checkUniqueness(String randomId) {
    boolean uniqueness = false;

    for (int i = 0; i < this.ids.size(); i++) {
      if (randomId.equals(ids.get(i))) {
        uniqueness = true;
      }
    }
    return uniqueness;
  }
}
