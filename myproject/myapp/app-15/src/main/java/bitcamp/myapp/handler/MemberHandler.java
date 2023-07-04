package bitcamp.myapp.handler;

import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Member;

public class MemberHandler {

  private final int MAX_SIZE = 100;
  private Member[] members = new Member[MAX_SIZE];
  private int length;
  private Prompt prompt;

  public MemberHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(Prompt.inputString("이름? "));
    m.setAge(Prompt.inputString("나이? "));
    m.setWeight(Prompt.inputString("몸무게? "));
    m.setGender(inputGender((char)0));

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게 
    // 레퍼런스 배열에 담는다.
    members[length++] = m;
  }

  public void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 몸무게, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
        m.getNo(), m.getName(), m.getAge(), m.getWeight(), 
        toGenderString(m.gender));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("나이: %s\n", m.getAge());
        System.out.printf("몸무게: %s\n", m.getWeight());
        System.out.printf("성별: %s\n", toGenderString(m.gender));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
        m.setAge(this.prompt.inputString("나이(%s)? ", m.getAge()));
        m.setWeight(this.prompt.inputString("몸무게(%s)? ", m.getWeight()));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label + 
      "  1. 남자\n" + 
      "  2. 여자\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return length < MAX_SIZE;
  }
}
