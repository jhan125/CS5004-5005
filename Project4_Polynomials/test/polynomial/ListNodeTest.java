/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */

package polynomial;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * This class is to test class ListNode.
 */
public class ListNodeTest {
    private ListNode l1;
    private ListNode l2;

    @Before
    public void SetUp() {
        EmptyNode e = new EmptyNode();
        l1 = new ListNode(new Term(3, 3), e);  // " +3x^3"
        l2 = new ListNode(new Term(-2, 2), e); // " -2x^2"
    }

    @Test
    public void testAddTerm() {
        Assert.assertEquals(" +3x^3", l1.toString());

        // test case 1: add term with different power
        l1.addTerm(2, 2);
        Assert.assertEquals(" +3x^3 +2x^2", l1.toString());

        // test case 1: add term with different power
        l1.addTerm(3, 2);
        Assert.assertEquals(" +3x^3 +5x^2", l1.toString());

        l1.addTerm(-8, 0);
        Assert.assertEquals(" +3x^3 +5x^2 -8", l1.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTermException() {
        // test case : when adding term has negative power
        l1.addTerm(2, -2);
        l1.addTerm(3, -1);
    }


    @Test
    public void testAdd() {
        // test case 1: add polynomial with different power
        Polynomial p1 = new PolynomialImpl("-2x^2 +5");

        String actual = l1.add(p1).toString();
        String expected = "3x^3 -2x^2 +5";
        Assert.assertEquals(expected, actual);

        // test case 2: add polynomial with same power
        p1 = new PolynomialImpl("-2x^2");
        actual = l2.add(p1).toString();
        expected = "-4x^2";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCoefficient() {
        Assert.assertEquals(3, l1.getCoefficient(3));
        Assert.assertEquals(0, l1.getCoefficient(2));
        Assert.assertEquals(0, l2.getCoefficient(3));
        Assert.assertEquals(-2, l2.getCoefficient(2));
    }

    @Test
    public void testGetDegree() {
        Assert.assertEquals(3, l1.getDegree());
        Assert.assertEquals(2, l2.getDegree());

        l1.addTerm(-2, 1); // " +3x^3 -2x^1"
        Assert.assertEquals(3, l1.getDegree());

        l2.addTerm(5, 4); // " 5x^4 -2x^2"
        Assert.assertEquals(4, l2.getDegree());
    }

    @Test
    public void testEvaluate() {
        Assert.assertEquals(24, l1.evaluate(2), 0.1);
        Assert.assertEquals(-8, l2.evaluate(2), 0.1);
    }

    @Test
    public void testGetTerm() {
        // case 1: before adding term
        String expected1 = " +3x^3";
        Assert.assertEquals(expected1, l1.getTerm().toString());

        String expected2 = " -2x^2";
        Assert.assertEquals(expected2, l2.getTerm().toString());

        // case 2: add term with lower power than max degree
        l1.addTerm(-2, 1); // " +3x^3 -2x^1";
        Assert.assertEquals(expected1, l1.getTerm().toString());

        l2.addTerm(-2, 1); // " -2x^2 -2x^1";
        Assert.assertEquals(expected2, l2.getTerm().toString());

        // case 3: add term with higher power than max degree
        l1.addTerm(-2, 4); // " -2x^4 +3x^3 -2x^1";
        expected1 = " -2x^4";
        Assert.assertEquals(expected1, l1.getTerm().toString());

        l2.addTerm(-2, 3); // " -2x^3 -2x^2 -2x^1";
        expected2 = " -2x^3";
        Assert.assertEquals(expected2, l2.getTerm().toString());
    }

    @Test
    public void testGetRest() {
        // case 1: before adding term
        String expected1 = "";
        Assert.assertEquals(expected1, l1.getRest().toString());

        String expected2 = "";
        Assert.assertEquals(expected2, l2.getRest().toString());

        // case 2: add term with lower power than max degree
        l1.addTerm(-2, 1); // " +3x^3 -2x^1";
        expected1 = " -2x^1";
        Assert.assertEquals(expected1, l1.getRest().toString());

        l2.addTerm(-2, 1); // " -2x^2 -2x^1";
        expected2 = " -2x^1";
        Assert.assertEquals(expected2, l2.getRest().toString());

        // case 3: add term with higher power than max degree
        l1.addTerm(-2, 4); // " -2x^4 +3x^3 -2x^1";
        expected1 = " +3x^3 -2x^1";
        Assert.assertEquals(expected1, l1.getRest().toString());

        l2.addTerm(-2, 3); // " -2x^3 -2x^2 -2x^1";
        expected2 = " -2x^2 -2x^1";
        Assert.assertEquals(expected2, l2.getRest().toString());
    }

    @Test
    public void testIsSame() {
        ListNode l3 = new ListNode(new Term(-2, 4), new EmptyNode());
        l3.addTerm(3, 3);
        l3.addTerm(-2, 1);
        // l3 becomes " -2x^4 +3x^3 -2x^1"

        // l1 is " +3x^3"
        Assert.assertFalse(l1.isSame(l3));

        l1.addTerm(-2, 1);
        l1.addTerm(-2, 4);
        // l1 becomes " -2x^4 +3x^3 -2x^1"

        // But term and rest
        Assert.assertTrue(l1.isSame(l3));
    }

    @Test
    public void testEquals() {
        ListNode l3 = new ListNode(new Term(-2, 4), new EmptyNode());
        l3.addTerm(3, 3);
        l3.addTerm(-2, 1);
        // l3 becomes " -2x^4 +3x^3 -2x^1"

        // l1 is " +3x^3"
        Assert.assertFalse(l1.equals(l3));

        l1.addTerm(-2, 1);
        l1.addTerm(-2, 4);
        // l1 becomes " -2x^4 +3x^3 -2x^1"

        Assert.assertTrue(l1.equals(l3));
    }

    @Test
    public void testToString() {
        String expected1 = " +3x^3";
        Assert.assertEquals(expected1, l1.toString());

        String expected2 = " -2x^2";
        Assert.assertEquals(expected2, l2.toString());
    }
}