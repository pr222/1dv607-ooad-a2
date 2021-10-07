package controller;

import view.ConsoleUi;
import model.Register;
import model.Member;

public class MemberController {
  private final Register register;
  private final ConsoleUi ui;
  
  MemberController(Register register, ConsoleUi ui) {
    this.register = register;
    this.ui = ui;
  }

  public void startMainMenu() {
    while(!ui.wantsToQuit()) {
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
    String name = ui.askForName();
    String personalNumber = ui.askForPersonalNumber();

    register.addMember(name, personalNumber);
    ui.showMessage("Member created!");
  }

  private void handleMemberMenu() {
    try {
      String idInput = ui.askForIdIdentification();
      Member member = register.searchMember(idInput);
      
      // initiate a memberMenu-class-object?
      // Menu menu = new Menu(member, ui); 
      // menu.startMemberMenu();
      startMemberMenu(member);
    } catch(Exception err) {
      ui.showMessage(err.getMessage());
    }
  }

  private void startMemberMenu(Member member) {
    while(!ui.wantsToGoBack()) {
      ui.memberMenu();

      if (ui.wantsToDisplayInfo()) {
        createCompactList(member);
      } else if (ui.wantsToEditMemberInformation()) {
        editMemberInfo(member);
      } else if (ui.wantsToDeleteMemberInformation()) {     
        deleteMemberInfo(member);
      } else if (ui.wantsToGoBack()) {
        ui.showMessage("Going back...");
      }
    }
  }

  private void createCompactList(Member member){
    ui.showCompactInfo(member.getName(), member.getId());
    ui.showPressAnyKeyToContinue();
  }

  private void editMemberInfo(Member member){
    String newName = ui.changeMemberInformation();
    member.setName(newName);
    ui.showMessage("Name is changed");
    ui.showPressAnyKeyToContinue();
  }

  private void deleteMemberInfo(Member member){
    register.deleteMember(member);
    ui.showMessage("Deleting member...");
    // break;

  }

  private void getCompactList() {
    for(Member mem : register.getMembers()) {
      ui.showCompactInfo(mem.getName(), mem.getId());
    }
    ui.showPressAnyKeyToContinue();
  }

  private void getVerboseList() {
    ui.showMessage("Welcome to Verbose List");
    ui.showPressAnyKeyToContinue();
  }

  private void quit() {
    // Place to save for persistance?
    ui.showMessage("Quitting application...");
  }
  
}
