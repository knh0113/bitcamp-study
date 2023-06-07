package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    int[] age = new int[SIZE];
    int[] weight = new int[SIZE];
    char[] gender = new char[SIZE];
  

    for (int i = 0; i < SIZE; i++) {

      System.out.print("이름? ");
      name[i] = scanner.next();

      System.out.print("나이? ");
      age[i] = scanner.nextInt();

      System.out.print("몸무게? ");
      weight[i] = scanner.nextInt();

      System.out.print("성별(남자:M, 여자:W)? ");
      String str = scanner.next();
      gender[i] = str.charAt(0);
    }

    System.out.println("---------------------------------------");

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("나이: %d\n", age[i]);
      System.out.printf("몸무게: %d\n", weight[i]);
      System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[i]);
    }
    scanner.close();
  }
}
