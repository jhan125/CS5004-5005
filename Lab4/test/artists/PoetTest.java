/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a class that test the Poet class.
 */
class PoetTest {
    private Poet poet;

    String[] genre5 = {"Autobiographical Fiction"};
    String[] awards2 = {"Pulitzer"};

    @BeforeEach
    public void setUp() {
        poet = new Poet("Maya Angelou", 86, genre5, awards2, "Random House");
    }
    @Test
    public void testGetAge() {
        assertEquals(86, poet.getAge());
    }

    @Test
    public void testGetName() {
        assertEquals("Maya Angelou", poet.getName());
    }

    @Test
    public void testGetGenres() {
        String[] expected1 = {"Autobiographical Fiction"};
        assertEquals(Arrays.toString(expected1), Arrays.toString(poet.getGenres()));
    }

    @Test
    public void testGetGenresAsSingleString() {
        assertEquals("[Autobiographical Fiction]", poet.getGenresAsSingleString());
    }

    @Test
    public void testGetAwards() {
        String[] awards = {"Pulitzer"};
        assertEquals(Arrays.toString(awards), Arrays.toString(poet.getAwards()));
    }

    @Test
    public void testReceiveAward() {
        String[] expected1 = {"Pulitzer", "Poet Awards"};
        poet.receiveAward("Poet Awards");
        assertTrue(Arrays.equals(poet.getAwards(), expected1));
    }

    @Test
    public void testToString() {
        String test = "My name is Maya Angelou\n" +
                "My age is 86\n" +
                "I am an POET\n" +
                "I make these types of poems: [Autobiographical Fiction]\n" +
                "My publishing company is: Random House\n";
        assertTrue(poet.toString().equalsIgnoreCase(test));
    }
}