package model;

import java.util.ArrayList;

public class Register {
  ArrayList<Member> members;
  MemberIds ids;

  public Register() {
    members = new ArrayList<>();
    ids = new MemberIds();
  }

  public void addMember(String name, String personalNumber) {
    Member member = new Member(name, personalNumber);

    Integer id = ids.generateUniqueId();

    member.setId(id);

    members.add(member);
  }

} 