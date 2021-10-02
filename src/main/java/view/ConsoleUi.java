package view;

import java.util.Scanner;

/**
 * This is just an example contoller class. You should remove it.
 */
public class ConsoleUi {
  Scanner scanner;
  String input;

  public ConsoleUi() {
    scanner = new Scanner(System.in);
    input = "";
  }
  
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
  public void askForPersonalNumber(){
    System.out.println("What is your personal number?");
    input = scanner.nextLine();
  }

  public void showMainMenu(){
    System.out.println("MAIN MENU ");
    System.out.println("Create member, press 1 ");
    System.out.println("Manage member, press 2");
    System.out.println("Show verbose list, press 3 ");
    System.out.println("Show compact list, press 4 ");
    System.out.println("Quit application, press 5 ");

    input = scanner.nextLine();
  }

  public void memberMenu() {
    System.out.println("Display member information (1): ");
    System.out.println("Edit member information (2): ");
    System.out.println("Delete member (3): ");
    System.out.println("Add boat (4): ");
    System.out.println("Manage boats (5): ");
    System.out.println("Go back to Main Menu (6): ");
  }

  public void changeMemberInformation() {
    System.out.println("Change name: ");
    String newName = scanner.nextLine();
  }
   
  public void boatSubMenu() {
    System.out.println("Enter boat type: ");
    String type = scanner.nextLine();

    System.out.println("Enter length of the boat: ");
    int length = scanner.nextInt();
  }

  public void idIdentification(){
    System.out.println("Enter memberId?");
     String memberId = scanner.nextLine();
     // getMember
  }

  public void showCompactList() {

  }

  public void showVerboseList() {
     
  }

  public String getInput() {
    return input;
  }
}
