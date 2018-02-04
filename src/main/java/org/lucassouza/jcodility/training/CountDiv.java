package org.lucassouza.jcodility.training;

/**
 *
 * @author Lucas
 */
public class CountDiv {

  public static void main(String[] args) {
    CountDiv test = new CountDiv();

    System.out.println(test.solution(6, 11, 2)); // 3
  }

  public int solution(int a, int b, int k) {
    int count = 0;
    int rest;
    int aux;

    rest = a % k;
    aux = rest + a;

    while (aux <= b) {
      count++;
      aux = aux + k;
    }

    return count;
  }
}
