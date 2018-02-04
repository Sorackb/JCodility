package org.lucassouza.jcodility.training;

/**
 *
 * @author Lucas
 */
public class FrogJmp {

  public static void main(String[] args) {
    FrogJmp test = new FrogJmp();
    
    System.out.println(test.solution(10, 85, 30));
  }

  public int solution(int x, int y, int d) {
    int distance = y - x;
    Double value = Math.ceil(distance / Double.valueOf(d));
    
    return value.intValue();
  }
}
