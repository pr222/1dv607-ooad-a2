package view;

import java.util.Scanner;

/**
 * This is just an example contoller class. You should remove it.
 */
public class ConsoleUi {
  Scanner scanner = new Scanner(System.in);
  String input;
  
  /**
   * Shows a message by printing it to the console.

   * @param message The message to show.
   */
  public void showMessage(String message) {
    System.out.println(message);
  }
  public void askForName(){
    System.out.println("What is your first name?");
    input = scanner.nextLine();
  }

  public String getInput() {
    return input;
  }
}
