package bitcamp.myapp;

import java.util.Scanner;

public class App {
  
  static Scanner scanner = new Scanner(System.in);

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static int[] age = new int[MAX_SIZE];
  static int[] weight = new int[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';
  
  public static void main(String[] args) {

    printTitle();

    while (length < MAX_SIZE) {
      inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    printMembers();

    scanner.close();
  }

  static void printTitle() {
    System.out.println("병원 접수 시스템");
    System.out.println("----------------------------------");
  }

  static void inputMember() {
    name[length] = promptString("이름? ");
    age[length] = promptInt("나이? ");
    weight[length] = promptInt("몸무게? ");

    loop: while (true) {
      String menuNo = promptString("성별:\n" + 
      "  1. 남자\n" + 
      "  2. 여자\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          gender[length] = MALE;
          break loop;
        case "2":
          gender[length] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    no[length] = userId++;
    length++;
  }

  static boolean promptContinue() {
    String response = promptString("계속 접수하시겠습니까?(Y/n) ");
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 몸무게, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %d, %c\n", no[i], name[i], age[i], weight[i], gender[i]);
    }
  }
  
  static String promptString(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }

  static int promptInt(String title) {
    System.out.print(title);
    return scanner.nextInt();
  }


}
