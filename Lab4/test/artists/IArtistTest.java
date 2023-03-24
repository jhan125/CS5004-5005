/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

import artists.IArtist;
import artists.Actor;
import artists.Musician;
import artists.Poet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;


/**
 * This is a class that test interface IArtist.
 */
public class IArtistTest {
    String[] genre1 = {"Action", "SciFi", "Drama"};
    String[] genre2 = {"Rock", "Rock-Soul"};
    String[] genre3 = {"Comedy", "Romantic Comedy"};
    String[] genre4 = {"R&B", "Pop", "Rap"};
    String[] genre5 = {"Autobiographical Fiction"};

    String[] awards = {"Academy Award", "Golden Globe"};
    String[] awards2 = {"Pulitzer"};
    String[] awards3 = {"Emmy", "People's Choice"};
    String[] awards4 = {"Grammy", "American Music Award"};
    String[] awards5 = {"Grammy", "Billboard"};

    String[] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String[] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    IArtist denzel;
    IArtist melissa;
    IArtist musician;
    IArtist musician2;
    IArtist poet;

    @BeforeEach
    public void setUp() {
        denzel = new Actor("Denzel Washington", 67, genre1, awards, movies);
        melissa = new Actor("Melissa McCarthy", 52, genre3, awards3, movies3);

        musician = new Musician("Bruce Springsteen", 73, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");

        musician2 = new Musician("Lizzo", 34, genre4, awards5,
                "Special", "Atlantic Records");
        poet = new Poet("Maya Angelou", 86, genre5, awards2, "Random House");
    }

    @Test
    public void testCreatedInstances() {
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

        test = "My name is Bruce Springsteen\n" +
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

        test = "My name is Maya Angelou\n" +
                "My age is 86\n" +
                "I am an POET\n" +
                "I make these types of poems: [Autobiographical Fiction]\n" +
                "My publishing company is: Random House\n";
        assertTrue(poet.toString().equalsIgnoreCase(test));
    }

    @Test
    public void testReceiveAward() {
        String[] testAwards = {"Pulitzer", "Tony"};
        poet.receiveAward("Tony");
        assertTrue(Arrays.equals(poet.getAwards(), testAwards));
    }

    @Test
    public void testGetAwards() {
        String[] testAwards = {"Academy Award", "Golden Globe"};
        assertTrue(Arrays.equals(denzel.getAwards(), testAwards));
    }

    @Test
    public void testBadAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                        -> new Musician("Bruce Springsteen", 129, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"),
                "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testBadAge2() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                        -> new Musician("Bruce Springsteen", -1, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"),
                "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testBadName() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                        -> new Musician(null, 10, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"),
                "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testBadName2() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                        -> new Musician("", 10, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"),
                "Expected to throw IllegalArgumentException, but it didn't.");
    }
}