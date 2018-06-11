package org.lucassouza.jcodility.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lucas
 */
public class Similarity {

  public static void main(String[] args) {
    Similarity test = new Similarity();

    System.out.println(test.solution(1213)); // 12
    System.out.println(test.solution(123)); // 6
    System.out.println(test.solution(100)); // 1
    System.out.println(test.solution(120)); // 4
    System.out.println(test.solution(1200)); // 6
    System.out.println(test.solution(12000)); // 8
    System.out.println(test.solution(120000)); // 10
    System.out.println(test.solution(301020)); // 60
    System.out.println(test.solution(201020)); // 30
    System.out.println(test.solution(0)); // 1
  }

  public int solution(int n) {
    List<List<Integer>> permutations;
    List<Integer> list = new ArrayList<>();
    Set<Integer> numbers = new HashSet<>();

    while (n != 0) {
      int digit = n % 10;
      n = n / 10;
      list.add(digit);
    }

    permutations = permute(list.toArray(new Integer[list.size()]));

    for (List<Integer> representation : permutations) {
      Integer number = 0;
      int multiplier = 1;
      boolean jump = false;

      for (int i = representation.size() - 1; i >= 0; i--) {
        Integer digit = representation.get(i);

        if (i == representation.size() - 1 && digit == 0) {
          jump = true;
        }

        number = number + (digit * multiplier);
        multiplier = multiplier * 10;
      }

      if (!jump) {
        numbers.add(number);
      }
    }

    return numbers.size();
  }

  public List<List<Integer>> permute(Integer[] numbers) {
    List<List<Integer>> permutations = new ArrayList<>();
    permutations.add(new ArrayList<>());

    for (int i = 0; i < numbers.length; i++) {
      List<List<Integer>> current = new ArrayList<>();

      for (List<Integer> permutation : permutations) {
        for (int j = 0, n = permutation.size() + 1; j < n; j++) {
          List<Integer> temp = new ArrayList<>(permutation);
          temp.add(j, numbers[i]);
          current.add(temp);
        }
      }
      permutations = new ArrayList<>(current);
    }

    return permutations;
  }
}
