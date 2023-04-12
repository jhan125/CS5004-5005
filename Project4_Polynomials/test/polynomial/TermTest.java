/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */

package polynomial;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * This class is to test class Term.
 */
public class TermTest {
    private Term t1;
    private Term t2;


    @Before
    public void setUp() {
        t1 = new Term(3, 3);
        t2 = new Term(-2, 2);
    }

    @Test
    public void testTermConstructor() {
        t1 = new Term(3, 3);
        t2 = new Term(-2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTermException() {
        t1 = new Term(3, -3);
        t2 = new Term(-2, -2);
    }

    @Test
    public void testGetCoefficient() {
        Assert.assertEquals(3, t1.getCoefficient(), 0.1);
        Assert.assertEquals(-2, t2.getCoefficient(), 0.1);
    }

    @Test
    public void testGetDegree() {
        Assert.assertEquals(3, t1.getDegree(), 0.1);
        Assert.assertEquals(2, t2.getDegree(), 0.1);
    }

    @Test
    public void testEquals() {
        Term t3 = new Term(3, 3);
        Assert.assertTrue(t1.equals(t3));
        Assert.assertFalse(t1.equals(t2));
    }

    @Test
    public void testToString() {
        // case 1:
        Term t3 = new Term(0, 5);
        Assert.assertEquals("", t3.toString());
        // case 2:
        t3 = new Term(-1, 0);
        Assert.assertEquals(" -1", t3.toString());
        // case 3:
        t3 = new Term(+9, 0);
        Assert.assertEquals(" +9", t3.toString());
        // case 4:
        Assert.assertEquals(" +3x^3", t1.toString());
        // case 5:
        Assert.assertEquals(" -2x^2", t2.toString());
    }
}