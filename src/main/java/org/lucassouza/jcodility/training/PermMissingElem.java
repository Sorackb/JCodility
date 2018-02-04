package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class PermMissingElem {

  public static void main(String[] args) {
    PermMissingElem test = new PermMissingElem();

    System.out.println(test.solution(new int[]{0}));
    System.out.println(test.solution(new int[]{2}));
    System.out.println(test.solution(new int[]{1, 2}));
    System.out.println(test.solution(new int[]{2, 3, 1, 5}));
  }

  public int solution(int[] a) {
    int missing = 1;

    Arrays.sort(a);

    for (int index = 0; index < a.length; index++) {
      int n = a[index];

      if (n != missing) {
        return missing;
      }

      missing = n + 1;
    }

    return missing;
  }
}
