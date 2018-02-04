package org.lucassouza.jcodility.training;

public class BinaryGap {

  public static void main(String[] args) {
    BinaryGap test = new BinaryGap();

    System.out.println(test.solution(1041));
    System.out.println(test.solution(1));
  }

  public int solution(int n) {
    boolean hasOne = false;
    int count = 0;
    int max = 0;

    do {
      int rest = n % 2;
      n = n / 2;

      if (rest == 1) {
        hasOne = true;

        if (count > max) {
          max = count;
        }

        count = 0;
      } else if (rest == 0 && hasOne) {
        count++;
      }
    } while (n > 0);

    return max;
  }
}
