package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    printTitle();

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0; //

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];

    // 회원정보 등록
    for (int i = 0; i < MAX_SIZE; i++) { // for(1.처음, )

      inputMember(scanner, i, name, email, password, gender, no, userId++);

      length++;

      if (!promptContinue(scanner)) {
        break;
      }
    }

    System.out.println("---------------------------------");

    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------");

    for (int i = 0; i < length; i++) { // 작성한 번ㅆ까지만 출력하기 위함
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
    scanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-----------------------------------");
  }

  static void inputMember(Scanner scanner, int i,
      String[] name, String[] email, String[] password, char[] gender, int[] no, int userId) {


      System.out.print("이름? : ");
      name[i] = scanner.next();

      System.out.print("이메일? : ");
      email[i] = scanner.next();

      System.out.print("암호? : ");
      password[i] = scanner.next();

      loop: while (true) {                  //loop라고 라벨링해줌
        System.out.println("성별? : ");
        System.out.println(" 1. 남자");
        System.out.println(" 2. 여자");
        System.out.print("> ");
        String menuNo = scanner.next();
        scanner.nextLine(); // 입력 값(token)을 읽고 난 후에 남아 있는 줄버꿈 코드를 제거한다.
        
      //   if (menuNo.equals("1")) {
      //     gender[i] = 'M';
      //     break;
      //   } else if (menuNo.equals("2")) {
      //     gender[i] = 'W';
      //     break;
      //   } else {
      //     System.out.println("무효한 번호입니다.");
      //   }
      // }

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
      // while (true) : 무한 루프 맞을때까지
      // String str = scanner.next();
      // gender[i] = str.charAt(0);
      // scanner.next()로 문자열이 str로 저장되고 charAt(0)에 의해 0번째 문자가 출력되어 gender[i]에 저장된다.
      // gender[i] = scanner.next().charAt(0);

      // count++; // = count += +1;// = count = count +1;
      
    }
    no[i] = userId++;
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("계속하시겠습니까?(Y/n)");
    // scanner.nextLine(); // 이전 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }
}