package org.lucassouza.jcodility.training;

/**
 *
 * @author Lucas
 */
public class PassingCars {

  public static void main(String[] args) {
    PassingCars test = new PassingCars();

    System.out.println(test.solution(new int[]{0, 1, 0, 1, 1})); // 5
    System.out.println(test.solution(new int[]{0, 1, 0, 1, 1, 0, 1})); // 8
  }

  public int solution(int[] a) {
    int count = 0;
    int east = 0;

    for (int n : a) {
      if (n == 0) {
        east++;
        continue;
      }

      count = count + east;

      if (count > 1000000000) {
        return -1;
      }
    }

    return count;
  }
}
