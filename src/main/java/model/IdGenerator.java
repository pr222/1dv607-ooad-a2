package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generates Id:s with the format "123ABC".
 */
public class IdGenerator {
  private char[] number = "0123456789".toCharArray();
  private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  public IdGenerator() {
  }

  /**
   * Makes ids for members.
   */
  public Id generateId() {
    Random random = new Random();
    
    ArrayList<Character> idList = new ArrayList<Character>();

    for (int p = 0; p < 3; p++) {
      int n = random.nextInt(10); 

      idList.add(number[n]);
    }
   
    for (int w = 0; w < 3; w++) {
      int n = random.nextInt(26); 
      idList.add(alphabet[n]); 
    }

    StringBuilder builder = new StringBuilder(idList.size());
    for (Character ch : idList) {
      builder.append(ch);
    }

    Id id = new Id(builder.toString());

    return id;
  }
}