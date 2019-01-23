package org.lucassouza.jcodility.exam;

/**
 *
 * @author Lucas
 */
public class BinaryOne {
  public static void main(String[] args) {
    BinaryOne test = new BinaryOne();

    System.out.println(test.solution(3, 7));
  }
  
  public int solution(int A, int B) {
    int number = A * B;
    int count = 0;
    
    while (number > 0) {
      number &= number - 1;
      count++;
    }

    return count;
  }
}
