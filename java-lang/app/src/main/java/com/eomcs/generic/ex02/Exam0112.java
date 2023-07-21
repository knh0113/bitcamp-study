// 파라미터 타입 레퍼런스와 인스턴스 - 상속 관계 : extends
package com.eomcs.generic.ex02;

public class Exam0112 {

  static class A {
  }
  static class B1 extends A {
  }
  static class B2 extends A {
  }
  static class C extends B1 {
  }

  static class Box<T> {
    void set(T obj) {}
  }
  /*
   * Object | A / \ B1 B2 | C
   */


  public static void main(String[] args) {
    Box<? extends B1> box1; // B1의 기능을 가지면 가능

    // box1 = new Box<A>(); // 컴파일 오류
    // box1 = new Box<Object>(); // 컴파일 오류
    box1 = new Box<B1>();
    box1 = new Box<C>();
  }
}


