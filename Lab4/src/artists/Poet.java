/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

import java.util.Arrays;

/**
 * This class represents a Poet.
 * It inherits the AbstractArtist class.
 * It defines the Poet() constructor,
 * getPublishingCompany() and toString() method.
 */
public class Poet extends AbstractArtist{
    private String publisher;

    /**
     * This constructor creates a Poet.
     *
     * @param name The name of the poet.
     * @param age The age of the poet.
     * @param genres The genres of the poet.
1
     * @param publisher The publishing company of the poet.
     * @throws IllegalArgumentException  when age is out of valid boundary
     */
    public Poet(String name, int age, String[] genres, String[] awards, String publisher)
            throws IllegalArgumentException{
        super(name, age, genres, awards);
        this.publisher = publisher;
    }

    /**
     * Returns the publishing company of the poet.
     *
     * @return publisher The publishing company of the poet.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Override of the toString() method that answers the specific information of a poet.
     * @return basic information of the poet (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an POET\n"
                + "I make these types of poems: " + this.getGenresAsSingleString() + "\n"
                + "My publishing company is: " + this.publisher + "\n";
    }
}
