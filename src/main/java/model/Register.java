package model;

import java.lang.Exception;
import java.util.ArrayList;

/**
 * Register class for CRUD functionalities.
 */
public class Register {
  ArrayList<Member> members;

  public Register() {
    members = new ArrayList<>();
  }
  
  /**
   * A list of read only members.
   */
  public ArrayList<ReadOnlyMember> getMembers() {
    ArrayList<ReadOnlyMember> readonlyMembers = new ArrayList<>();

    for (Member m : members) {
      ReadOnlyMember readonly = new ReadOnlyMember(m);

      readonlyMembers.add(readonly);
    }

    return readonlyMembers;
  }

  public void addMember(Member member) {
    members.add(member);
  }

  /**
   * Add a new member to the register.
   *
   * @param name           - name for the member.
   * @param personalNumber - personal number for the member
   * 
   */
  public void addMember(String name, String personalNumber) {
    IdGenerator generator = new IdGenerator();
    boolean checkedForUniqueness = false;
    Id id = generator.generateId();

    while (!checkedForUniqueness) {
      boolean isTaken = checkIfTaken(id); 
      
      if (isTaken) {
        id = generator.generateId();
      } else {
        checkedForUniqueness = true;
      }
    }

    Member member = new Member(name, personalNumber, id);
    members.add(member);
  }

  private boolean checkIfTaken(Id id) {
    for (Member m : members) {
      if (id.equals(m.getId())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Find a member with a member id.
   *
   * @param memberId - The Id of the member to find.
   * @throws Exception - When no member was found.
   * 
   */
  public Member searchMember(String memberId) throws Exception {
    boolean found = false;
    Member member = new Member();

    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getId().toString().equals(memberId)) {
        found = true;
        member = members.get(i);
      }
    }

    if (!found) {
      throw new Exception("Could not find member.");
    }

    return member;
  }

  /**
   * Deletes a member from the register.
   *
   * @param member      - object of class Member.
   * 
   */
  public void deleteMember(Member member) {
    members.remove(member);
  }
}