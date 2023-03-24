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
 * This is a class that test the Actor class.
 */
class ActorTest {
    private Actor denzel;
    private Actor melissa;
    String[] genre1 = {"Action", "SciFi", "Drama"};
    String[] genre3 = {"Comedy", "Romantic Comedy"};
    String[] awards = {"Academy Award", "Golden Globe"};
    String[] awards3 = {"Emmy", "People's Choice"};
    String[] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String[] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    @BeforeEach
    public void setUp() {
        denzel = new Actor("Denzel Washington", 67, genre1, awards, movies);
        melissa = new Actor("Melissa McCarthy", 52, genre3, awards3, movies3);
    }
    @Test
    public void testGetAge() {
        assertEquals(67, denzel.getAge());
        assertEquals(52, melissa.getAge());
    }

    @Test
    public void testGetName() {
        assertEquals("Denzel Washington", denzel.getName());
        assertEquals("Melissa McCarthy", melissa.getName());
    }

    @Test
    public void testGetGenres() {
        String[] expected1 = {"Action", "SciFi", "Drama"};
        assertEquals(Arrays.toString(expected1), Arrays.toString(denzel.getGenres()));

        String[] expected2 = {"Comedy", "Romantic Comedy"};
        assertEquals(Arrays.toString(expected2), Arrays.toString(melissa.getGenres()));
    }

    @Test
    public void testGetGenresAsSingleString() {
        assertEquals("[Action, SciFi, Drama]", denzel.getGenresAsSingleString());
        assertEquals("[Comedy, Romantic Comedy]", melissa.getGenresAsSingleString());
    }

    @Test
    public void testGetAwards() {
        String[] awards = {"Academy Award", "Golden Globe"};
        assertEquals(Arrays.toString(awards), Arrays.toString(denzel.getAwards()));

        String[] awards3 = {"Emmy", "People's Choice"};
        assertEquals(Arrays.toString(awards3), Arrays.toString(melissa.getAwards()));
    }

    @Test
    public void testReceiveAward() {
        String[] expected1 = {"Academy Award", "Golden Globe", "SAG Awards"};
        denzel.receiveAward("SAG Awards");
        assertTrue(Arrays.equals(denzel.getAwards(), expected1));

        String[] expected2 = {"Emmy", "People's Choice", "SAG Awards"};
        melissa.receiveAward("SAG Awards");
        assertTrue(Arrays.equals(melissa.getAwards(), expected2));
    }

    @Test
    public void testToString() {
        String test = "My name is Denzel Washington\n" +
                "My age is 67\n" +
                "I am an ACTOR\n" +
                "I make these types of movies: [Action, SciFi, Drama]\n" +
                "I have acted in these movies: [Glory, Flight, Training Day, Book of Eli, Fences]\n";
        assertTrue(denzel.toString().equalsIgnoreCase(test));

        test = "My name is Melissa McCarthy\n" +
                "My age is 52\n" +
                "I am an ACTOR\n" +
                "I make these types of movies: [Comedy, Romantic Comedy]\n" +
                "I have acted in these movies: [Bridesmaids, Tammy, Life of the Party, Ghostbusters]\n";
        assertTrue(melissa.toString().equalsIgnoreCase(test));
    }
}