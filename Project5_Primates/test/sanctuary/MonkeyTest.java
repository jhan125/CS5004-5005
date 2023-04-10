/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package sanctuary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test all methods in Monkey class.
 */
public class MonkeyTest {
    private Monkey m1;
    private Monkey m2;
    private Monkey m3;
    private Monkey m4;


    /**
     * Create objects for tests set up.
     */
    @Before
    public void setUp(){
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m2 = new Monkey("Betty", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m3 = new Monkey("Cecelia", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        m4 = new Monkey("Donald", Species.GUEREZA, Sex.MALE, Size.LARGE, 80, 7, Food.INSECTS, true);
    }

    /**
     * Test whether Monkey() constructor works correctly.
     */
    @Test
    public void testConstructor() {
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        String expected = "name: Amy, sex: female, favorite food: fruits";
        Assert.assertEquals(expected, m1.toString());
    }

    /**
     * Test whether Monkey() method work correctly
     * when given an invalid monkey attribute.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException() {
        // case 1: when given name is null, empty or blank
        m1 = new Monkey(" ", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m1 = new Monkey("", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m1 = new Monkey(null, Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);

        // case 2: when given sex is null or not FEMALE or MALE
        m1 = new Monkey("Amy", Species.SQUIRREL, null, Size.SMALL, 10, 3, Food.FRUITS, false);

        // case 3: when given size is null or not LARGE or MEDIUM or SMALL
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, null, 10, 3, Food.FRUITS, false);

        // case 4: when given weight is 0 or negative
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 0, 3, Food.FRUITS, false);
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, -10, 3, Food.FRUITS, false);

        // case 5: when given age is negative
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, -3, Food.FRUITS, false);

        // case 6: when given food is null
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, null, false);

        // case 7: when given species is null
        m1 = new Monkey("Amy", null, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
    }

    /**
     * Test whether getName() constructor works correctly.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals("Amy", m1.getName());
        Assert.assertEquals("Betty", m2.getName());
    }

    /**
     * Test whether getSpecies() constructor works correctly.
     */
    @Test
    public void testGetSpecies() {
        Assert.assertEquals(Species.SQUIRREL, m1.getSpecies());
        Assert.assertEquals(Species.GUEREZA, m4.getSpecies());
    }

    /**
     * Test whether getAge() constructor works correctly.
     */
    @Test
    public void testGetAge() {
        Assert.assertEquals(3, m1.getAge(), 0.01);
        Assert.assertEquals(10, m2.getAge(), 0.01);
    }

    /**
     * Test whether getWeight() constructor works correctly.
     */
    @Test
    public void testGetWeight() {
        Assert.assertEquals(10, m1.getWeight(), 0.001);
        Assert.assertEquals(50, m2.getWeight(), 0.001);
    }

    /**
     * Test whether getSize() constructor works correctly.
     */
    @Test
    public void testGetSize() {
        Assert.assertEquals(Size.SMALL, m1.getSize());
        Assert.assertEquals(Size.LARGE, m4.getSize());
    }

    /**
     * Test whether isHealthy() constructor works correctly.
     */
    @Test
    public void testIsHealthy() {
        Assert.assertFalse(m1.isHealthy());
        Assert.assertFalse(m2.isHealthy());
        Assert.assertTrue(m3.isHealthy());
    }

    /**
     * Test whether toString() constructor works correctly.
     */
    @Test
    public void testToString() {
        String expected = "name: Amy, sex: female, favorite food: fruits";
        Assert.assertEquals(expected, m1.toString());
    }

    /**
     * Test whether makeHealthy() constructor works correctly.
     */
    @Test
    public void testMakeHealthy() {
        // before treatment, isHealthy status should be false
        Assert.assertFalse(m1.isHealthy());
        m1.makeHealthy();
        // after treatment, isHealthy status should be true
        Assert.assertTrue(m1.isHealthy());
    }


    /**
     * Test whether compareTo() constructor works correctly.
     */
    @Test
    public void testCompareTo() {
        Assert.assertEquals(-1, m1.compareTo(m2));
        Assert.assertEquals(-2, m1.compareTo(m3));
        Assert.assertEquals(3, m4.compareTo(m1));
    }
}