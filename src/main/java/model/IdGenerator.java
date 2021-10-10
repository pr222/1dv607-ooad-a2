package model;

import java.lang.Math;
import java.util.ArrayList;

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
    ArrayList<Character> idList = new ArrayList<Character>();

    for (int p = 0; p < 3; p++) {
      double d = Math.random() * 10; 
      int i = (int) d;  

      idList.add(number[i]);
    }
   
    for (int w = 0; w < 3; w++) {
      double d = Math.random() * 26; 
      int i = (int) d;  
      idList.add(alphabet[i]); 
    }

    StringBuilder builder = new StringBuilder(idList.size());
    for (Character ch : idList) {
      builder.append(ch);
    }

    Id id = new Id(builder.toString());

    return id;
  }
}