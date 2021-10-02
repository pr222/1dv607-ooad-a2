package controller;

import view.ConsoleUi;
import model.Register;

public class MemberController {
  private Register register;
  private ConsoleUi ui;
  
  MemberController(Register register, ConsoleUi ui) {
    this.register = register;
    this.ui = ui;
  }

  public void start() {
    ui.showMainMenu();

    String input = ui.getInput();

    if (input.equals("1")) {
      createMember();
    } else if (input.equals("2")) {
      // TODO: Manage member
    } else if (input.equals("3")) {
      // TODO: Verbose list
    } else if (input.equals("4")) {
      // TODO: Compact List
    } else if (input.equals("5")) {
      // TODO: Quit application.
    }
  }

  private void createMember() {
    String name = "";
    String personalNumber = "";

    ui.askForName();
    name = ui.getInput();

    ui.askForPersonalNumber();
    personalNumber = ui.getInput();

    register.addMember(name, personalNumber);
  }
}
