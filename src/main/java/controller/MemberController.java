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
          //Sparar member för member-meny
          Member member = register.searchMember(idInput);
          System.out.println("Id har matchats" + member.getName());
          // boolean isDeleted = false;

          // Håller oss i Member-menyn
          while(!ui.wantsToGoBack()) {
            ui.memberMenu();

            if (ui.wantsToDisplayInfo()) {
              // Display member info
              ui.showCompactInfo(member.getName(), member.getId());
              ui.showPressAnyKeyToContinue();
            } else if (ui.wantsToEditMemberInformation()) {
              // Change member name
              member.setName(ui.changeMemberInformation());
              ui.showMessage("Name is changed");
              ui.showPressAnyKeyToContinue();
            } else if (ui.wantsToDeleteMemberInformation()) {
              // Delete member.
              ui.showMessage("Deleting member...");
              // isDeleted = true;
              register.deleteMember(member);
              break;
            } else if (ui.wantsToGoBack()) {
              // Going back to main menu
              ui.showMessage("Going back...");
            }
          }
        } catch(Exception err) {
          ui.showMessage(err.getMessage());
        }
      } else if (ui.wantsToShowVerboseList()) {
         System.out.println("Welcome to Verbose");
      } else if (ui.wantsToShowCompactList()) {
          getCompactList();
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

  private void getCompactList() {
    for(Member mem : register.getMembers()) {
      ui.showCompactInfo(mem.getName(), mem.getId());
   }
   ui.showPressAnyKeyToContinue();
  }
}
