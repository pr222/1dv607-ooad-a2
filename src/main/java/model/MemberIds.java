package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberIds {
  ArrayList<Integer> ids;
  
  public MemberIds() {
    this.ids = new ArrayList<>();
  }

  public Integer generateUniqueId() {
    Random random = new Random();
    Integer randomId = random.nextInt();

    // boolean unique = checkUniqueness(randomId);

    // if(!unique) {
      // generateUniqueId();
    // }

    return randomId;
  }

  public boolean checkUniqueness(Integer randomId) {
    boolean uniqueness = false;

    for (int i = 0; i < this.ids.size(); i++) {
      if (randomId.equals(i)) {
        uniqueness = true;
      }
    }
    return uniqueness;
  }

}