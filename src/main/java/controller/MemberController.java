package controller;

import java.lang.Exception;
import java.util.ArrayList;
import model.Boat;
import model.Member;
import model.ReadOnlyBoat;
import model.ReadOnlyMember;
import model.Register;
import view.ConsoleUi;

/**
 * Class deligate to model and view.
 */
public class MemberController {
  private final Register register;
  private final ConsoleUi ui;
  private Member currentMember;

  MemberController(Register register, ConsoleUi ui) {
    this.ui = ui;

    Storage store = new Storage();
    this.register = store.loadMemberData(register);
  }

  /**
   * This method starts the main menu.
   */
  public void startMainMenu() {
    while (!ui.wantsToQuit()) {
      ui.showMainMenu();

      if (ui.wantsToCreateMember()) {
        createNewMember();
      } else if (ui.wantsToManageMember()) {
        handleMemberMenu();
      } else if (ui.wantsToShowVerboseList()) {
        getVerboseList();
      } else if (ui.wantsToShowCompactList()) {
        getCompactList();
      } else if (ui.wantsToQuit()) {
        quit();
      }
    }
  }

  private void createNewMember() {
    ArrayList<String> listOfInputRespons = ui.askForMemberInformation();
    String name = listOfInputRespons.get(0);
    String personalNumber = listOfInputRespons.get(1);
    register.addMember(name, personalNumber);
  }
  
  private void handleMemberMenu() {
    try {
      String idInput = ui.askForInputId();
      Member member = register.searchMember(idInput); 
      currentMember = member;

      startMemberMenu();
    } catch (Exception err) {
      ui.displayMessage(err.getMessage());
    }
  }

  /**
   * This method starts a member menu.
   */
  private void startMemberMenu() {
    while (!ui.wantsToGoBack()) {
      ui.memberMenu();

      if (ui.wantsToDisplayInfo()) {
        createCompactInfo();
      } else if (ui.wantsToEditMemberInformation()) {
        editMemberInfo();
      } else if (ui.wantsToDeleteMemberInformation()) {
        deleteMemberInfo();
        break;
      } else if (ui.wantsToAddBoat()) {
        addBoat();
      } else if (ui.wantsToManageBoat()) {
        chooseBoatToChange();
      } else if (ui.wantsToGoBack()) {
        ui.displayMessage("Going back...");
        currentMember = new Member();
      }
    }
  }

  private void createCompactInfo() {
    ReadOnlyMember readonly = new ReadOnlyMember(currentMember);
    ui.showMemberInfo(readonly);
    ui.promptToContinue();
  }

  private void getCompactList() {
    ArrayList<ReadOnlyMember> list = register.getMembers();
    ui.showCompactList(list);
    ui.promptToContinue();
  }

  private void getVerboseList() {
    ArrayList<ReadOnlyMember> list = register.getMembers();

    ui.showVerboseList(list);
    ui.promptToContinue();
  }

  private void editMemberInfo() {
    String newName = ui.askForName();
    currentMember.setName(newName);

    ui.promptToContinue();
  }

  private void deleteMemberInfo() {
    ui.displayMessage("Deleting member...");
    register.deleteMember(currentMember);
  }

  private void chooseBoatToChange() {
    ReadOnlyMember readonly = new ReadOnlyMember(currentMember);
    String input = ui.chooseBoatToEdit(readonly.getBoats());

    int i = Integer.parseInt(input);

    Boat boat = currentMember.getBoats().get(i);

    boatMenu(boat);
  }

  private void boatMenu(Boat boat) {
    ui.boatMenu();

    if (ui.wantsToEditBoat()) {
      editBoat(boat);
    } else if (ui.wantsToDeleteBoat()) {
      deleteBoat(boat);
    }
  }
  
  private void addBoat() {
    try {
      Boat boat = newBoat();
      currentMember.addBoat(boat);
    } catch (Exception err) {
      ui.displayMessage(err.getMessage());
    }
  }

  private Boat newBoat() throws Exception {
    ArrayList<ReadOnlyBoat.Type> options = new ArrayList<>();
    for (ReadOnlyBoat.Type t : ReadOnlyBoat.Type.values()) {
      options.add(t);
    }

    String input = ui.askForBoatType(options);
    int i = Integer.parseInt(input);

    if (i > options.size()) {
      throw new Exception("Not a valid boat type.");
    }

    Boat b = new Boat(i);
    String length = ui.askForBoatLength();
    b.setLength(length);

    return b;
  }

  private void editBoat(Boat boat) {
    try {
      Boat boatChanges = newBoat();

      boat.setType(boatChanges.getType());
      boat.setLength(boatChanges.getLength());

      ui.promptToContinue();
    } catch (Exception err) {
      ui.displayMessage(err.getMessage());
    }
  }

  private void deleteBoat(Boat boat) {
    currentMember.deleteBoat(boat);
  }

  private void quit() {
    ui.displayMessage("Quitting application...");
  }
}
