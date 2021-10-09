package controller;

import model.Boat;
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
    final Member member2 = new Member("Lena", "333", id2);
    Boat boat1 = new Boat(2);
    boat1.setLength("10");
    Boat boat2 = new Boat(1);
    boat2.setLength("11");
    member1.addBoat(boat1);
    member1.addBoat(boat2);

    Boat boat3 = new Boat(0);
    boat3.setLength("8");

    Boat boat4 = new Boat(0);
    boat4.setLength("14");

    member2.addBoat(boat3);
    member2.addBoat(boat4);

    register.addMember(member1);
    register.addMember(member2);

    return register;
  }

  @Override
  public void saveMemberData(Register register) {
  }
}
