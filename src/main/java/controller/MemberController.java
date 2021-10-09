package controller;

import java.util.List;

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
        createCompactInfo(member);
      } else if (ui.wantsToEditMemberInformation()) {
        editMemberInfo(member);
      } else if (ui.wantsToDeleteMemberInformation()) {     
        deleteMemberInfo(member);
        break;
      } else if (ui.wantsToAddBoat()) {
        addBoat(member);
      } else if (ui.wantsToManageBoat()) {
        chooseBoatToChange(member);
        // List boats
        // Go to boat menu
      } else if (ui.wantsToGoBack()) {
        ui.showMessage("Going back...");
      }
    }
  }

  private void createCompactInfo(Member member) {
    ui.showCompactInfo(member);
    ui.promptToContinue();
  }

  private void getCompactList() {
    List list = register.getMembers();
    ui.showCompactList(list);
    ui.promptToContinue();
  }

  private void getVerboseList(Member member) {
    ui.showVerboseInfo(member);
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
    String input = ui.askForInput(
      "Enter a number to choose a boat type: \n" + 
      "Sailboat (0)\n" + 
      "Motorsailer (1) \n" + 
      "Kayak/Canoe (2)\n" +
      "Other (3)"
    );
    int i = Integer.parseInt(input); 

    Boat b = new Boat(i);

    String length = ui.askForInput("Enter length of the boat in meter: ");
    b.setLength(length);

    member.addBoat(b);
  }

  private void chooseBoatToChange(Member member){
    addBoat(member);
    // String input = ui.askForInput(
    //   "Which boat information do you want to change: \n" + 
       
    // );
  }

private void changeBoat(Member member){
   String newType = ui.askForInput("Change type: "); //ENUM
   String newLenght = ui.askForInput("Change length: "); 
   
   
   //member.setName(newName);

    ui.showMessage("Boat information is changed");
    ui.promptToContinue();
     
  private void quit() {
    ui.showMessage("Quitting application...");
  } 
}
