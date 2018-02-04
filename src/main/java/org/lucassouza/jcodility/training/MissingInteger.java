package org.lucassouza.jcodility.training;

import java.util.Arrays;

public class MissingInteger {

  public static void main(String[] args) {
    MissingInteger test = new MissingInteger();

    System.out.println(test.solution(new int[]{1, 3, 6, 4, 1, 2}));
    System.out.println(test.solution(new int[]{1, 2, 3}));
    System.out.println(test.solution(new int[]{-1, -3}));
  }

  public int solution(int[] a) {
    Integer missing = 1;

    Arrays.sort(a);

    for (int number : a) {
      if (missing < number) {
        break;
      } else if (number > 0) {
        missing = number + 1;
      }
    }

    return missing;
  }
}
