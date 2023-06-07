package bitcamp.myapp;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
   

    Scanner scanner = new Scanner(System.in);

    int SIZE = 3;
    int userId = 1;
    int length = 0;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] email = new String[SIZE];
    String[] password = new String[SIZE];
    char[] gender = new char[SIZE];
  
    

 
   
    
  
  no[i] = userId++;
  length++;
  
  System.out.print("계속 하시렵니까? (Y/n)")
  scanner.nextLine();
  String response = scanner.nextLine();
  if (!response.equals("")&&!response.equals("Y")) {
    break;
  }
}
  
  System.out.println("------------------------------------");
    
for (int i = 0; i < length; i++) {
    System.out.printf("%d %s %s %c\n ", no[i], name[i], email[i], gender[i]);
  }
    scanner.close();
  }
}

static void printTitle() {
  System.out.println("나의 목록 관리 시스템");
  System.out.println("----------------------------------");
}

static void inputMember(Scanner scanner, int i,
    String[] name,String[] email, String[] password, char[] gender, int[] no, int userId) {
  System.out.print("이름 ?");
  name[i] = scanner.next();

  System.out.print("이메일 ?");
  email[i] = scanner.next();

  System.out.print("암호 ?");
  password[i] = scanner.next();

  // System.out.print("성별 ?");
  // String str = scanner.next();
  // gender[i] = str.charAt(0);
  
  loop: while (true) {
    System.out.println("성별 ?");
    System.out.println(" 1. 남자");
    System.out.println(" 2. 여자");
    System.out.println(">");
    String menuNo = scanner.next();

    // if (menuNo.equals("1")) {
    //   gender[i] = 'M';
    //   break;
    // } else if (menuNo.equals("2")) {
    //   gender[i] = 'F';
    //   break;
    // } else {
    //   System.out.println("무효한 번호입니다");
    // }
    switch (menuNo) {
      case "1":
        gender[i] = 'M';
        break loop;
      case "2":
        gender[i] = 'W';
        break loop;
      default :
        System.out.println("무효한 번호이다.");
    }
  }

  no[i] = userId++;
}