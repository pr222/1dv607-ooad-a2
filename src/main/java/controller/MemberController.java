package controller;

import model.Boat;
import model.Member;
import model.Register;
import view.ConsoleUi;

/**
 * Class deligate to model and view.
 */
public class MemberController {
  private final Register register;
  private final ConsoleUi ui;
  
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
        createMember();
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

  private void createMember() {
    String name = ui.askForInput("What is your name?");
    String personalNumber = ui.askForInput("What is your personal number?");

    register.addMember(name, personalNumber);
    ui.showMessage("Member created!");
  }

  private void handleMemberMenu() {
    try {
      String idInput = ui.askForInput("What is your id?");
      Member member = register.searchMember(idInput);
      
      startMemberMenu(member);
    } catch (Exception err) {
      ui.showMessage(err.getMessage());
    }
  }

  /**
   * Member menu
   */
  private void startMemberMenu(Member member) {
    while (!ui.wantsToGoBack()) {
      ui.memberMenu();

      if (ui.wantsToDisplayInfo()) {
        createCompactList(member);
      } else if (ui.wantsToEditMemberInformation()) {
        editMemberInfo(member);
      } else if (ui.wantsToDeleteMemberInformation()) {     
        deleteMemberInfo(member);
        break;
      } else if (ui.wantsToAddBoat()) {
        addBoat(member);
      } else if (ui.wantsToManageBoat()) {
        // List boats
        // Go to boat menu
      } else if (ui.wantsToGoBack()) {
        ui.showMessage("Going back...");
      }
    }
  }

  private void createCompactList(Member member) {
    ui.showCompactInfo(member.getName(), member.getId().toString());
    ui.promptToContinue();
  }

  private void editMemberInfo(Member member) {
    String newName = ui.askForInput("Change name: ");
    member.setName(newName);

    ui.showMessage("Name is changed");
    ui.promptToContinue();
  }

  private void deleteMemberInfo(Member member) {
    register.deleteMember(member);
    ui.showMessage("Deleting member...");
  }

  private void addBoat(Member member) {
    Boat b = new Boat();
    String input = ui.askForInput(
      "Enter a number to choose a boat type: \n" + 
      "Sailboat (0)\n" + 
      "Motorsailer (1) \n" + 
      "Kayak/Canoe (2)\n" +
      "Other (3)"
    );
    System.out.println(input);
    System.out.println(Boat.Type.SAILBOAT.toString());
    if (input.equals(Boat.Type.SAILBOAT.toString())) {
      System.out.println("SETTING THE TYPE! :)");
      b.setType(Boat.Type.SAILBOAT);
    }

    String length = ui.askForInput("Enter length of the boat: ");
    b.setLength(length);

    member.addBoat(b);
    System.out.println("Nr of boats: " + member.getNrOfBoats());
    System.out.println(member);
  }

  private void getCompactList() {
    for (Member mem : register.getMembers()) {
      ui.showCompactInfo(mem.getName(), mem.getId().toString());
    }

    ui.promptToContinue();
  }

  private void getVerboseList() {
    ui.showMessage("Welcome to Verbose List");
    ui.promptToContinue();
  }

  private void quit() {
    ui.showMessage("Quitting application...");
  } 
}
