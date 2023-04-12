/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */

package polynomial;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * This class is to test class PolynomialImpl.
 */
public class PolynomialImplTest {
    private PolynomialImpl p1; // empty polynomial for testing
    private PolynomialImpl p2; // empty polynomial for testing


    @Before
    public void setUp() {
        p1 = new PolynomialImpl();
        p2 = new PolynomialImpl();
    }

    /**
     * Test verifies the no-argument constructor works correctly
     */
    @Test
    public void testNoArgConstructor() {
        Assert.assertEquals("0", p1.toString());
    }

    /**
     * Test verifies the string argument constructor works correctly
     * when given a valid non-zero polynomial with more than one term with unique powers
     */
    @Test
    public void testConstructor1() {
        Polynomial p3 = new PolynomialImpl("3x^4 -5x^3 +2x^1 -4");
        Polynomial p4 = new PolynomialImpl("2x^3 +2x^2 +4");

        String expected = "3x^4 -5x^3 +2x^1 -4";
        Assert.assertEquals(expected, p3.toString());

        expected = "2x^3 +2x^2 +4";
        Assert.assertEquals(expected, p4.toString());
    }

    /**
     * Test verifies the string argument constructor works correctly
     * when given a valid non-zero polynomial with more than one term with multiple terms with the same power
     */
    @Test
    public void testConstructor2() {
        Polynomial p3 = new PolynomialImpl("3x^4 -5x^4");
        Polynomial p4 = new PolynomialImpl("2x^2 +2x^2");

        String expected = "-2x^4";
        Assert.assertEquals(expected, p3.toString());

        expected = "4x^2";
        Assert.assertEquals(expected, p4.toString());
    }

    /**
     * Test verifies the string argument constructor works correctly
     * when given a constant polynomial (i.e. "2")
     */
    @Test
    public void testConstructor3() {
        Polynomial p3 = new PolynomialImpl("-5");
        Polynomial p4 = new PolynomialImpl("+22");

        String expected = "-5";
        Assert.assertEquals(expected, p3.toString());

        expected = "22";
        Assert.assertEquals(expected, p4.toString());
    }

    /**
     * Test verifies the string argument constructor works correctly
     * when given an empty string
     */
    @Test
    public void testConstructor4() {

        Polynomial p3 = new PolynomialImpl("");
        Polynomial p4 = new PolynomialImpl(" ");

        String expected = "0";
        Assert.assertEquals(expected, p3.toString());
        Assert.assertEquals(expected, p4.toString());
    }

    /**
     * Test verifies the string argument constructor throws an exception
     * when given an invalid string
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException() {
        // test cases 1 : when power is negative
        Polynomial test = new PolynomialImpl("3x^-1");

        // test cases 2 : when string has no polynomial format
        test = new PolynomialImpl("Polynomial");

        // test cases 3 : when there are two variables
        test = new PolynomialImpl("3x^-1y");
    }

    /**
     * Test verifies the add method works correctly
     * when two polynomials with multiple terms and unique powers are added
     * (i.e. there is no term with the same power in both polynomials)
     */
    @Test
    public void testAddDiffPower() {
        // add two polynomials with different powers
        Polynomial p3 = new PolynomialImpl("2x^4 +2x^1 -2");
        Polynomial p4 = new PolynomialImpl("2x^3 +2x^2");

        Polynomial res = p3.add(p4);
        String expected = "2x^4 +2x^3 +2x^2 +2x^1 -2";
        Assert.assertEquals(expected, res.toString());
    }

    /**
     * Test verifies the add method works correctly
     * when two polynomials with multiple terms and same powers are added
     * (i.e. there is no term with the same power in both polynomials)
     */
    @Test
    public void testAddSamePower() {
        // add two polynomials with same powers
        Polynomial p3 = new PolynomialImpl("2x^3 +2x^2 -2");
        Polynomial p4 = new PolynomialImpl("2x^3 +2x^2 +4");

        Polynomial res = p3.add(p4);
        String expected = "4x^3 +4x^2 +2";
        Assert.assertEquals(expected, res.toString());
    }

