/**
 * Project 4: Polynomials
 * Name: Jiali Han
 * Reference:
 * 1. What's the degree of a polynomial?  --> largest degree of individual terms
 * https://www.lsco.edu/learningcenter/Terminology-of-Polynomial-Expressions.pdf
 * 2. What is evaluating polynomials?
 * https://www.theproblemsite.com/reference/mathematics/algebra/polynomials/evaluating-polynomials
 * 3. How to split a string with whitespace chars as delimiters?
 * https://intellipaat.com/community/8931/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
 */


package polynomial;

/**
 * This class implements Polynomial interface and contains following features:
 * 1. only store terms with non-zero coefficients
 * 2. store polynomial terms in decreasing order of their powers
 * 3. have a constructor with no parameter
 * 4. have a constructor takes polynomial as a string, parses it, and creates the polynomial
 */
public class PolynomialImpl implements Polynomial{
    private ListOfTerm head;

    /**
     * Creates a polynomial with no parameter that creates a polynomial with no terms,
     * i.e. the polynomial 0
     */
    public PolynomialImpl() {
        head = new EmptyNode();
    }

    /**
     * Creates a polynomial that takes polynomial as a string, parses it, and then creates.
     * According to instructions, The polynomials we deal with have only positive, integral powers.
     * This class should store only terms with non-zero coefficients.
     *
     * @param polynomial that in the String format
     */
    public PolynomialImpl(String polynomial) {
        // if this is an empty or blank string
        if (polynomial.isEmpty()) {
            head = new EmptyNode();
            return;
        }

        head = new EmptyNode();
        String[] terms = polynomial.split("\\s+");

        // "3x^4 -5x^3 +2x -4" -> ["3x^4", "-5x^3", "+2x", "-4"]
        for (String t : terms) {
            t = t.trim();
            if (!t.contains("x")) {
                int coefficient = Integer.parseInt(t);
                head = (ListOfTerm) head.addTerm(coefficient, 0);
            } else {
                String[] values = t.split("x\\^");
                int coefficient = Integer.parseInt(values[0]);
                int power = Integer.parseInt(values[1]);
                head = (ListOfTerm) head.addTerm(coefficient, power);
            }
        }
    }

    /**
     * Add this polynomial to another and return the result as another polynomial.
     *
     * @param other the other polynomial to be added
     * @return the resulting polynomial
     * @throws IllegalArgumentException if parameter is not the same concrete type
     *                                  as the current object.
     */
    @Override
    public Polynomial add(Polynomial other) throws IllegalArgumentException {
        if (!(other instanceof PolynomialImpl)) {
            throw new IllegalArgumentException("Adding object must be the same concrete type as the Polynomial object.");
        }

        String s1 = this.toString();
        String s2 = other.toString();

        String add = s1 + " " + s2;
        Polynomial res = new PolynomialImpl(add);

        return res;
    }

    /**
     * Add a term to this polynomial with the specified coefficient and power.
     *
     * @param coefficient the coefficient of the term to be added
     * @param power       the power of the term to be added
     * @throws IllegalArgumentException if the power is negative
     */
    @Override
    public void addTerm(int coefficient, int power) throws IllegalArgumentException {
        // Cases where multiple terms have different powers / same power
        // can be seen in ListNode class
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative.");
        }
        // The terms of the polynomial are always maintained in a specific order
        head = head.addTerm(coefficient, power);
    }

    /**
     * Determines if this polynomial is the same as the parameter polynomial.
     *
     * @param poly the polynomial to use
     * @return true if this polynomial is of the same concrete type and has the same
     *         terms as the parameter, false otherwise
     */
    @Override
    public boolean isSame(Polynomial poly) {
        // check if two polynomials have same concrete type
        if (!(poly instanceof PolynomialImpl)) return false;

        PolynomialImpl other = (PolynomialImpl) poly;

        return head.equals(other.head);
    }

    /**
     * Evaluate the value of this polynomial at the given value of the variable.
     * e.g. Find the value of x^2 +3x + 2 when x = 7.
     * Solution: 7^2 + 3*7 + 2 = 49 + 21 + 2 = 72.
     *
     * @param x the value at which the polynomial is to be evaluated.
     * @return the value of the polynomial at x
     */
    @Override
    public double evaluate(double x) {
        return head.evaluate(x);
    }

    /**
     * Return the coefficient of the term with the given power.
     *
     * @param power the power whose coefficient is sought
     * @return the coefficient at the given power
     */
    @Override
    public int getCoefficient(int power) {
        return head.getCoefficient(power);
    }

    /**
     * Get the degree of this polynomial.
     *
     * @return the degree of this polynomial as a whole number
     */
    @Override
    public int getDegree() {
        return head.getDegree();
    }

    /**
     * Returns the string format of this polynomial.
     * A polynomial of nothing should return "0".
     * e.g. 5x2 + 4x - 2 creates the string "5x^2 +4x^1 -2"
     *
     * @return the string of this polynomial as String
     */
    @Override
    public String toString() {
        if (head instanceof EmptyNode) {
            return "0";
        }
        // process first term with no leading space
        String s = head.toString().replaceFirst(" ", "");

        // if s is empty, this polynomial is 0
        if (s.equals("")) {
            return "0";
        }

        // if s starts with +, delete that sign
        if (s.startsWith("+")) {
            s = s.substring(1);
        }

        return s.toString();
    }
}
