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
public class EnclosureTest {
    private Enclosure enclosure;
    private Monkey m1;
    private Monkey m2;
    private Monkey m3;
    private Monkey m7;

    /**
     * Create objects for tests set up.
     */
    @Before
    public void setUp(){
        enclosure = new Enclosure();
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, true);
        m2 = new Monkey("Betty", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m3 = new Monkey("Cecelia", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        m7 = new Monkey("Gina", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, true);
    }

    /**
     * Test whether constructor works correctly.
     */
    @Test
    public void testConstructor() {
        enclosure = new Enclosure();
        String expected = "[]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());
    }

    /**
     * Test whether addMonkey() method works correctly.
     */
    @Test
    public void testAddMonkey() {
        // case 1: when this is the first new species
        enclosure.addMonkey(m1);
        String expected = "[name: Amy, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());
        expected = "name: Amy, sex: female, favorite food: fruits\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.SQUIRREL).toString());

        // case 2: when this species already exists, add it to same species enclosure
        enclosure.addMonkey(m7);
        expected = "[name: Amy, sex: female, favorite food: fruits, name: Gina, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());
        expected = "name: Amy, sex: female, favorite food: fruits\nname: Gina, sex: female, favorite food: fruits\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.SQUIRREL).toString());
    }

    /**
     * Test whether addMonkey() method works correctly
     * when this monkey already exists in Enclosure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyException1() {
        enclosure.addMonkey(m1);
        enclosure.addMonkey(m1);
    }

    /**
     * Test whether addMonkey() method works correctly
     * when this monkey is not healthy to put into Enclosure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyException2() {
        // m2's healthy status is false, which means unhealthy
        enclosure.addMonkey(m2);
    }

    /**
     * Test whether removeMonkey() method works correctly
     */
    @Test
    public void removeMonkey() {
        // add m1 and m3 to enclosure
        enclosure.addMonkey(m1);
        enclosure.addMonkey(m3);

        // remove m3 from enclosure, so only m1 left
        enclosure.removeMonkey(m3);
        String expected = "[name: Amy, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());
        expected = "name: Amy, sex: female, favorite food: fruits\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.SQUIRREL).toString());
    }

    /**
     * Test whether removeMonkey() method works correctly
     * when this monkey already does NOT exist in Enclosure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMonkeyException1() {
        enclosure.addMonkey(m3);
        enclosure.removeMonkey(m1);
    }

    /**
     * Test whether removeMonkey() method works correctly
     * when there is no monkey in the Enclosure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMonkeyException2() {
        enclosure.removeMonkey(m1);
    }

    /**
     * Test whether getMonkeyList() method works correctly.
     */
    @Test
    public void getMonkeyList() {
        // add m1 to enclosure
        enclosure.addMonkey(m1);
        String expected = "[name: Amy, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());

        // add m7 to enclosure
        enclosure.addMonkey(m7);
        expected = "[name: Amy, sex: female, favorite food: fruits, name: Gina, sex: female, favorite food: fruits]";
        Assert.assertEquals(expected, enclosure.getMonkeyList().toString());
    }

    /**
     * Test whether exist() method works correctly.
     */
    @Test
    public void exist() {
        enclosure.addMonkey(m1); // Add "Amy" to Enclosure
        Assert.assertTrue(enclosure.exist("Amy"));
        Assert.assertFalse(enclosure.exist("Betty"));
    }

    /**
     * Test whether getSingleEnclosureList() method works correctly
     * when we add new / exisiting species monkey to Enclosure.
     */
    @Test
    public void testGetSingleEnclosureList() {
        // case 1: when we add the first new species
        enclosure.addMonkey(m1);
        String expected = "name: Amy, sex: female, favorite food: fruits\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.SQUIRREL).toString());

        // case 3: when this species already exists, add it to same species enclosure
        enclosure.addMonkey(m7);
        expected = "name: Amy, sex: female, favorite food: fruits\nname: Gina, sex: female, favorite food: fruits\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.SQUIRREL).toString());

        // case 4: when we add another monkey with new species
        enclosure.addMonkey(m3);
        expected = "name: Cecelia, sex: female, favorite food: nuts\n";
        Assert.assertEquals(expected, enclosure.getSingleEnclosureList(Species.HOWLER).toString());
    }

    /**
     * Test whether getSingleEnclosureList method works correctly
     * when this monkey species already does NOT exist in Enclosure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSingleEnclosureListException() {
        // we only add Species.SQUIRREL so there's no single enclosure list for HOWLER
        enclosure.addMonkey(m1);
        enclosure.getSingleEnclosureList(Species.HOWLER);
    }

}