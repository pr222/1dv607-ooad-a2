package controller;

import model.Member;
import model.Register;

public class Storage implements IStorage {

  @Override
  public Register loadMemberData(Register register) {
    Member member1 = new Member("Petra", "222", "98765");
    Member member2 = new Member("Lena", "333", "893409");

    register.addMember(member1);
    register.addMember(member2);

    return register;

  }

  @Override
  public void saveMemberData(Register register) {
  }
}