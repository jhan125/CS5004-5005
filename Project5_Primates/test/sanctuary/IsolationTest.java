/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package sanctuary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test all methods in Isolation class.
 */
public class IsolationTest {
    private Isolation isolation;
    private Monkey m1;
    private Monkey m2;
    private Monkey m3;
    private Monkey m4;
    private Monkey m5;
    private Monkey m6;
    private Monkey m7;
    private Monkey m8;
    private Monkey m9;
    private Monkey m10;
    private Monkey m11;
    private Monkey m12;
    private Monkey m13;
    private Monkey m14;
    private Monkey m15;
    private Monkey m16;
    private Monkey m17;
    private Monkey m18;
    private Monkey m19;
    private Monkey m20;

    /**
     * Create objects for tests set up.
     */
    @Before
    public void setUp() {
        isolation = new Isolation();
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m2 = new Monkey("Betty", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m3 = new Monkey("Cecelia", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        m4 = new Monkey("Donald", Species.SQUIRREL, Sex.MALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m5 = new Monkey("Edward", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m6 = new Monkey("Finch", Species.HOWLER, Sex.MALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        m7 = new Monkey("Gina", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m8 = new Monkey("Hellen", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m9 = new Monkey("Iris", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m10 = new Monkey("Jasmine", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m11 = new Monkey("Karen", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m12 = new Monkey("Lilian", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m13 = new Monkey("Monica", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m14 = new Monkey("Nina", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m15 = new Monkey("Oliver", Species.SQUIRREL, Sex.MALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m16 = new Monkey("Peter", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m17 = new Monkey("Queen", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m18 = new Monkey("Riley", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m19 = new Monkey("Sam", Species.SQUIRREL, Sex.MALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m20 = new Monkey("Tim", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
    }

    /**
     * Test whether constructor works correctly.
     */
    @Test
    public void testConstructor() {
        isolation = new Isolation();
        String expected = "[]";
        Assert.assertEquals(expected, isolation.getMonkeyList().toString());
    }

    /**
     * Test whether isFull() method works correctly.
     */
    @Test
    public void testIsFull() {
        // if 0 monkey is added to isolation
        Assert.assertFalse(isolation.isFull());

        // if 3 monkeys are added to isolation
        isolation.addMonkey(m1);
        isolation.addMonkey(m2);
        isolation.addMonkey(m3);
        Assert.assertFalse(isolation.isFull());

        isolation.addMonkey(m4);
        isolation.addMonkey(m5);
        isolation.addMonkey(m6);
        isolation.addMonkey(m7);
        isolation.addMonkey(m8);
        isolation.addMonkey(m9);
        isolation.addMonkey(m10);
        isolation.addMonkey(m11);
        isolation.addMonkey(m12);
        isolation.addMonkey(m13);
        isolation.addMonkey(m14);
        isolation.addMonkey(m15);
        isolation.addMonkey(m16);
        isolation.addMonkey(m17);
        isolation.addMonkey(m18);
        isolation.addMonkey(m19);
        isolation.addMonkey(m20);
        // if 17 monkeys are added to isolation
        Assert.assertTrue(isolation.isFull());
    }

    /**
     * Test whether addMonkey() method works correctly.
     */
    @Test
    public void testAddMonkey() {
        isolation.addMonkey(m1);
        System.out.println(isolation.getMonkeyList());
        String expected = "[name: Amy, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, isolation.getMonkeyList().toString());
    }

    /**
     * Test whether addMonkey() method works correctly
     * when this monkey already exists in Isolation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyException1() {
        isolation.addMonkey(m1);
        isolation.addMonkey(m1);
    }

    /**
     * Test whether addMonkey() method works correctly
     * when the isolation is full and no more monkey shall be added.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyException2() {
        // first add 20 monkeys to Isolation
        isolation.addMonkey(m1);
        isolation.addMonkey(m2);
        isolation.addMonkey(m3);
        isolation.addMonkey(m4);
        isolation.addMonkey(m5);
        isolation.addMonkey(m6);
        isolation.addMonkey(m7);
        isolation.addMonkey(m8);
        isolation.addMonkey(m9);
        isolation.addMonkey(m10);
        isolation.addMonkey(m11);
        isolation.addMonkey(m12);
        isolation.addMonkey(m13);
        isolation.addMonkey(m14);
        isolation.addMonkey(m15);
        isolation.addMonkey(m16);
        isolation.addMonkey(m17);
        isolation.addMonkey(m18);
        isolation.addMonkey(m19);
        isolation.addMonkey(m20);
        // add one more monkey will throw exception
        Monkey m21 = new Monkey("Unix", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
        isolation.addMonkey(m21);
    }

    /**
     * Test whether removeMonkey() method works correctly.
     */
    @Test
    public void testRemoveMonkey() {
        isolation.addMonkey(m1);
        String expected = "[name: Amy, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, isolation.getMonkeyList().toString());

        isolation.removeMonkey(m1);
        expected = "[]";
        Assert.assertEquals(expected, isolation.getMonkeyList().toString());
    }

    /**
     * Test whether removeMonkey() method works correctly
     * when the isolation is empty and no more monkey can be removed.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMonkeyException() {
        isolation.removeMonkey(m1);
    }

    /**
     * Test whether getMonkey() method works correctly.
     */
    @Test
    public void testGetMonkeyList() {
        isolation.addMonkey(m1);
        isolation.addMonkey(m2);
        System.out.println(isolation.getMonkeyList());
        String expected = "[name: Amy, sex: female, favorite food: fruits, name: Betty, sex: female, favorite food: eggs]";
        Assert.assertEquals(expected, isolation.getMonkeyList().toString());
    }

    /**
     * Test whether exist() method works correctly.
     */
    @Test
    public void testExist() {
        isolation.addMonkey(m1); // Add "Amy" to isolation
        Assert.assertTrue(isolation.exist("Amy"));
        Assert.assertFalse(isolation.exist("Betty"));
    }
}