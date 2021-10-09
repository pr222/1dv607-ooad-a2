package model;

import java.util.ArrayList;

/**
 * Reads information about member.
 */
public final class ReadOnlyMember {
  private final String name;
  private final String personalNumber;
  private final Id id;
  private ArrayList<ReadOnlyBoat> boats = new ArrayList<>();
  
  /**
   * Constructs a read only member.
   */
  public ReadOnlyMember(Member member) {
    name = member.getName();
    personalNumber = member.getPersonalNumber();
    id = member.getId();

    for (Boat boat : member.getBoats()) {
      ReadOnlyBoat readonly = new ReadOnlyBoat(boat.getType().ordinal(), boat.getLength());
      boats.add(readonly);
    }
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
   * Gets the personal number.
   *
   * @return - The personal number.
   */
  public String getPersonalNumber() {
    return personalNumber;
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
   * Gets the number of boats.
   *
   * @return - The number of boats.
   */
  public int getNrOfBoats() {
    return boats.size();
  }

  /**
   * Gets the boats.
   *
   * @return - The boats.
   */
  public ArrayList<ReadOnlyBoat> getBoats() {
    return boats;
  }
}