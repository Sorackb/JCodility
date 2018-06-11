package org.lucassouza.jcodility.exam;

public class IntegerPlay {

  public static void main(String[] args) {
    IntegerPlay test = new IntegerPlay();

    System.out.println(test.resolve(new int[]{3, 5, 1}));
  }

  public int resolve(int[] a) {
    int result = this.arrayToInt(a);

    result = 17 * result;
    result = this.sumDigits(result);

    return result;
  }

  public int resolve2(int[] a) {
    int result = this.arrayToInt2(a);

    result = 17 * result;
    result = this.sumDigits2(result);

    return result;
  }

  private int arrayToInt(int[] numbers) {
    int result = 0;
    int multiplier = 1;

    for (int number : numbers) {
      result = result + (number * multiplier);
      multiplier = multiplier * 10;
    }

    return result;
  }

  public int sumDigits(int number) {
    int result = 0;

    while (number != 0) {
      int digit = number % 10;
      number = number / 10;
      result = result + digit;
    }

    return result;
  }

  private int arrayToInt2(int[] numbers) {
    StringBuilder builder = new StringBuilder();
    int result;

    for (int number : numbers) {
      builder.append(number);
    }

    result = Integer.parseInt(builder.reverse().toString());

    return result;
  }

  public int sumDigits2(int number) {
    String text = String.valueOf(number);
    int result = 0;

    for (char digit : text.toCharArray()) {
      result = result + Character.getNumericValue(digit);
    }

    return result;
  }
}
