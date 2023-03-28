/**
 * Name: Jiali Han
 * Project 01: Vector3D
 *
 * References:
 * 1. How to asssert an exception in JUnit:
 * https://junit.org/junit5/docs/current/user-guide/#extensions-exception-handling
 * https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown
 * 2. Online Calculator of Angles between vectors (for checking correctness)
 * https://onlinemschool.com/math/assistance/vector/angl/
 */

/**
 * This is a class that test all methods in class Vector3D.
 */
package project01;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Vector3DTest {

  private Vector3D vec1;
  private Vector3D vec2;
  // vec3 is only used to test edge case when vector's magnitude is 0
  private Vector3D vec3;

  @Before
  public void setUp() {
    this.vec1 = new Vector3D(0.00, 3.00, 4.00);
    this.vec2 = new Vector3D(1.00, 2.00, 2.00);
    this.vec3 = new Vector3D(0.00, 0.00, 0.00);
  }
  @Test
  public void testGetX() {
    Assertions.assertEquals(0.00, vec1.getX(), 0.001);
    Assertions.assertEquals(1.00, vec2.getX(), 0.001);
  }

  @Test
  public void testGetY() {
    Assertions.assertEquals(3.00, vec1.getY(), 0.001);
    Assertions.assertEquals(2.00, vec2.getY(), 0.001);
  }

  @Test
  public void testGetZ() {
    Assertions.assertEquals(4.00, vec1.getZ(), 0.001);
    Assertions.assertEquals(2.00, vec2.getZ(), 0.001);
  }

  @Test
  public void testToString() {
    // test case1: check if vec1's string has the expected result
    String actual1 = vec1.toString();
    String expected1 = "(0.00, 3.00, 4.00)";
    Assertions.assertEquals(expected1, actual1, "Message Error");

    // test case2: check if vec2's string has the expected result
    String actual2 = vec2.toString();
    String expected2 = "(1.00, 2.00, 2.00)";
    Assertions.assertEquals(expected2, actual2, "Message Error");

    // test case3: check if vec3's string has the expected result
    String actual3 = vec3.toString();
    String expected3 = "(0.00, 0.00, 0.00)";
    Assertions.assertEquals(expected3, actual3, "Message Error");
  }

  @Test
  public void getMagnitude() {
    // test case1: check if vec1's magnitude has the expected result
    Assertions.assertEquals(5.00, vec1.getMagnitude(), 0.001);

    // test case2: check if vec2's magnitude has the expected result
    Assertions.assertEquals(3.00, vec2.getMagnitude(), 0.001);

    // test case3: check if vec3's magnitude has the expected result
    Assertions.assertEquals(0.00, vec3.getMagnitude(), 0.001);
  }

  @Test
  public void testIllegalNormalize() {
    // Test case1: when vec3's magnitude is 0 or less, program throws IllegalStateException
    Exception exception = Assertions.assertThrows(IllegalStateException.class, ()
        -> vec3.normalize(), "Expected to throw IllegalStateException, but it didn't.");
  }

  @Test
  public void testNormalize() {
    // Test case2: when vec1's magnitude is more than 0; program returns a normalized version of vector
    double vec1Magnitude = vec1.getMagnitude();
    Vector3D expected1 = new Vector3D(0.00 / vec1Magnitude, 3.00 / vec1Magnitude , 4.00 / vec1Magnitude);
    Assertions.assertEquals(expected1.toString(), vec1.normalize().toString(), "Normalized version of this Vector has error.");

    // Test case3: when vec2's magnitude is more than 0; program returns a normalized version of vector
    double vec2Magnitude = vec2.getMagnitude();
    Vector3D expected2 = new Vector3D(1.00 / vec2Magnitude, 2.00 / vec2Magnitude, 2.00 / vec2Magnitude);
    Assertions.assertEquals(expected2.toString(), vec2.normalize().toString(), "Normalized version of this Vector has error.");
  }

  @Test
  public void testAdd() {
    // test case1: check if vec1 adds vec2 has the expected result
    Vector3D expected1 = new Vector3D(0.0 + 1.0, 3.0 + 2.0, 4.0 + 2.0);
    Assertions.assertEquals(expected1.toString(), vec1.add(vec2).toString(), "Addition of two vectors has error.");

    // test case2: check if vec2 adds vec3 has the expected result
    Vector3D expected2 = new Vector3D(1.0 + 0.0, 2.0 + 0.0, 2.0 + 0.0);
    Assertions.assertEquals(expected2.toString(), vec2.add(vec3).toString(), "Addition of two vectors has error.");

    // test case3: check if vec1 adds vec3 has the expected result
    Vector3D expected3 = new Vector3D(0.0 + 0.0, 3.0 + 0.0, 4.0 + 0.0);
    Assertions.assertEquals(expected3.toString(), vec1.add(vec3).toString(), "Addition of two vectors has error.");
  }

  @Test
  public void testMultiply() {
    // assume the @param constant is 2.0
    double constant = 2.0;

    // test case1: check if vec1 * 2.0 has the expected result
    Vector3D expected1 = new Vector3D(0.0 * 2.0, 3.0 * 2.0, 4.0 * 2.0);
    Assertions.assertEquals(expected1.toString(), vec1.multiply(constant).toString(), "Multiplication of two vectors has error.");

    // test case2: check if vec2 * 2.0 has the expected result
    Vector3D expected2 = new Vector3D(1.0 * 2.0, 2.0 * 2.0, 2.0 * 2.0);
    Assertions.assertEquals(expected2.toString(), vec2.multiply(constant).toString(), "Multiplication of two vectors has error.");

    // test case3: check if vec3 * 2.0 has the expected result
    Vector3D expected3 = new Vector3D(0.0 * 2.0, 0.0 * 2.0, 0.0 * 2.0);
    Assertions.assertEquals(expected3.toString(), vec3.multiply(constant).toString(), "Multiplication of two vectors has error.");
  }

  @Test
  public void testDotProduct() {
    // test case1: check if the dot product of vec1 and vec2 has the expected result
    double expected1 = 0.0 * 1.0 + 3.0 * 2.0 + 4.0 * 2.0;
    Assertions.assertEquals(expected1, vec1.dotProduct(vec2), 0.001);

    // test case2: check if the dot product of vec2 and vec3 has the expected result
    double expected2 = 1.0 * 0.0 + 2.0 * 0.0 + 2.0 * 0.0;
    Assertions.assertEquals(expected2, vec2.dotProduct(vec3), 0.001);

    // test case3: check if the dot product of vec1 and vec3 has the expected result
    double expected3 = 0.0 * 0.0 + 3.0 * 0.0 + 4.0 * 0.0;
    Assertions.assertEquals(expected3, vec1.dotProduct(vec3), 0.001);
  }

  @Test
  public void testIllegalAngle() {
    // Test case1: when magnitude is 0 or less, program throws IllegalStateException
    Exception exception = Assertions.assertThrows(IllegalStateException.class, ()
        -> vec3.angleBetween(vec1), "Expected to throw IllegalStateException, but it didn't.");
  }

  @Test
  public void testAngleBetween() {
    // test case2: check if the angle between vec1 and vec2 has the expected result
    double expected = 21.039469781317237;
    Assertions.assertEquals(expected, vec1.angleBetween(vec2), 0.001);
  }

  @Test
  public void testCrossProduct() {
    // test case1: check if the cross product of vec1 and vec2 has the expected result
    Vector3D expected1 = new Vector3D(-2, 4, -3);
    Assertions.assertEquals(expected1.toString(), vec1.crossProduct(vec2).toString(), "Cross product of two vectors has error.");

    // test case2: check if the cross product of vec2 and vec3 has the expected result
    Vector3D expected2 = new Vector3D(0.0, 0.0, 0.0);
    Assertions.assertEquals(expected2.toString(), vec2.crossProduct(vec3).toString(), "Cross product of two vectors has error.");

    // test case3: check if the cross product of vec1 and vec3 has the expected result
    Vector3D expected3 = new Vector3D(0.0, 0.0, 0.0);
    Assertions.assertEquals(expected3.toString(), vec1.crossProduct(vec3).toString(), "Cross product of two vectors has error.");
  }
}