package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class CyclicRotation {

  public static void main(String[] args) {
    CyclicRotation test = new CyclicRotation();

    System.out.println(Arrays.toString(test.solution(new int[]{}, 10)));
    System.out.println(Arrays.toString(test.solution(new int[]{3, 8}, 3)));
    System.out.println(Arrays.toString(test.solution(new int[]{3, 8, 9, 7, 6}, 3)));
  }

  public int[] solution(int[] a, int k) {
    int[] result;

    if (a.length == 0) {
      return a;
    }

    k = k % a.length; // if the interval is bigger than array length

    if (k == 0) {
      return a;
    }

    result = new int[a.length];

    for (int index = 0; index < a.length; index++) {
      int element = a[index];

      if (index + k < result.length) {
        result[index + k] = element;
      } else {
        result[(index + k) - (result.length)] = element;
      }
    }

    return result;
  }
}
