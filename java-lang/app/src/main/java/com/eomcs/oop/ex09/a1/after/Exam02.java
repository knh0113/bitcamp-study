package com.eomcs.oop.ex09.a1.after;

public class Exam02 {
  public static void main(String[] args) {
    work(new BlueWorker());
    work(new JubuWorker());
    work(new WhiteWorker());
  }

  // work(new HulWorker()); // HulWorker

  static void work(Worker worker) {
    worker.execute();
  }
}
