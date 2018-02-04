package org.lucassouza.jcodility.exam;

/**
 *
 * @author Lucas
 */
public class MayanTemple {

  public static void main(String[] args) {
    MayanTemple test = new MayanTemple();

    System.out.println(test.calculate(new Point2D[]{
      new Point2D(5, 15),
      new Point2D(20, 60),
      new Point2D(-5, -15),
      new Point2D(10, 30)
    }));
  }

  public int calculate(Point2D[] a) {
    Double[] distances = new Double[a.length];
    Point2D origin = new Point2D(0, 0); // Create a origin point
    int count = a.length;

    for (int i = 0; i < a.length; i++) {
      Point2D point1 = a[i];
      Double distance1 = distances[i];

      if (distance1 == null) { // if the distance between origin and this point isn't calculated yet, this will do the job
        distance1 = this.measure(origin, point1);
        distances[i] = distance1;
      }

      for (int j = i + 1; j < a.length; j++) {
        Point2D point2 = a[j];
        Double distance2 = distances[j];
        Double distanceOfPoints;

        if (distance2 == null) {
          distance2 = this.measure(origin, point2);
          distances[j] = distance2;
        }

        distanceOfPoints = this.measure(point1, point2);

        if (distance1 + distanceOfPoints == distance2 || distance2 + distanceOfPoints == distance1) {
          count--;
          break;
        }
      }
    }

    return count;
  }

  public double measure(Point2D p1, Point2D p2) {
    return Math.hypot(p1.x - p2.x, p1.y - p2.y);
  }
}
