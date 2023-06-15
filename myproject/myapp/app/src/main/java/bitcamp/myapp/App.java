package bitcamp.myapp;

import bitcamp.myapp.handler.BoardHandler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();

    MemberHandler memberHandler = new MemberHandler(prompt, "환자");
    BoardHandler boardHandler = new BoardHandler(prompt, "게시물");

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 환자");
    System.out.println("2. 게시물");
    System.out.println("0. 종료");

  }

  static void printTitle() {
    System.out.println("병원 접수 시스템");
    System.out.println("----------------------------------");
  }
}
