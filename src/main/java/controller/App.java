package controller;

import view.ConsoleUi;
import model.Register;
import model.Member;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point. 
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    ConsoleUi ui = new ConsoleUi();
    Register register = new Register();
    MemberController controller = new MemberController(register, ui);

    Member member1 = new Member("Petra", "222", "98765");
    Member member2 = new Member("Lena", "333", "893409");

    controller.start();  }
}
