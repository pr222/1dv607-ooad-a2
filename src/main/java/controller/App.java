package controller;

import view.ConsoleUi;
import model.Register;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point. 

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    ConsoleUi ui = new ConsoleUi();
    Register register = new Register();
    MemberController controller = new MemberController(register, ui);

    controller.start();  }
}
