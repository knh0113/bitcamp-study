package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    int[] age = new int[MAX_SIZE];
    int[] weight = new int[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, name, age, weight, gender, no, userId++);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, no, name, age, weight, gender);

    scanner.close();
  }

  static void printTitle() {
    System.out.println("병원 접수 시스템");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i,
      String[] name, int[] age, int[] weight, char[] gender, int[] no, int userId) {

    System.out.print("이름? ");
    name[i] = scanner.next();

    System.out.print("나이? ");
    age[i] = scanner.nextInt();

    System.out.print("몸무게? ");
    weight[i] = scanner.nextInt();

    loop: while (true) {
      System.out.println("성별: ");
      System.out.println("  1. 남자");
      System.out.println("  2. 여자");
      System.out.print("> ");
      String menuNo = scanner.next();
      scanner.nextLine(); // 입력 값(token)을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.

      switch (menuNo) {
        case "1":
          gender[i] = 'M';
          break loop;
        case "2":
          gender[i] = 'W';
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    no[i] = userId;
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("계속 접수하시겠습니까?(Y/n) ");
    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, int[] age, int[] weight, char[] gender) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 몸무게, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %d, %c\n", no[i], name[i], age[i], weight[i], gender[i]);
    }
  }
}

