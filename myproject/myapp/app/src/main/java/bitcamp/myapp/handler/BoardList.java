package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;

public class BoardList {
  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;
  private static final int MAX_SIZE = 100;

  public void add(Board board) {
    if (this.length == boards.length) {
      increase();
    }
    this.boards[this.length++] = board;
  }

  public void increase() {
    Board[] arr = new Board[boards.length + (boards.length >> 1)];

    for (int i = 0; i < boards.length; i++) {
      arr[i] = boards[i];
    }
    boards = arr;
  }


  public Board[] list() {
    Board[] arr = new Board[length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  public Board get(int no) {
    for (int i = 0; i < this.length; i++) {
      Board board = boards[i];
      if (board.getNo() == no) {
        board.setViewCount(board.getViewCount() + 1);
        return board;
      }
    }
    return null;
  }


}


