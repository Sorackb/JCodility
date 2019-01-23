package org.lucassouza.jcodility.exam;

/**
 *
 * @author Lucas
 */
public class Nails {

  public static void main(String[] args) {
    Nails test = new Nails();

    System.out.println(test.solution(new int[]{ 1, 1, 1, 3, 3, 4, 5, 5, 5, 5 }, 11));
  }

  int solution(int[] A, int K) {
    int n = A.length;
    int best = 0;
    int count = 0;
    
    for (int i = 0; i < n - K - 1; i++) {
      if (A[i] == A[i + 1]) {
        count = count + 1;
      } else {
        count = 0;
      }
      if (count > best) {
        best = count;
      }
    }
    int result = best + 1 + K;

    return result > n ? n : result;
  }
}
