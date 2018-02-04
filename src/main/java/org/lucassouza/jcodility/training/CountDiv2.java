package org.lucassouza.jcodility.training;

/**
 *
 * @author Lucas
 */
public class CountDiv2 {

  public static void main(String[] args) {
    CountDiv2 test = new CountDiv2();

    System.out.println(test.solution(0, 1, 11)); // 1
    System.out.println(test.solution(6, 11, 2)); // 3
    System.out.println(test.solution(0, Integer.MAX_VALUE, Integer.MAX_VALUE)); // 1
  }

  public int solution(int a, int b, int k) {
    int div1 = a / k;
    int div2 = b / k;
    int count = div2 - div1;

    if (a % k == 0) {
      count++;
    }

    return count;
  }
}
