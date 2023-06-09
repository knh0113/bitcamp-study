package bitcamp.myapp;




public class Test {
  
  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다.

    bitcamp.util.Calculator.init(2);
    bitcamp.util.Calculator.multiple(3);
    bitcamp.util.Calculator.plus(7);
    bitcamp.util.Calculator.minus(2);
    bitcamp.util.Calculator.divide(2);
    
    System.out.println(bitcamp.util.Calculator.result);
    
  }
  
  
  
}
