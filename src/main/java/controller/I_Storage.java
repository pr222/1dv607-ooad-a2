package controller;

import model.Register;

/**
 * I_Storage to load and save data.
 */
public interface I_Storage {
  public Register loadMemberData(Register memberdata);
  public void saveMemberData(Register memberdata);
}