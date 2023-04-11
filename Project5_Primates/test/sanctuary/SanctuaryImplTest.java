/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package sanctuary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test all methods in SanctuaryImpl class.
 */
public class SanctuaryImplTest {

    private SanctuaryImpl sanctuary;
    private Monkey m1;
    private Monkey m2;
    private Monkey m3;
    private Monkey m4;
    private Monkey m5;

    /**
     * Create objects for tests set up.
     */
    @Before
    public void setUp() {
        sanctuary = new SanctuaryImpl();
        m1 = new Monkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m2 = new Monkey("Betty", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        m3 = new Monkey("Cecelia", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        m4 = new Monkey("Donald", Species.GUEREZA, Sex.MALE, Size.LARGE, 80, 7, Food.INSECTS, true);
        m5 = new Monkey("Edward", Species.TAMARIN, Sex.MALE, Size.MEDIUM, 60, 6, Food.LEAVES, true);
    }

    /**
     * Test whether SanctuaryImpl() constructor works correctly.
     */
    @Test
    public void testConstructor(){
        // initialize an empty sanctuary
        sanctuary = new SanctuaryImpl();
        sanctuary.addMonkeyToIsolation(m1);
        String actual = sanctuary.getAlphabetMonkeyList();
        String expected = "Amy ";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether creatMonkey() method work correctly.
     * Shows that monkeys are created correctly (4.1)
     */
    @Test
    public void testCreateMonkey() {
        // create a monkey with certain attributes
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        String actual = m1.toString();
        System.out.println(m1.toString());
        String expected = "name: Amy, sex: female, favorite food: fruits";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether creatMonkey() method work correctly
     * when given an invalid monkey attribute.
     * Verifies that an exception is thrown
     * if creating an invalid monkey is attempted (4.2)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateMonkeyException() {
        // case 1: when given name is null, empty or blank
        m1 = sanctuary.createMonkey(" ", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m1 = sanctuary.createMonkey("", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        m1 = sanctuary.createMonkey(null, Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);

        // case 2: when given sex is null or not FEMALE or MALE
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, null, Size.SMALL, 10, 3, Food.FRUITS, false);

        // case 3: when given size is null or not LARGE or MEDIUM or SMALL
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, null, 10, 3, Food.FRUITS, false);

        // case 4: when given weight is 0 or negative
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 0, 3, Food.FRUITS, false);
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, -10, 3, Food.FRUITS, false);

        // case 5: when given age is negative
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, -3, Food.FRUITS, false);

        // case 6: when given food is null
        m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, null, false);

        // case 7: when given species is null
        m1 = sanctuary.createMonkey("Amy", null, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
    }

    /**
     * Test whether addMonkeyToIsolation method works correctly.
     * Verifies that a monkey can be added to isolation successfully (4.3)
     */
    @Test
    public void testAddMonkeyToIsolation() {
        // add m1 to sanctuary
        sanctuary.addMonkeyToIsolation(m1);
        String actual = sanctuary.getAlphabetMonkeyList();
        String expected = "Amy ";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether addMonkeyToIsolation method works correctly
     * when given monkey already exists in the isolation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyToIsolationException1() {
        sanctuary.addMonkeyToIsolation(m1);
        // when adding an existing monkey to sanctuary, it should throw exception
        sanctuary.addMonkeyToIsolation(m1);
    }

    /**
     * Test whether addMonkeyToIsolation method works correctly
     * when given there's no more space in the isolation.
     * Verifies that a monkey cannot be added to isolation if it is already full (4.4)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyToIsolationException2() {
        sanctuary.addMonkeyToIsolation(m1);
        // when adding an existing monkey to sanctuary, it should throw exception
        sanctuary.addMonkeyToIsolation(m1);
    }

    /**
     * Test whether addMonkeyToEnclosure method works correctly.
     * verifies that a monkey can be moved from isolation to an enclosure (4.6)
     */
    @Test
    public void testAddMonkeyToEnclosure() {
        // all first-arrived monkey will be added to Isolation
        sanctuary.addMonkeyToIsolation(m3);
        // if it's healthy, then it can be added to Enclosure
        sanctuary.addMonkeyToEnclosure(m3);
        String actual = sanctuary.getAlphabetMonkeyList();
        String expected = "Cecelia ";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether addMonkeyToEnclosure method works correctly
     * when given monkey already exists in the sanctuary.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyToEnclosureException1() {
        // all first-arrived monkey will be added to Isolation
        sanctuary.addMonkeyToIsolation(m3);
        // if it's healthy, then it can be added to Enclosure
        sanctuary.addMonkeyToEnclosure(m3);
        // when adding an existing monkey to sanctuary, it should throw exception
        sanctuary.addMonkeyToEnclosure(m3);
    }

    /**
     * Test whether addMonkeyToEnclosure method works correctly
     * when given monkey is not healthy to put in Enclosure.
     * Verifies that a monkey cannot be added to an enclosure
     * if it has not been labelled as healthy. (4.5)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddMonkeyToEnclosureException2() {
        // initialize more monkeys for testing
        Monkey m6 = new Monkey("Finch", Species.HOWLER, Sex.MALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        Monkey m7 = new Monkey("Gina", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m8 = new Monkey("Hellen", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m9 = new Monkey("Iris", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m10 = new Monkey("Jasmine", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m11 = new Monkey("Karen", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m12 = new Monkey("Lilian", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m13 = new Monkey("Monica", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m14 = new Monkey("Nina", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m15 = new Monkey("Oliver", Species.SQUIRREL, Sex.MALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m16 = new Monkey("Peter", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m17 = new Monkey("Queen", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m18 = new Monkey("Riley", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m19 = new Monkey("Sam", Species.SQUIRREL, Sex.MALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m20 = new Monkey("Tim", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);

        // first add 20 monkeys to Isolation
        sanctuary.addMonkeyToIsolation(m1);
        sanctuary.addMonkeyToIsolation(m2);
        sanctuary.addMonkeyToIsolation(m3);
        sanctuary.addMonkeyToIsolation(m4);
        sanctuary.addMonkeyToIsolation(m5);
        sanctuary.addMonkeyToIsolation(m6);
        sanctuary.addMonkeyToIsolation(m7);
        sanctuary.addMonkeyToIsolation(m8);
        sanctuary.addMonkeyToIsolation(m9);
        sanctuary.addMonkeyToIsolation(m10);
        sanctuary.addMonkeyToIsolation(m11);
        sanctuary.addMonkeyToIsolation(m12);
        sanctuary.addMonkeyToIsolation(m13);
        sanctuary.addMonkeyToIsolation(m14);
        sanctuary.addMonkeyToIsolation(m15);
        sanctuary.addMonkeyToIsolation(m16);
        sanctuary.addMonkeyToIsolation(m17);
        sanctuary.addMonkeyToIsolation(m18);
        sanctuary.addMonkeyToIsolation(m19);
        sanctuary.addMonkeyToIsolation(m20);

        // add one more monkey will throw exception
        Monkey m21 = new Monkey("Unix", Species.DRILL, Sex.MALE, Size.LARGE, 50, 10, Food.EGGS, false);
        sanctuary.addMonkeyToIsolation(m21);
    }

    /**
     * Test whether getSingleEnclosureList method works correctly.
     * verifies that the list for a given enclosure is correct (4.8)
     */
    @Test
    public void testGetSingleEnclosureList() {
        // first add all monkeys to isolation
        sanctuary.addMonkeyToIsolation(m3);
        sanctuary.addMonkeyToIsolation(m4);
        sanctuary.addMonkeyToIsolation(m5);
        // then add them to Enclosure
        sanctuary.addMonkeyToEnclosure(m3);
        sanctuary.addMonkeyToEnclosure(m4);
        sanctuary.addMonkeyToEnclosure(m5);

        // produce a list of species for each kind
        String actual = sanctuary.getSingleEnclosureList(Species.HOWLER);
        String expected = "name: Cecelia, sex: female, favorite food: nuts\n";
        Assert.assertEquals(expected, actual);

        actual = sanctuary.getSingleEnclosureList(Species.GUEREZA);
        expected = "name: Donald, sex: male, favorite food: insects\n";
        Assert.assertEquals(expected, actual);

        actual = sanctuary.getSingleEnclosureList(Species.TAMARIN);
        expected = "name: Edward, sex: male, favorite food: leaves\n";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether getMonkeyList method works correctly.
     * verifies that the report of species that are currently being housed in the sanctuary is correct (4.7)
     */
    @Test
    public void testGetMonkeyList() {
        // first add all monkeys to isolation
        sanctuary.addMonkeyToIsolation(m1);
        sanctuary.addMonkeyToIsolation(m2);
        sanctuary.addMonkeyToIsolation(m3);
        sanctuary.addMonkeyToIsolation(m4);
        sanctuary.addMonkeyToIsolation(m5);
        // then add healthy ones to Enclosure
        sanctuary.addMonkeyToEnclosure(m3);
        sanctuary.addMonkeyToEnclosure(m4);
        sanctuary.addMonkeyToEnclosure(m5);

        // if correct, it should produce an alphabetical monkey list
        List<Monkey> actual = sanctuary.getMonkeyList();
        String expected = "[name: Amy, sex: female, favorite food: fruits, name: Betty, sex: female, favorite food: eggs, name: Cecelia, sex: female, favorite food: nuts, name: Donald, sex: male, favorite food: insects, name: Edward, sex: male, favorite food: leaves]";
        Assert.assertEquals(expected, actual.toString());
    }

    /**
     * Test whether getAlphabetMonkeyList method works correctly
     * by producing a string showing monkey names alphabetically.
     * verifies the list of all monkeys housed in the Sanctuary is ordered by name (4.9)
     */
    @Test
    public void testGetAlphabetMonkeyList() {
        // first add all monkeys to isolation
        sanctuary.addMonkeyToIsolation(m1);
        sanctuary.addMonkeyToIsolation(m2);
        sanctuary.addMonkeyToIsolation(m3);
        sanctuary.addMonkeyToIsolation(m4);
        sanctuary.addMonkeyToIsolation(m5);
        // then add healthy ones to Enclosure
        sanctuary.addMonkeyToEnclosure(m3);
        sanctuary.addMonkeyToEnclosure(m4);
        sanctuary.addMonkeyToEnclosure(m5);

        // if correct, it should produce a string showing monkey names alphabetically
        String actual = sanctuary.getAlphabetMonkeyList();
        String expected = "Amy Betty Cecelia Donald Edward ";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test whether addMonkeyToEnclosure method works correctly
     * when there's no monkey in sanctuary.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAlphabetMonkeyListException() {
        // when no monkey exists, this method should throw exception
        sanctuary.getAlphabetMonkeyList();
    }

    /**
     * Test whether getMonkey method works correctly.
     */
    @Test
    public void testGetMonkey() {
        sanctuary.addMonkeyToIsolation(m1);
        Monkey m1 = sanctuary.getMonkey("Amy");
        Assert.assertEquals("Amy", m1.getName());
    }

    /**
     * Test whether getMonkey method works correctly
     * when there's no such monkey in the sanctuary.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetMonkeyException() {
        // get a non-existing monkey from sanctuary should throw exception
        sanctuary.getMonkey("Amy");
    }

    /**
     * Test whether treatMonkey method works correctly.
     */
    @Test
    public void testTreatMonkey() {
        // first m1's health status is false
        Assert.assertFalse(m1.isHealthy());
        // after treatment, m1's health status is true
        sanctuary.treatMonkey(m1);
        Assert.assertTrue(m1.isHealthy());
    }

    /**
     * Test whether getIsolationMonkeyList method works correctly.
     */
    @Test
    public void testGetIsolationMonkeyList() {
        sanctuary.addMonkeyToIsolation(m1);
        sanctuary.addMonkeyToIsolation(m2);
        String expected = "Amy Betty ";
        Assert.assertEquals(expected, sanctuary.getIsolationMonkeyList().toString());
    }

    /**
     * Test whether getIsolationMonkeyList method works correctly
     * when there's no monkey in the ISOLATION.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetIsolationMonkeyListException() {
        // when no monkey in the isolation, this method should throw exception
        sanctuary.getIsolationMonkeyList();
    }

    /**
     * Test whether exist method works correctly.
     */
    @Test
    public void testExist() {
        Assert.assertFalse(sanctuary.exist(m1));
        sanctuary.addMonkeyToIsolation(m1);
        Assert.assertTrue(sanctuary.exist(m1));
    }
}