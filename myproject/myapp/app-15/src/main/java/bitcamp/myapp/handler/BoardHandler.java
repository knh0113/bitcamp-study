package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;


public class BoardHandler {

  private final int MAX_SIZE = 100;
  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;

  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));

    boards[length++] = board;
  }
  
  public void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");
  
    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getViewCount(),
          board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    String boardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %s\n", board.getViewCount());
        System.out.printf("등록일: %tY-%1$tm-%1$td\n", board.getCreatedDate());
        board.setViewCount(board.getViewCount() + 1);
        return;
      }
      }
      System.out.println("해당 번호의 게시글이 없습니다");
    } 


    public  void updateBoard() {
    String boardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        if (!Prompt.inputString("암호? ").equals(board.getPassword())) {
          System.out.println("암호가 일치하지 않습니다!");
          return;
        }
        board.setTitle(Prompt.inputString("제목(%s)? ", board.getTitle()));
        board.setContent(Prompt.inputString("내용(%s)? ", board.getContent()));
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }

   public void deleteBoard() {
    int deletedIndex = indexOf(Prompt.inputInt("번호? "));
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];
    }

    boards[--length] = null;
  }

   private int indexOf(int boardNo) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }
   private boolean available() {
    return length < MAX_SIZE;
  }
}