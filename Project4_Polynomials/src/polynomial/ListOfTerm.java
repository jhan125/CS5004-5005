/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */


package polynomial;

/**
 * This interface represents a linked list.
 * It includes methods to perform operations on polynomial type.
 */
public interface ListOfTerm {
    /**
     * Takes in a coefficient, a power and add this term to polynomial.
     *
     * @param coefficient of the term
     * @param power of the term
     * @return the resulting list of terms
     * @throws IllegalArgumentException if the power is negative
     */
    ListOfTerm addTerm(int coefficient, int power) throws IllegalArgumentException;


    /**
     * Returns a new polynomial after adding other polynomial to this one
     *
     * @param other polynomial to be added
     * @return the resulting polynomial
     * @throws IllegalArgumentException if parameter is not the same concrete type
     *                                   as the current object.
     */
    Polynomial add(Polynomial other) throws IllegalArgumentException;

    /**
     * Returns coefficient of a term with given power.
     *
     * @param power of the term
     * @return its coefficient
     */
    int getCoefficient(int power);

    /**
     * Get the maximum degree of this polynomial.
     *
     * @return the maximum degree of this polynomial as a whole number
     */
    int getDegree();

    /**
     * Evaluate the value of this polynomial at the given value of the variable.
     *
     * @param x the value at which the polynomial is to be evaluated.
     * @return the value of the polynomial at x
     */
    double evaluate(double x);

    /**
     * Get the term of this polynomial.
     *
     * @return the term of this polynomial as Term
     */
    Term getTerm();

    /**
     * Get the rest of this list of terms.
     *
     * @return the rest of this list of terms.
     */
    ListOfTerm getRest();

    /**
     * Returns whether two objects are the same based on their string formats.
     *
     * @param other object
     * @return true if the 2 objects are same type and have same string format; false otherwise
     */
    @Override
    boolean equals(Object other);

    /**
     * Returns whether other list is the same with this one.
     *
     * @param other list with terms
     * @return true if the 2 lists have same term and same rest; false otherwise
     */
    boolean isSame(ListOfTerm other);

    /**
     * Returns a string contains the list of terms.
     *
     * @return concatenated string accumulator.
     */
    @Override
    String toString();
}
