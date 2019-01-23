package org.lucassouza.jcodility.exam;

/**
 *
 * @author Lucas
 */
public class BinaryPeriod {

  public static void main(String[] args) {
    BinaryPeriod test = new BinaryPeriod();

    System.out.println(test.solution(955));
  }

  int solution(int n) {
    int[] d = new int[30];
    int l = 0;
    int p;
    while (n > 0) {
      d[l] = n % 2;
      n /= 2;
      l++;
    }
    for (p = 1; p < 1 + l; ++p) {
      int i;
      boolean ok = true;
      for (i = 0; i < l - p; ++i) {
        if (d[i] != d[i + p]) {
          ok = false;
          continue;
        }
      }
      if (ok) {
        return p;
      }
    }
    return -1;
  }
}
