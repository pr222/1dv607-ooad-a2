package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.ReadOnlyBoat;
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
   * Print a message to console.
   *
   * @param message To be displayed.
   * 
   */
  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void promptToContinue() {
    System.out.println("Press enter to continue...");
    scanner.nextLine();
  }
  
  /**
   * Asking for an input of name.
   * 

   * @return the asked name.
   */
  public String askForName() {
    System.out.println("Change name to: ");
    input = scanner.nextLine();
    System.out.println("Name is changed");
    return input;
  }

  /**
   * This method prints a main menu.
   */
  public void showMainMenu() {
    System.out.println("MAIN MENU ");
    System.out.println("========================================= ");
    System.out.println("Create member, press (1) ");
    System.out.println("Manage member, press (2)");
    System.out.println("Show verbose list, press (3) ");
    System.out.println("Show compact list, press (4) ");
    System.out.println("Quit application, press (q) ");
    System.out.println("========================================= ");

    input = scanner.nextLine();
  }

  /**
   * This method prints a member menu.
   */
  public void memberMenu() { 
    System.out.println("========================================= ");
    System.out.println("Display member information (1): ");
    System.out.println("Edit member information (2): ");
    System.out.println("Delete member (3): ");
    System.out.println("Add boat (4): ");
    System.out.println("Manage boats (5): ");
    System.out.println("Go back (b): ");
    System.out.println("========================================= ");

    input = scanner.nextLine();
  }

  /**
   * This method prints a boat menu.
   */
  public String boatMenu() {
    System.out.println("========================================= ");
    System.out.println("Edit boat information (1): ");
    System.out.println("Delete boat (2): ");
    System.out.println("========================================= ");

    return input = scanner.nextLine();
  }
  
  /**
   * This method prints a compact version of member information.
   */
  public void showMemberInfo(ReadOnlyMember member) {
    System.out.println("========================================= ");
    System.out.println("Member");
    System.out.println("Name: " + member.getName());
    System.out.println("Member Id: " + member.getId());
    System.out.println("Number of boats: " + member.getNrOfBoats());
    for (int w = 0; w < member.getBoats().size(); w++) {
      System.out.print(member.getBoats().get(w).getType() + " ");
      System.out.println(member.getBoats().get(w).getLength() + "m");
    }
    System.out.println("========================================= ");
  }

  /**
   * This method prints a compact list of member information.
   */
  public void showCompactList(ArrayList<ReadOnlyMember> members) {
    System.out.println("========================================= ");
    System.out.println("Compact List:");
    for (int i = 0; i < members.size(); i++) {
      System.out.println("Name: " + members.get(i).getName());
      System.out.println("Member Id: " + members.get(i).getId());
      System.out.println("Number of boats: " + members.get(i).getNrOfBoats());
    }
    System.out.println("========================================= ");
  }

  /**
   * This method prints a verbose version of all member information.
   */
  public void showVerboseList(ArrayList<ReadOnlyMember> members) {
    System.out.println("========================================= ");
    System.out.println("Verbose List:");
    for (int i = 0; i < members.size(); i++) {
      System.out.println("Name: " + members.get(i).getName());
      System.out.println("Personal number: " + members.get(i).getPersonalNumber());
      System.out.println("Member Id: " + members.get(i).getId());
      System.out.println("Boats: ");
      for (ReadOnlyBoat boat : members.get(i).getBoats()) {
        System.out.println(boat.getType().name() + " " + boat.getLength() + "m");
      }
    }
    System.out.println("========================================= ");
  }

  /**
   * Returns gathered member information for creating a member.
   */
  public ArrayList<String> askForMemberInformation() {
    System.out.println("What is your name?");
    input = scanner.nextLine();
    String name = input;
    System.out.println("What is your personal number?");
    input = scanner.nextLine();
    String personalNumber = input;
    ArrayList<String> responsArrayList = new ArrayList<String>();
    responsArrayList.add(name);
    responsArrayList.add(personalNumber);
    displayMessage("Member created!");
    return responsArrayList;
  }

  public String askForInputId() {
    System.out.println("What is your id?");
    return input = scanner.nextLine();
  }

  public String askForBoatLength() {
    System.out.println("Enter length of the boat in meter: ");
    return input = scanner.nextLine();
  }

  /**
   * This method asks for a boat type.
   */
  public String askForBoatType(ArrayList<Boat.Type> types) {
    System.out.println("Enter a number to choose a boat type:");
    for (Boat.Type type : types) {
      System.out.println(type.name() + " (" + type.ordinal() + ")");
    }

    return input = scanner.nextLine();
  }

  /**
   * This method allows to edit a boat.
   */
  public String chooseBoatToEdit(ArrayList<ReadOnlyBoat> boats) {
    System.out.println("Choose a boat to edit");
    for (int a = 0; a < boats.size(); a++) {
      System.out.println(boats.get(a).getType() + " " + boats.get(a).getLength() + "m " + "(" + a + ")");
    }
    return input = scanner.nextLine();
  }

  /**
   * This method allows which boat attribute to edit.
   */
  public void chooseWhatToEditBoat(ArrayList<Boat.Type> types) {
    String length = askForBoatLength();
    String type = askForBoatType(types);
    System.out.println(length);
    System.out.println(type);
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

  public boolean wantsToAddBoat() {
    return input.equals("4");
  }

  public boolean wantsToManageBoat() {
    return input.equals("5");
  }

  public boolean wantsToEditBoat() {
    return input.equals("1");
  }

  public boolean wantsToDeleteBoat() {
    return input.equals("2");
  }
}
