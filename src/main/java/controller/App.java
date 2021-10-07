package controller;

import model.Member;
import model.Register;
import view.ConsoleUi;

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
    Member member1 = new Member("Petra", "222", "98765");
    Member member2 = new Member("Lena", "333", "893409");

    register.addMember(member1);
    register.addMember(member2);

    MemberController controller = new MemberController(register, ui);

    controller.startMainMenu();
  }
}
