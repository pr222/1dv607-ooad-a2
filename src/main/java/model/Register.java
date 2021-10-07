package model;

import java.lang.Exception;
import java.util.ArrayList;

/**
 * Register class for CRUD functionalities.
 */
public class Register {
  ArrayList<Member> members;
  MemberIds ids;

  public Register() {
    members = new ArrayList<>();
    ids = new MemberIds();
  }

  public ArrayList<Member> getMembers() {
    return members;
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
    Member member = new Member(name, personalNumber);

    String id = ids.generateUniqueId();

    member.setId(id);

    members.add(member);
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
      if (members.get(i).getId().equals(memberId)) {
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
   * @param member  - object of class Member.
   * 
   */
  public void deleteMember(Member member) {
    members.remove(member);
  }
}