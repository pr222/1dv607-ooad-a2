package model;

import java.util.ArrayList;

/**
 * Member with its information and boats.
 */
public class Member {
  private String name;
  private String personalNumber;
  private Id id;
  private ArrayList<Boat> boats = new ArrayList<>();

  public Member() {
  }
  
  public Member(String name, String personalNumber) {
    this.name = name;
    this.personalNumber = personalNumber;
    
  }

  /**
   * This constructs a new member.
   */
  public Member(String name, String personalNumber, Id id) {
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
  public Id getId() {
    return id;
  }

  /**
   * Sets id for members.
   *
   * @param id a string of numbers and letters for each member.
   */
  public void setId(Id id) {
    this.id = id;
  }

  public void addBoat(Boat boat) {
    boats.add(boat);
  }

  public void deleteBoat(Boat boat) {
    boats.remove(boat);
  }

  public int getNrOfBoats() {
    return boats.size();
  }
}
