package model;

/**
 * Information of boat.
 */
public class Boat {
  private Type type;
  private String length;

  public enum Type {
    SAILBOAT, MOTORSAILER, KAYAK_CANOE, OTHER
  }

  public int value;

  public int getValue() {
    return value;
  }

  public Boat() {
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
