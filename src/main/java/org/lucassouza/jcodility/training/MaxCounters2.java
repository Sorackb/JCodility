package org.lucassouza.jcodility.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class MaxCounters2 {

  public static void main(String[] args) {
    MaxCounters2 test = new MaxCounters2();

    System.out.println(Arrays.toString(test.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}))); // [3, 2, 2, 4, 2]
  }

  public int[] solution(int n, int[] a) {
    int[] result = new int[n];
    Map<Integer, Integer> counters = new HashMap<>();
    int max = 0;
    int all = 0;

    for (int number : a) {
      int value;

      if (1 <= number && number <= n) {
        Integer aux = counters.get(number);

        aux = aux == null ? all : aux;
        value = aux + 1;
        counters.put(number, value);

        if (value > max) {
          max = value;
        }
      } else if (n + 1 == number) {
        all = max;
        counters.clear();
      }
    }

    for (int index = 0; index < n; index++) {
      Integer aux = counters.get(index + 1);

      aux = aux == null ? all : aux;
      result[index] = aux;
    }

    return result;
  }
}
