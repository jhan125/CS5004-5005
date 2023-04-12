/**
 * Project 4: Polynomials
 * Name: Jiali Han
 * Reference:
 * How to represent String format of a polynomial?
 * https://stackoverflow.com/questions/13424302/java-tostring-method-for-polynomial-terms
 */

package polynomial;

/**
 * This class represents a single term in a polynomial.
 * Each term includes coefficient and power.
 */
public class Term {
    private int coefficient; // can be updated
    private final int power; // can't be changed

    /**
     * Creates a polynomial term node with coefficient and power.
     *
     * @param coefficient as int
     * @param power as int
     * @throws IllegalArgumentException if power is negative
     */
    public Term(int coefficient, int power) throws IllegalArgumentException {
        if (power < 0) {
            throw new IllegalArgumentException("Power can't be negative!");
        }
        this.coefficient = coefficient;
        this.power = power;
    }

    /**
     * Gets the coefficient of the term in a polynomial
     *
     * @return coefficient of the term in a polynomial
     */
    public int getCoefficient() {
        return this.coefficient;
    }

    /**
     * Gets the power of the term in a polynomial
     *
     * @return power of the term in a polynomial
     */
    public int getDegree() {
        return this.power;
    }

    /**
     * Returns whether two polynomials are the same
     *
     * @param other the other polynomial needs to be compared
     * @return true if these two polynomials are same; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Term) {
            Term t = (Term)other;
            return coefficient == t.getCoefficient() && power == t.getDegree();
        }
        return false;
    }

    /**
     * Returns a string contains this term
     *
     * @return a string contains this term
     */
    @Override
    public String toString() {
        // case 1: when coefficient is 0
        if (this.coefficient == 0) {
            return "";
        }

        if (this.power == 0) {
            if (this.coefficient > 0) {
                // case 2: " +6"
                return String.format(" +%d", this.coefficient);
            } else {
                // case 3: " -6"
                return String.format(" %d", this.coefficient);
            }
        }

        if (this.coefficient > 0) {
            // case 4: " +6x^1"
            return String.format(" +%dx^%d", this.coefficient, this.power);
        } else {
            // case 5: " -6x^1"
            return String.format(" %dx^%d", this.coefficient, this.power);
        }
    }
}
