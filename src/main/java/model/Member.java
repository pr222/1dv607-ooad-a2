package model;

public class Member {
  private String name;
  private int personalNumber;
  private int id;

  public Member(MemberIds ids) {
    id = ids.generateUniqueId();
    System.out.println(id);
  }
 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPersonalNumber() {
    return personalNumber;
  }

  public void setPersonalNumber(int personalNumber) {
    this.personalNumber = personalNumber;
  }

  public int getId() {
    return id;
  }
}
