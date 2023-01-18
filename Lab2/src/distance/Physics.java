/**
 * Name: Jiali Han
 * Lab2: Position and Velocity
 * <p>
 * References:
 * 1. Average velocity:
 * https://www.compadre.org/nexusph/course/Average_velocity#:~:text=Average%20velocity%20is%20calculated%20by,traveled%20by%20the%20total%20time.
 * 2. Average velocity calculator (for testing)
 * https://www.calculatorsoup.com/calculators/physics/velocity_avg.php
 */

package distance;


/**
 * This is a class called Physics.
 * This class is a "utility service" class.
 * It contains a single class method (not instance method) that calculates a unitless velocity
 * given two Point3D objects and an elapsed time.
 * Average velocity is the change in distance over change in time.
 * Consider that our point instances know how to calculate the distance for us
 * and if we supply a time delta (called elapsedTime), we can calculate average velocity.
 */
public class Physics {
  /**
   * Return velocity given two Point3D objects and an elapsed time.
   *
   * @param one  a Point3D object
   * @param two  a Point3D object
   * @param elapsedTime  an elapsed time
   * @return velocity given two Point3D objects and an elapsed time.
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime) throws IllegalArgumentException {
    if (elapsedTime <= 0) {
      throw new IllegalArgumentException("The time value provided cannot be zero or negative.");
    } else {
      double distance = one.distanceTo(two);
      return distance / elapsedTime;
    }
  }

  public static void main(String[] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1, 1, 1);
      System.out.println("Displacement = " + one.distanceTo((two)));
      double velocity = Physics.velocity(one, two, 5);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity);
      velocity = Physics.velocity(one, two, 0);
      System.out.println("Velocity = " + velocity);
    }
    catch(IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}
