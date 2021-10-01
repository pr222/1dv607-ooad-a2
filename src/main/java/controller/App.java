package controller;

import model.MemberIds;
import model.Member;
import view.ConsoleUi;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point. 

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    Member member = new Member(new MemberIds());
    System.out.println(member.getId());

    ConsoleUi ui = new ConsoleUi();
    MemberController controller = new MemberController(member, ui);

    controller.doSomethingSimple(ui);
  }
}
