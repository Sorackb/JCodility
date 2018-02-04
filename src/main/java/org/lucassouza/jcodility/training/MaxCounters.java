package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class MaxCounters {

  public static void main(String[] args) {
    MaxCounters test = new MaxCounters();

    System.out.println(Arrays.toString(test.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
  }

  public int[] solution(int n, int[] a) {
    int[] counters = new int[n];
    int max = 0;

    Arrays.fill(counters, 0);

    for (int item : a) {
      int value;

      if (1 <= item && item <= n) {
        value = counters[item - 1] + 1;
        counters[item - 1] = value;

        if (value > max) {
          max = value;
        }
      } else if (n + 1 == item) {
        Arrays.fill(counters, max);
      }
    }

    return counters;
  }
}
