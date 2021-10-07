package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class MemberIds {
  ArrayList<String> ids;
  
  public MemberIds() {
    this.ids = new ArrayList<>();
  }

  public String generateUniqueId() {
    Random random = new Random();
    Integer randomIdNumber = random.nextInt();

    String id = Integer.toString(randomIdNumber);
    // boolean unique = checkUniqueness(randomId);

    // if(!unique) {
    // generateUniqueId();
    // }

    return id;
  }

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