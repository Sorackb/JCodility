package org.lucassouza.jcodility.training;

/**
 *
 * @author Lucas
 */
public class TapeEquilibrium2 {

  public static void main(String[] args) {
    TapeEquilibrium2 test = new TapeEquilibrium2();

    System.out.println(test.solution(new int[]{}));
    System.out.println(test.solution(new int[]{3}));
    System.out.println(test.solution(new int[]{3, 1, 2, 4, 3}));
  }

  public int solution(int[] a) {
    int[] right = new int[a.length];
    int rightValue = 0;
    int leftValue = 0;
    Integer minor = null;

    for (int index = a.length - 1; index > 0; index--) {
      int value = a[index];

      if (index == a.length - 1) {
        rightValue = value;
      } else {
        rightValue = rightValue + value;
      }

      right[index] = rightValue;
    }

    for (int index = 0; index < a.length - 1; index++) {
      int value = a[index];
      int sum = right[index + 1];
      int total;

      leftValue = leftValue + value;
      total = Math.abs(leftValue - sum);

      if (minor == null || total < minor) {
        minor = total;
      }
    }

    return minor == null ? 0 : minor;
  }
}
