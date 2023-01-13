/**
 * Name: Jiali Han
 * Project 01: Vector3D
 *
 * References:
 * 1. What is Vector Normalization:
 * https://www.khanacademy.org/computing/computer-programming/programming-natural-simulations/programming-vectors/a/vector-magnitude-normalization
 * 2. What's the intended use of IllegalState Exception:
 * https://stackoverflow.com/questions/12698275/whats-the-intended-use-of-illegalstateexception
 * 3. How to fix NaN while using Math.acos:
 * https://stackoverflow.com/questions/27538695/java-strange-nan-in-a-double-while-using-math-acos
 */

package project01;

/**
 * This is a class Vector3D that represents a 3D vector.
 * Vectors are commonly used in Math and physics. A vector (in 3D) is signified by a direction and a length (magnitude). It is commonly represented as three components: x, y and z.
 * Some operations on vectors include: Magnitude, Normalizing, Addition of two vectors,
 * Multiplying a vector by a constant, Dot Product, Angle between two vectors, and Cross product.
 */
public class Vector3D {

  private double x;
  private double y;
  private double z;

  /**
   * this constructor takes in x, y, z components of the vector.
   * Each parameter is of type double.
   *
   * @param x  a component for Vector3D
   * @param y  a component for Vector3D
   * @param z  a component for Vector3D
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * this method returns x component of the vector.
   *
   * @return the x component for Vector3D.
   */
  public double getX() {
    return this.x;
  }

  /**
   * this method returns y component of the vector.
   *
   * @return the y component for Vector3D
   */
  public double getY() {
    return this.y;
  }

  /**
   * this method returns z component of the vector.
   *
   * @return the z component for Vector3D
   */
  public double getZ() {
    return this.z;
  }

  /**
   * this method returns a string that decribes this vector.
   * this string should be of the form “(x, y, z)” replacing the letters
   * with their values each component should be formatted to round to
   * exactly two decimal places
   *
   * @return a string that decribes this vector.
   */
  public String toString() {
    return String.format("(%f, %f, %f)", x, y, z);
  }

  /**
   * this method returns the magnitude for this vector.
   * the magnitude of a vector is the length of the vector.
   * the formula v = (x, y, z) is: |v| =√(x^2 + y^2 + z^2)
   *
   * @return the magnitude of the vector.
   */
  public double getMagnitude() {
    double sum = x * x + y * y + z * z;
    return Math.sqrt(sum);
  }

  /**
   * this method a normalized version of this vector.
   * It should throw an IllegalStateException object if this operation cannot be completed.
   * Normalizing a vector is a vector that is obtained
   * by dividing each component of a vector by its magnitude.
   *
   * @return the normalized version of this vector
   * @throws IllegalStateException if the magnitude is 0 or less
   */
  public Vector3D normalize() throws IllegalStateException {
    if (getMagnitude() <= 0) {
      throw new IllegalStateException(
          "This operation cannot be completed because magnitude is 0 or less.");
    } else {
      double normalizedX = x / getMagnitude();
      double normalizedY = y / getMagnitude();
      double normalizedZ = z / getMagnitude();
      return new Vector3D(normalizedX, normalizedY, normalizedZ);
    }
  }

  /**
   * this method returns the result of adding this vector to another vector.
   * It should not change the vectors that are being added.
   * Addition of two vectors: a vector sum is a vector that is obtained by adding respective components of the two vectors.
   *
   * @param  newVec a vector that needs to be added.
   * @return a vector that is obtained by adding respective components of the two vectors
   */
  public Vector3D add(Vector3D newVec) {
    double sumX = x + newVec.x;
    double sumY = y + newVec.y;
    double sumZ = z + newVec.z;
    return new Vector3D(sumX, sumY, sumZ);
  }

  /**
   * this method returns the result of multiplying this vector by a constant.
   * It should not change the vectors that are being multiplied.
   * Multiplying a vector by a constant produces a vector obtained by multiplying each component of the current vector by the provided constant.
   *
   * @param  constant  a constant that needs to be multiplied
   * @return a vector that is obtained by adding respective components of the two vectors.
   */
  public Vector3D multiply(double constant) {
    double multiX = x * constant;
    double multiY = y * constant;
    double multiZ = z * constant;
    return new Vector3D(multiX, multiY, multiZ);
  }

  /**
   * this method returns the dot product of this vector and another vector.
   * It should not change the two vectors.
   * Dot product of two vectors v = (vx, vy, vz) and w = (wx, wy, wz) is defined as a number v * w = vx * wx + vy * wy + vz * wz
   *
   * @param  newVec    a vector that needs to be calculated to dot product
   * @return a number that is obtained by dot product formula
   */
  public double dotProduct(Vector3D newVec) {
    return x * newVec.x + y * newVec.y + z * newVec.z;
  }

  /**
   * this method returns the angle between two vectors in degrees.
   * It should not change the two vectors.
   * It should throw an IllegalStateException if this operation cannot be completed.
   * Angle between two vectors is defined as cos (v * w / magnitude(v) * magnitude(w)).
   * Technically, given two vectors, there are two angles between them.
   * This returns the smaller of the two angles.
   * For example, if the two vectors align with clock hands at 3PM, this would return 90 degrees.
   *
   * @param  newVec    a vector that needs to be calculated
   * @return a number that is obtained by angle between two vectors formula
   * @throws IllegalStateException if either vector's magnitude is 0 or less
   */
  public double angleBetween(Vector3D newVec) throws IllegalStateException {
    double vec1Magnitude = this.getMagnitude();
    double vec2Magnitude = newVec.getMagnitude();
    if (vec1Magnitude <= 0 || vec2Magnitude <= 0) {
      throw new IllegalStateException(
          "This operation cannot be completed because magnitude cannot be 0 or less.");
    } else {
      double dotProduct = this.dotProduct(newVec);
      double value = dotProduct / (vec1Magnitude * vec2Magnitude);
      double acos = Math.acos(value);
      return Math.toDegrees(acos);
    }
  }

  /**
   * this method returns the cross product of this vector and another vector.
   * It should not change the two vectors.
   * Cross product of two vectors v = (vx, vy, vz) and w = (wx, wy, wz) is defined
   * as another vector u = (ux, uy, uz) that is at right angles to both.
   * This resulting vector u can be calculated this way:
   * ux = vy * wz - vz * wy
   * uy = vz * wx - vx * wz
   * uz = vx * wy - vy * wx
   *
   * @param  newVec  a vector that needs to be calculated
   * @return the cross product as a vector that is obtained by the formula
   */
  public Vector3D crossProduct(Vector3D newVec) {
    double ux = y * newVec.z - z * newVec.y;
    double uy = z * newVec.x - x * newVec.z;
    double uz = x * newVec.y - y * newVec.x;
    return new Vector3D(ux, uy, uz);
  }
}
