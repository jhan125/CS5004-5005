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
 * This is a class that test the Musician class.
 */
class MusicianTest {
    private Musician musician;
    private Musician musician2;

    String[] genre2 = {"Rock", "Rock-Soul"};
    String[] genre4 = {"R&B", "Pop", "Rap"};
    String[] awards4 = {"Grammy", "American Music Award"};
    String[] awards5 = {"Grammy", "Billboard"};

    @BeforeEach
    public void setUp() {
        musician = new Musician("Bruce Springsteen", 73, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");

        musician2 = new Musician("Lizzo", 34, genre4, awards5,
                "Special", "Atlantic Records");
    }
    @Test
    public void testGetAge() {
        assertEquals(73, musician.getAge());
        assertEquals(34, musician2.getAge());
    }

    @Test
    public void testGetName() {
        assertEquals("Bruce Springsteen", musician.getName());
        assertEquals("Lizzo", musician2.getName());
    }

    @Test
    public void testGetGenres() {
        String[] expected1 = {"Rock", "Rock-Soul"};
        assertEquals(Arrays.toString(expected1), Arrays.toString(musician.getGenres()));

        String[] expected2 = {"R&B", "Pop", "Rap"};
        assertEquals(Arrays.toString(expected2), Arrays.toString(musician2.getGenres()));
    }

    @Test
    public void testGetGenresAsSingleString() {
        assertEquals("[Rock, Rock-Soul]", musician.getGenresAsSingleString());
        assertEquals("[R&B, Pop, Rap]", musician2.getGenresAsSingleString());
    }

    @Test
    public void testGetAwards() {
        String[] awards = {"Grammy", "American Music Award"};
        assertEquals(Arrays.toString(awards), Arrays.toString(musician.getAwards()));

        String[] awards3 = {"Grammy", "Billboard"};
        assertEquals(Arrays.toString(awards3), Arrays.toString(musician2.getAwards()));
    }

    @Test
    public void testReceiveAward() {
        String[] expected1 = {"Grammy", "American Music Award", "Musician Awards"};
        musician.receiveAward("Musician Awards");
        assertTrue(Arrays.equals(musician.getAwards(), expected1));

        String[] expected2 = {"Grammy", "Billboard", "Musician Awards"};
        musician2.receiveAward("Musician Awards");
        assertTrue(Arrays.equals(musician2.getAwards(), expected2));
    }

    @Test
    public void testToString() {
        String test = "My name is Bruce Springsteen\n" +
                "My age is 73\n" +
                "I am an MUSICIAN\n" +
                "I make these types of music: [Rock, Rock-Soul]\n" +
                "My current album is: Only the Strong Survive\n" +
                "My recording company is: Columbia Records\n";
        assertTrue(musician.toString().equalsIgnoreCase(test));

        test = "My name is Lizzo\n" +
                "My age is 34\n" +
                "I am an MUSICIAN\n" +
                "I make these types of music: [R&B, Pop, Rap]\n" +
                "My current album is: Special\n" +
                "My recording company is: Atlantic Records\n";
        assertTrue(musician2.toString().equalsIgnoreCase(test));
    }
}