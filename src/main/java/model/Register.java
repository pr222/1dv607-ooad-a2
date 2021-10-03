package model;

import java.util.ArrayList;
import java.lang.Exception;

public class Register  {
  ArrayList<Member> members;
  MemberIds ids;

  public Register() {
    members = new ArrayList<>();
    ids = new MemberIds();
  }

  public void addMember(String name, String personalNumber) {
    Member member = new Member(name, personalNumber);

    String id = ids.generateUniqueId();

    member.setId(id);

    members.add(member);
  }

  public Member searchMember(String memberId) throws Exception {
    boolean found = false;
    Member member = new Member();

    for(int i=0; i<members.size();i++) {
      if(members.get(i).getId().equals(memberId)) {
        found = true;
        member = members.get(i);
      }
    }

    if (!found) {
      throw new Exception("Could not find member.");
    }

    return member;
  }
} 