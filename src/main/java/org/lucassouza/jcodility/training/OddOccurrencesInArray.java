package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class OddOccurrencesInArray {

  public static void main(String[] args) {
    OddOccurrencesInArray test = new OddOccurrencesInArray();

    System.out.println(test.solution(new int[]{9, 3, 9, 3, 9, 7, 7}));
    System.out.println(test.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    System.out.println(test.solution(new int[]{1}));
  }

  public int solution(int[] a) {
    int last = 0;
    int ocurrence = 0;

    Arrays.sort(a);

    for (int n : a) {
      if (n != last) {
        if (ocurrence % 2 != 0) {
          return last;
        }

        last = n;
        ocurrence = 1;
      } else {
        ocurrence++;
      }
    }

    return last;
  }
}
