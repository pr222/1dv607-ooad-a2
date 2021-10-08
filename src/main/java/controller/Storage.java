package controller;

import model.Id;
import model.Member;
import model.Register;

/**
 * Class that holds data to be read when app starts.
 */
public class Storage implements StorageInterface {

  @Override
  public Register loadMemberData(Register register) {
    Id id1 = new Id("122ACF");
    Id id2 = new Id("991BCO");

    Member member1 = new Member("Petra", "222", id1);
    Member member2 = new Member("Lena", "333", id2);

    register.addMember(member1);
    register.addMember(member2);

    return register;

  }

  @Override
  public void saveMemberData(Register register) {
  }
}
