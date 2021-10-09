package view;

// import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;
import model.ReadOnlyMember;

/**
 *  Prints menues and takes input.
 */
public class ConsoleUi {
  Scanner scanner;
  String input;

  public ConsoleUi() {
    scanner = new Scanner(System.in, "utf-8");
    input = "";
  }

  /**
   * Shows a message by printing it to the console.
   *
   * @param message The message to show.
   * 
   */
  public void showMessage(String message) {
    System.out.println(message);
  }

  public void promptToContinue() {
    System.out.println("Press any key to continue...");
    scanner.nextLine();
  }

  public String askForInput(String question) {
    System.out.println(question);
    return input = scanner.nextLine();
  }

  /**
   * This method prints a main menu.
   */
  public void showMainMenu() {
    System.out.println("MAIN MENU ");
    System.out.println("Create member, press 1 ");
    System.out.println("Manage member, press 2");
    System.out.println("Show verbose list, press 3 ");
    System.out.println("Show compact list, press 4 ");
    System.out.println("Quit application, press 'q' ");

    input = scanner.nextLine();
  }

  /**
   * This method prints a member menu.
   */
  public void memberMenu() { 
    System.out.println("Display member information (1): ");
    System.out.println("Edit member information (2): ");
    System.out.println("Delete member (3): ");
    System.out.println("Add boat (4): ");
    System.out.println("Manage boats (5): ");
    System.out.println("Go back ('b'): ");

    input = scanner.nextLine();
  }

  /**
   * This method prints a boat menu.
   */
  public void boatMenu() {
    System.out.println("Edit boat information (1): ");
    System.out.println("Delete boat (2): ");
    System.out.println("Go back ('b'): ");

    input = scanner.nextLine();
  }
  
  /**
   * This method prints a compact version of member information.
   */
  public void showCompactInfo(ReadOnlyMember member) {
    System.out.println("Member");
    System.out.println("Name: " + member.getName());
    System.out.println("Member Id: " + member.getId());
    System.out.println("Number of boats: " + member.getNrOfBoats());
  }

  /**
   * This method prints a compact list of member information.
   */
  public void showCompactList(ArrayList<ReadOnlyMember> members) {
    System.out.println("Compact List:");
    for (int i = 0; i < members.size(); i++) {
      System.out.println("Name: " + members.get(i).getName());
      System.out.println("Member Id: " + members.get(i).getId());
      System.out.println("Number of boats: " + members.get(i).getNrOfBoats());
    }
  }

  /**
   * This method prints a verbose version of a member information.
   */
  public void showVerboseInfo(ReadOnlyMember member) {
    System.out.println("Member");
    System.out.println("Name: " + member.getName());
    System.out.println("Personal number: " + member.getPersonalNumber());
    System.out.println("Member Id: " + member.getId());
  }

  public void showVerboseList(ArrayList<ReadOnlyMember> members) {
    System.out.println("Verbose List:");
    for (int i = 0; i < members.size(); i++) {
      System.out.println("Name: " + members.get(i).getName());
      System.out.println("Personal number: " + members.get(i).getPersonalNumber());
      System.out.println("Member Id: " + members.get(i).getId());
      // Boat list
    }
  }


  public ArrayList<String> createMember() {
    System.out.println("What is your name?");
    input = scanner.nextLine();
    String name = input;
    System.out.println("What is your personal number?");
    input = scanner.nextLine();
    String personalNumber = input;
    ArrayList <String> responsArrayList = new ArrayList<String>();
    responsArrayList.add(name);
    responsArrayList.add(personalNumber);
    showMessage("Member created!");
    return responsArrayList;
  }

  public String askForInputId() {
    System.out.println("What is your id?");
    return input = scanner.nextLine();
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

  // För Manage membermeny
  public boolean wantsToDisplayInfo() {
    return input.equals("1");
  }

  public boolean wantsToEditMemberInformation() {
    return input.equals("2");
  }

  public boolean wantsToDeleteMemberInformation() {
    return input.equals("3");
  }

  public boolean wantsToGoBack() {
    return input.equals("b");
  }

  // För boat
  public boolean wantsToAddBoat() {
    return input.equals("4");
  }

  public boolean wantsToManageBoat() {
    return input.equals("5");
  }
}
