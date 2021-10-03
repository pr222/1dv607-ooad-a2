package controller;

import view.ConsoleUi;
import model.Register;
import model.Member;

public class MemberController {
 // private Member member;
  private final Register register;
  private final ConsoleUi ui;
  
  //  MemberController(Member member, Register register, ConsoleUi ui) {
  MemberController(Register register, ConsoleUi ui) {
   // this.member = member;
    this.register = register;
    this.ui = ui;
  }

  public void start() {
    while(!ui.wantsToQuit()) {
      ui.showMainMenu();

      if (ui.wantsToCreateMember()) {
        this.createMember();
        ui.showMessage("Member created!");
        ui.showMessage("Id created");
      } else if (ui.wantsToManageMember()) {
        String idInput = ui.askForIdIdentification();

        try {
          Member member = register.searchMember(idInput);
          System.out.println(member.getName());
          System.out.println(member.getPersonalNumber());
          System.out.println(member.getId());
        } catch(Exception err) {
          ui.showMessage(err.getMessage());
        }
    
      } else if (ui.wantsToShowVerboseList()) {
         System.out.println("Welcome to V-list");
      } else if (ui.wantsToShowCompactList()) {
        System.out.println("Welcome to C-list");
      } else if (ui.wantsToQuit()) {
        ui.showMessage("Quitting application...");
      }
    }
  }

  private void createMember() {
    String name = ui.askForName();
    String personalNumber = ui.askForPersonalNumber();

    register.addMember(name, personalNumber);
  }
}
