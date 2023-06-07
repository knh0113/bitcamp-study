package bitcamp.myapp;

public class App {
  public static void main(String[] args) {
    System.out.println("병원 접수 시스템");
    System.out.println("----------------------------------");

    int no = 100;
    String name = "곽나현";
    int age = 20;
    int weight = 45;
    char gender = 'M';

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
    System.out.printf("몸무게: %d\n", weight);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    
  }
}