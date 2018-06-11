package org.lucassouza.jcodility.exam;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class Similarity2 {

  public static void main(String[] args) {
    Similarity2 test = new Similarity2();

    System.out.println(test.solution(1213)); // 12
    System.out.println(test.solution(123)); // 6
    System.out.println(test.solution(100)); // 1
    System.out.println(test.solution(120)); // 4
    System.out.println(test.solution(1200)); // 6
    System.out.println(test.solution(12000)); // 8
    System.out.println(test.solution(312000)); // 60
    System.out.println(test.solution(212000)); // 30
    System.out.println(test.solution(0)); // 1
  }

  public int solution(int n) {
    Map<Integer, Integer> ocurrences = new HashMap<>();
    Integer total = this.splitDigits(n, ocurrences);
    Integer result;
    Integer[] values;

    values = ocurrences.values().toArray(new Integer[ocurrences.size()]);
    result = this.calculatePermutation(total, values);

    // Desconsidera os zeros no início
    if (ocurrences.containsKey(0)) {
      Double numberOfZeros = Double.valueOf(ocurrences.get(0));
      Double numberOfDigits = Double.valueOf(total);
      Double provisional = Double.valueOf(result);

      provisional = provisional - (provisional / (numberOfDigits / numberOfZeros));
      result = provisional.intValue();
    }

    return result;
  }

  public Integer calculatePermutation(Integer total, Integer... repetitions) {
    Long denominator = 1L;
    Long numerator;
    Long result;

    for (Integer combination : repetitions) {
      if (combination > 1) {
        denominator = denominator * this.factorial(combination);
      }
    }

    numerator = this.factorial(total);
    result = numerator / denominator;

    return result.intValue();
  }

  private Integer splitDigits(int n, Map<Integer, Integer> ocurrences) {
    Integer total = 0;

    while (n != 0) {
      int digit = n % 10;

      n = n / 10;

      if (ocurrences.containsKey(digit)) {
        ocurrences.put(digit, ocurrences.get(digit) + 1);
      } else {
        ocurrences.put(digit, 1);
      }

      total++;
    }

    return total;
  }

  private Long factorial(Integer number) {
    Long result = 1L;

    for (int factor = 2; factor <= number; factor++) {
      result = result * factor;
    }

    return result;
  }
}
