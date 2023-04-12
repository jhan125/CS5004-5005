/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */

package polynomial;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * This class is to test class EmptyNode.
 */
public class EmptyNodeTest {
    private EmptyNode e1;
    private EmptyNode e2;

    @Before
    public void SetUp() {
        e1 = new EmptyNode();
        e2 = new EmptyNode();
    }

    @Test
    public void testAddTerm() {
        Assert.assertEquals(" +1x^1", e1.addTerm(1, 1).toString());
        Assert.assertEquals(" -1", e1.addTerm(-1, 0).toString());
    }

    @Test
    public void add() {
        Polynomial p1 = new PolynomialImpl("9x^2");
        Assert.assertEquals("9x^2", e1.add(p1).toString());

        Polynomial p2 = new PolynomialImpl("-100");
        Assert.assertEquals("9x^2 -100", e1.add(p1).add(p2).toString());
    }

    @Test
    public void getCoefficient() {
        Assert.assertEquals(0, e1.getCoefficient(2), 0.1);
        Assert.assertEquals(0, e2.getCoefficient(3), 0.1);
    }

    @Test
    public void getDegree() {
        Assert.assertEquals(0, e1.getDegree(), 0.1);
        Assert.assertEquals(0, e2.getDegree(), 0.1);
    }

    @Test
    public void evaluate() {
        Assert.assertEquals(0, e1.evaluate(100), 0.1);
        Assert.assertEquals(0, e2.evaluate(2), 0.1);
    }

    @Test
    public void getTerm() {
        Assert.assertNull(e1.getTerm());
        Assert.assertNull(e2.getTerm());
    }

    @Test
    public void getRest() {
        Assert.assertNull(e1.getRest());
        Assert.assertNull(e2.getRest());
    }

    @Test
    public void isSame() {
        Assert.assertTrue(e1.isSame(e2));
        ListNode l = new ListNode(new Term(3, 3), new EmptyNode());
        Assert.assertFalse(e1.isSame(l));
    }

    @Test
    public void testEquals() {
        // both e1 and e2 are empty nodes
        Assert.assertTrue(e1.equals(e2));

        // l is a ListNode with term " +3x^3"
        ListNode l = new ListNode(new Term(3, 3), new EmptyNode());
        Assert.assertFalse(e1.equals(l));

        // after adding term(3, 3) to e1
        Assert.assertEquals(l.toString(), e1.addTerm(3,3).toString());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("", e1.toString());
        Assert.assertEquals(" +3x^3", e1.addTerm(3,3).toString());
    }
}