    /**
     * Test verifies the addTerm method works correctly
     * when terms with different powers or same powers are added
     */
    @Test
    public void testAddTerm() {
        // test cases 1: add terms with different powers to p1
        p1.addTerm(2, 3);
        Assert.assertEquals("2x^3", p1.toString());

        p1.addTerm(2, 0);
        Assert.assertEquals("2x^3 +2", p1.toString());

        p1.addTerm(3, 4);
        Assert.assertEquals("3x^4 +2x^3 +2", p1.toString());

        // test cases 2: add terms with same powers to p1
        p1.addTerm(-9, 3);

        p1.addTerm(5, 0);
        Assert.assertEquals("3x^4 -7x^3 +7", p1.toString());

        p1.addTerm(1, 4);
        Assert.assertEquals("4x^4 -7x^3 +7", p1.toString());
    }

    /**
     * Test verifies the addTerm method throws an IllegalArgumentException if the power is negative
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddTermException() {
        // test cases: add terms with negative power will throw IAE
        p2.addTerm(3, -1);
        p2.addTerm(3, -1);
    }

    /**
     * Test verifies the isSame method works correctly.
     */
    @Test
    public void testIsSame() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        p2 = new PolynomialImpl("2x^4 +2x^1 -2");
        Polynomial p3 = new PolynomialImpl("2x^3 +2x^2 +4");
        Assert.assertTrue(p1.isSame(p2));
        Assert.assertFalse(p1.isSame(p3));
    }

    /**
     * Test verifies the evaluate method works correctly for positive values of x
     */
    @Test
    public void testEvaluatePositive() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        Assert.assertEquals(166, p1.evaluate(3), 0.1);
        p2 = new PolynomialImpl("2x^3 +2x^1 -2");
        Assert.assertEquals(2, p2.evaluate(1), 0.1);
    }

    /**
     * Test verifies the evaluate method works correctly for negative values of x
     */
    @Test
    public void testEvaluateNegative() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        Assert.assertEquals(26, p1.evaluate(-2), 0.1);
        p2 = new PolynomialImpl("2x^3 +2x^1 -2");
        Assert.assertEquals(-62, p2.evaluate(-3), 0.1);
    }

    /**
     * Test verifies the getCoefficient method works correctly
     * when a term with the given power exists in the polynomial
     */
    @Test
    public void testGetCoefficient1() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        Assert.assertEquals(2, p1.getCoefficient(4), 0.1);
        Assert.assertEquals(2, p1.getCoefficient(1), 0.1);
        Assert.assertEquals(-2, p1.getCoefficient(0), 0.1);
    }

    /**
     * Test verifies the getCoefficient method works correctly
     * when no term with the given power exists in the polynomial (it should return 0)
     */
    @Test
    public void testGetCoefficient() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        Assert.assertEquals(0, p1.getCoefficient(2), 0.1);
        Assert.assertEquals(0, p1.getCoefficient(3), 0.1);
        Assert.assertEquals(0, p1.getCoefficient(6), 0.1);
    }

    /**
     * Test verifies the getDegree method works correctly
     * when the degree of a polynomial is a positive number
     */
    @Test
    public void testGetDegree1() {
        p1 = new PolynomialImpl("2x^4 +2x^1 -2");
        Assert.assertEquals(4, p1.getDegree(), 0.1);
    }

    /**
     * Test verifies the getDegree method returns 0
     * when the polynomial is a constant
     */
    @Test
    public void testGetDegree2() {
        p1 = new PolynomialImpl("-2");
        Assert.assertEquals(0, p1.getDegree(), 0.1);
    }

    /**
     * Test verifies toString works correctly when the polynomial has multiple terms
     */
    @Test
    public void testToString() {
        p1.addTerm(4,3);
        p1.addTerm(-2,2);
        p1.addTerm(8,1);
        p1.addTerm(-6,0);
        String expected = "4x^3 -2x^2 +8x^1 -6";
        Assert.assertEquals(expected, p1.toString());
    }
}