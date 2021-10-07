package model;

/**
 * This method returns and changes members.
 */
public class Member {
  private String name;
  private String personalNumber;
  private String id;

  public Member() {
  }
  
  public Member(String name, String personalNumber) {
    this.name = name;
    this.personalNumber = personalNumber;
  }

  /**
   * This constructs a new member.
   */
  public Member(String name, String personalNumber, String id) {
    this.name = name;
    this.personalNumber = personalNumber;
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return - The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the personal number.
   *
   * @return - The personal number.
   */
  public String getPersonalNumber() {
    return personalNumber;
  }

  /**
   * Sets the personal number.
   */
  public void setPersonalNumber(String personalNumber) {
    this.personalNumber = personalNumber;
  }

  /**
   * Gets the id.
   *
   * @return - The id.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id for members.
   *
   * @param id a string of numbers and letters for each member.
   */
  public void setId(String id) {
    this.id = id;
  }
}
