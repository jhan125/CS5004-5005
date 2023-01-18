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

/**
 * This is a class Point3DTest that test all methods in class Point3D.
 */

package distance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

class Point3DTest {
  private Point3D point1;
  private Point3D point2;
  // point3 is to test equals method
  private Point3D point3;

  @Before
  void setUp() {
    this.point1 = new Point3D(1, 2, 3);
    this.point2 = new Point3D(0, 0, 0);
    this.point3 = new Point3D(1,2, 3);
  }

  @Test
  void getX() {
    Assertions.assertEquals(1, point1.getX(), 0.001);
    Assertions.assertEquals(0, point2.getX(), 0.001);
  }

  @Test
  void getY() {
    Assertions.assertEquals(2, point1.getY(), 0.001);
    Assertions.assertEquals(0, point2.getY(), 0.001);
  }

  @Test
  void getZ() {
    Assertions.assertEquals(3, point1.getZ(), 0.001);
    Assertions.assertEquals(0, point2.getZ(), 0.001);
  }

  @Test
  void distanceTo() {
    Assertions.assertEquals(3.7416573867739, point1.distanceTo(point2), 0.001);
  }

  @Test
  void testEquals() {
    // point1 and point1 have same hashcode, should return True
    Assertions.assertTrue(point1.equals(point1));
    // point1 and point2 have different hashcode, should return False
    Assertions.assertFalse(point1.equals(point2));
    // point1 and point3 have same x,y,z, but hashcode is different, should return False
    Assertions.assertFalse(point1.equals(point3));
  }
}