package bitcamp.myapp.handler;

import java.util.Date;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];
  static int length = 0;



  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목?"));
    board.setContent(Prompt.inputString("내용?"));
    board.setWriter(Prompt.inputString("작성자?"));
    board.setPassword(Prompt.inputString("암호? "));

    // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    boards[length++] = board;
  }

  public static void printBoards() {
    // System.out.println("---------------------------------------");
    // System.out.println("번호, 이름, 이메일, 성별");
    // System.out.println("---------------------------------------");
    //
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
    // toGenderString(m.getGender()));
    // }
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");


    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      // 게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td \n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    // String memberNo = Prompt.inputString("번호? ");
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (m.getNo() == Integer.parseInt(memberNo)) {
    // System.out.printf("이름: %s\n", m.getName());
    // System.out.printf("이메일: %s\n", m.getEmail());
    // System.out.printf("성별: %s\n", toGenderString(m.getGender()));
    // return;
    // }
    // }
    // System.out.println("해당 번호의 회원이 없습니다!");
    String boardTitle = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      Date date = new Date(board.getCreatedDate());
      if (board.getNo() == Integer.parseInt(boardTitle)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %d\n", board.getViewCount());
        System.out.printf("등록일: %tY-%tm-%td\n", date, date, date);
        return;
      }
    }
    System.out.println("해당 번호의 게시물이 없습니다!");
  }



  public static void updateBoard() {
    // String memberNo = Prompt.inputString("번호? ");
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (m.getNo() == Integer.parseInt(memberNo)) {
    // System.out.printf("이름(%s)? ", m.getName());
    // m.setName(Prompt.inputString(""));
    // System.out.printf("이메일(%s)? ", m.getEmail());
    // m.setEmail(Prompt.inputString(""));
    // System.out.printf("새암호? ");
    // m.setPassword(Prompt.inputString(""));
    // m.setGender(inputGender(m.getGender()));
    // return;
    // }
    // }System.out.println("해당 번호의 회원이 없습니다!");
    String boardTitle = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(boardTitle)) {
        System.out.printf("제목(%s)? ", board.getTitle());
        board.setTitle(Prompt.inputString(""));
        System.out.printf("작성자(%s)? ", board.getWriter());
        board.setWriter(Prompt.inputString(""));
        System.out.printf("조회수(%d)? ", board.getViewCount());
        board.setViewCount(Prompt.inputInt(""));
        System.out.printf("새암호? ");
        board.setPassword(Prompt.inputString(""));
        return;
      }
    }
    System.out.println("해당 번호의 게시물이 없습니다!");


  }



  public static void deleteBoard() {
    // int memberNo = Prompt.inputInt("번호? ");
    //
    // int deletedIndex = indexOf(memberNo);
    // if (deletedIndex == -1) {
    // System.out.println("해당 번호의 회원이 없습니다!");
    // return;
    // }
    //
    // for (int i = deletedIndex; i < length - 1; i++) {
    // boards[i] = boards[i + 1];
    // }
    //
    // boards[--length] = null;
    int boardTitle = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(boardTitle);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시물이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];
    }

    boards[--length] = null;
  }

  private static int indexOf(int boardTitle) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardTitle) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
