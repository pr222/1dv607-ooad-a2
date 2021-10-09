package model;

/**
 * Information of boat.
 */
public class Boat {
  private Type type;
  private String length;

  /**
   * Represents a group of constanst for a boat type.
   */ 
  public enum Type {
    SAILBOAT, MOTORSAILER, KAYAK_CANOE, OTHER
  }

  public Boat(int enumIndex) {
    //System.out.println("Type values: " + Type.values());
    for (Type enumType : Type.values()) {
     // System.out.println("Type name: " + enumType.name());
      if (enumType.ordinal() == enumIndex) {
        this.type = enumType;
      }
    }
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }
}
