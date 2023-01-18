/**
 * Name: Jiali Han
 * Lab2: Position and Velocity
 * <p>
 * References:
 * 1. Default Constructor in Java:
 * https://www.freecodecamp.org/news/default-constructor-in-java/#:~:text=What%20is%20a%20default%20constructor,new%20Student()%3B%20myStudent.
 * 2. Java equals() and hashCode():
 * https://www.digitalocean.com/community/tutorials/java-equals-hashcode
 */

package distance;

/**
 * This is a class Point3D that represents a point in 3-D cartesian space.
 * Point3D includes:
 * A no-parameter constructor (aka the "default" constructor)
 * A constructor that take 3 integers, representing x, y, z in that order
 * Three "getter" methods called: getX, getY, getZ
 * A method that calculates and answers (returns) the distance between the current point and another point). It should have the signature:
 * double distanceTo(Point3D other)
 * An equals method that allows us to compare a Point3D instance to another Point3D object
 */
public class Point3D {

  private int x;
  private int y;
  private int z;

  /**
   * this is a non-parameter constructor for Point3D.
   */
  public Point3D() {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * this parameterized constructor takes in x, y, z integers in order.
   * Each parameter is of type int.
   *
   * @param x  a component for Point3D
   * @param y  a component for Point3D
   * @param z  a component for Point3D
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Return x integer of the Point3D.
   *
   * @return the x integer for Point3D.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Return y integer of the Point3D.
   *
   * @return the y integer for Point3D
   */
  public int getY() {
    return this.y;
  }

  /**
   * Return z integer of the Point3D.
   *
   * @return the z integer for Point3D
   */
  public int getZ() {
    return this.z;
  }

  /**
   * Return the distance between the current point and another point.
   * The formula is: distance = √( (x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)
   * @param other  a destination for Point3D
   * @return the distance between the current point and another point.
   */
  public double distanceTo(Point3D other) {
    double sumOfX = (other.getX() - this.x) * (other.getX() - this.x);
    double sumOfY = (other.getY() - this.y) * (other.getY() - this.y);
    double sumOfZ = (other.getZ() - this.z) * (other.getZ() - this.z);
    return Math.sqrt(sumOfX + sumOfY + sumOfZ);
  }

  /**
   * Return True or False based on the comparison of a Point3D instance and another Point3D object
   *
   * @param other  a Point3D object
   * @return True or False based on the comparison of a Point3D instance and another Point3D object
   */
  public boolean equals(Point3D other) {
    return this.hashCode() == other.hashCode();
  }
}
