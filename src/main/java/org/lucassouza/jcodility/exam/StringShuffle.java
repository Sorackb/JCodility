package org.lucassouza.jcodility.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lucas
 */
public class StringShuffle {

  public static void main(String[] args) {
    StringShuffle test = new StringShuffle();

    System.out.println(test.solution("abbabba")); // 4
    System.out.println(test.solution("codility")); // 0
  }

  public int solution(String s) {
    ArrayList<String> prefixes = new ArrayList<>();
    ArrayList<String> sufixes = new ArrayList<>();
    String prefix = "";
    String sufix = "";
    char[] word = s.toCharArray();

    prefixes.add("");
    sufixes.add("");

    for (int i = 0; i < word.length - 1; i++) {
      prefix = prefix + word[i];
      prefixes.add(prefix);
    }

    for (int i = word.length - 1; i > 0; i--) {
      sufix = word[i] + sufix;
      sufixes.add(sufix);
    }

    prefixes.retainAll(sufixes);

    String largest = Collections.max(prefixes, Comparator.comparing(element -> element.length()));

    return largest.length();
  }
}
