package controller;

import model.MemberIds;
import model.Member;

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
  }
}
