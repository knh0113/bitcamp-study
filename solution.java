public class solution {
  int[] num_list = [3, 4, 5, 2, 1];

  public int solution(int[] num_list) {
    int answer = 0;
    for (int i = 0; i < num_list.length; i++) {
      m *= num_list[i];
      p += num_list[i];
      if (m < p) {
        return 1;
      } else {
        return 0;
      }
    }
    return answer;
  }

}d