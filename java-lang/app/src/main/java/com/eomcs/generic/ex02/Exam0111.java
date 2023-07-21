// 파라미터 타입 - 상속 관계 : extneds
package com.eomcs.generic.ex02;

public class Exam0111 {

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
    Box<B1> box1;

    // box1 = new Box<A>(); // 컴파일 오류
    // box1 = new Box<Object>(); // 컴파일 오류
    box1 = new Box<B1>();
    // box1 = new Box<C>(); // 컴파일 오류
  }
}


