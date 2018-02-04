package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class PermCheck {

  public static void main(String[] args) {
    PermCheck test = new PermCheck();

    System.out.println(test.solution(new int[]{4, 1, 3, 2}));
    System.out.println(test.solution(new int[]{4, 1, 3}));
  }

  public int solution(int[] a) {
    int missing = 1;
    int result = 1;

    Arrays.sort(a);

    for (int index = 0; index < a.length; index++) {
      int n = a[index];

      if (n != missing) {
        result = 0;
        break;
      }

      missing = n + 1;
    }

    return result;
  }
}
