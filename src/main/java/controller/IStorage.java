package controller;

import model.Register;

/**
 * IStorage to load and save data.
 */
public interface IStorage {
    public Register loadMemberData(Register memberdata);
    public void saveMemberData(Register memberdata);
}