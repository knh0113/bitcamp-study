package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] age = new String[MAX_SIZE];
  static String[] weight = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    name[length] = Prompt.inputString("이름? ");
    age[length] = Prompt.inputString("나이? ");
    weight[length] = Prompt.inputString("몸무게? ");

    loop: while (true) {
      String menuNo = Prompt.inputString("성별:\n" + 
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

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 몸무게, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s, %c\n", no[i], name[i], age[i], weight[i], gender[i]);
    }
  }

  public static boolean available() {
    return length < MAX_SIZE;
  }
}
