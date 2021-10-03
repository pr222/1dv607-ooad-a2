package view;

import java.util.Scanner;

/**
 *
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

  public void showMainMenu() {
    System.out.println("MAIN MENU ");
    System.out.println("Create member, press 1 ");
    System.out.println("Manage member, press 2");
    System.out.println("Show verbose list, press 3 ");
    System.out.println("Show compact list, press 4 ");
    System.out.println("Quit application, press 'q' ");

    input = scanner.nextLine();
  }

  public void memberMenu() {
    System.out.println("Display member information (1): ");
    System.out.println("Edit member information (2): ");
    System.out.println("Delete member (3): ");
    System.out.println("Add boat (4): ");
    System.out.println("Manage boats (5): ");
    System.out.println("Go back to Main Menu (6): ");

    input = scanner.nextLine();
  }

  public void boatMenu() {
    System.out.println("Edit boat (1): ");
    System.out.println("Delete boat (1): ");
    System.out.println("Go back (1): ");

    input = scanner.nextLine();
  }

  public boolean wantsToCreateMember() {
    return input.equals("1");
  }

  public boolean wantsToManageMember() {
    return input.equals("2");
  }

  public boolean wantsToShowVerboseList() {
    return input.equals("3");
  }

  public boolean wantsToShowCompactList() {
    return input.equals("4");
  }

  public boolean wantsToQuit() {
    return input.equals("q");
  }

    public String askForName() {
    System.out.println("What is your first name?");
    input = scanner.nextLine();

    return input;
  }

  public String askForPersonalNumber() {
    System.out.println("What is your personal number?");
    return input = scanner.nextLine();
  }

  public void changeMemberInformation() {
    System.out.println("Change name: ");
    input = scanner.nextLine();
  }
   
  public void boatSubMenu() {
    System.out.println("Enter boat type: ");
    String type = scanner.nextLine();

    System.out.println("Enter length of the boat: ");
    int length = scanner.nextInt();
  }

  public String askForIdIdentification() {
    System.out.println("Enter memberId?");
    
    return input = scanner.nextLine();
  }

  public String getInput() {
    return this.input;
  }
}
