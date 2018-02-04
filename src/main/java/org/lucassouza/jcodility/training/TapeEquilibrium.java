package org.lucassouza.jcodility.training;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class TapeEquilibrium {

  private Integer minor;

  public static void main(String[] args) {
    TapeEquilibrium test = new TapeEquilibrium();

    System.out.println(test.solution(new int[]{}));
    System.out.println(test.solution(new int[]{3}));
    System.out.println(test.solution(new int[]{3, 1, 2, 4, 3}));
  }

  public int solution(int[] a) {
    if (a.length > 1) {
      this.organize(a, 0, 0);
    } else if (a.length == 1) {
      this.minor = a[0];
    }

    return this.minor == null ? 0 : this.minor;
  }

  public int organize(int[] a, int index, int left) {
    int value = a[index];
    int aux;
    int result;

    if (index == a.length - 1) {
      return value;
    } else {
      aux = this.organize(a, index + 1, left + value);

      result = Math.abs((left + value) - aux);

      if (this.minor == null || this.minor > result) {
        this.minor = result;
      }

      return value + aux;
    }
  }
}
