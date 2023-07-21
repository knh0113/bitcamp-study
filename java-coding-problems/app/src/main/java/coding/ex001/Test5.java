package coding.ex001;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class Test5 {

  public static void main(String[] args) {


    String str = "Be strong, be fearless, be beautiful. "
        + "And believe that anything is possible when you have the right "
        + "people there to support you. ";

    Map<Character, Integer> result = new HashMap<>(); // <키, value>

    for (char ch : str.toCharArray()) {
      result.compute(ch, (Character key, Integer value) ->
          (v == nult p,l) ? 1 : ++v);
        }
      return result;
      }


  for(

  Entry<Character, Integer> entry:result.entrySet())
  {
    System.out.printf("%c: %d\n", entry.getKey(), entry.getValue());
  }
  // char[] arr = str.toCharArray();
  // for(int i = 0; i < arr.length; i++) {
  // char ch = arr[i];
  // System.out.println(ch);
  // }

}

}
