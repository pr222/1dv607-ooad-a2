package model;

/**
 * Id class.
 */
public class Id {
  private String id;

  public Id() {
  }
  
  public Id(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return id;
  }
}
