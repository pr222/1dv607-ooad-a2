package model;

public class Member {
  private String name;
  private String personalNumber;
  private Integer id;

  public Member(String name, String personalNumber) {
    this.name = name;
    this.personalNumber = personalNumber;
  }
 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPersonalNumber() {
    return personalNumber;
  }

  public void setPersonalNumber(String personalNumber) {
    this.personalNumber = personalNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
