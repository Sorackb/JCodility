package org.lucassouza.jcodility.training;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lucas
 */
public class FrogRiverOne {

  public static void main(String[] args) {
    FrogRiverOne test = new FrogRiverOne();

    System.out.println(test.solution(3, new int[]{1, 3, 1, 3, 2, 1, 3}));
    System.out.println(test.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
  }

  public int solution(int x, int[] a) {
    Set<Integer> numbers = new HashSet<>();

    for (int n = 1; n <= x; n++) {
      numbers.add(n);
    }

    for (int index = 0; index < a.length; index++) {
      int n = a[index];

      numbers.remove(n);

      if (numbers.isEmpty()) {
        return index;
      }
    }

    return -1;
  }
}
