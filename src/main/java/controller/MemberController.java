package controller;

import java.lang.Exception;
import java.util.ArrayList;
import model.Boat;
import model.Member;
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
    ArrayList<String> listOfInputRespons = ui.createMember();
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
      ui.showMessage(err.getMessage());
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
        try {
          addBoat();
        } catch(Exception err) {
          ui.showMessage(err.getMessage());
        }
      } else if (ui.wantsToManageBoat()) {
        chooseBoatToChange();
        // List boats
        // Go to boat menu
      } else if (ui.wantsToGoBack()) {
        ui.showMessage("Going back...");
        currentMember = new Member();
      }
    }
  }

  private void createCompactInfo() {
    ReadOnlyMember readonly = new ReadOnlyMember(currentMember);
    ui.showCompactInfo(readonly);
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
    String newName = ui.askForInput("Change name: ");
    currentMember.setName(newName);

    ui.showMessage("Name is changed");
    ui.promptToContinue();
  }

  private void deleteMemberInfo() {
    ui.showMessage("Deleting member...");
    register.deleteMember(currentMember);
  }

  private void chooseBoatToChange() {
    ReadOnlyMember readonly = new ReadOnlyMember(currentMember);
    String input = ui.chooseBoatToEdit(readonly.getBoats());

    int i = Integer.parseInt(input);

    Boat chosenBoat = currentMember.getBoats().get(i);
    
    System.out.println(chosenBoat.getType().name() + " " + chosenBoat.getLength());
    
  }

  private void addBoat() throws Exception {
    ArrayList<Boat.Type> options = new ArrayList<>();
    for (Boat.Type t : Boat.Type.values()) {
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

    currentMember.addBoat(b);
  }

  private void editBoat() {
    ui.chooseWhatToEditBoat(Boat.Type.values());

    // String newType = ui.askForInput("Change type: "); // ENUM
    // String newLenght = ui.askForInput("Change length: ");

    // // member.setName(newName);

    // ui.showMessage("Boat information is changed");
    ui.promptToContinue();
  }

  private void quit() {
    ui.showMessage("Quitting application...");
  }
}
