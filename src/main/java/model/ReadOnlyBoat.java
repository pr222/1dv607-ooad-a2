package model;

public final class ReadOnlyBoat {
  private Type type;
  private final String length;

  /**
   * Represents a group of constanst for a boat type.
   */ 
  public enum Type {
    SAILBOAT, MOTORSAILER, KAYAK_CANOE, OTHER
  }

  public ReadOnlyBoat(int enumIndex, String length) {
    for (Type enumType : Type.values()) {
      if (enumType.ordinal() == enumIndex) {
        this.type = enumType;
      }
    }
    this.length = length;
  }

  public Type getType() {
    return type;
  }

  public String getLength() {
    return length;
  }
}
