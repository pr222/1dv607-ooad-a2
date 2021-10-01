package controller;

import model.Member;
import view.ConsoleUi;
/**
 * This is just an example contoller class. You should remove it.
 */
public class MemberController {
  private Member model;
  private ConsoleUi view;

  MemberController(Member model, ConsoleUi view) {
    this.model = model;
    this.view = view;
  }

  public void doSomethingSimple(ConsoleUi view) {
    view.showMessage("Welcome new member!");
  }
}
