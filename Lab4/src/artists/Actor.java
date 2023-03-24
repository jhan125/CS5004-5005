/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

import java.util.Arrays;

/**
 * This class represents an Actor.
 * It inherits the AbstractArtist class.
 * It defines the Actor() constructor and toString() method.
 */
public class Actor extends AbstractArtist {
    private String[] movies;

    /**
     * This constructor creates an Actor.
     *
     * @param name The name of the actor.
     * @param age The age of the actor.
     * @param genres The genres of the actor.
     * @param awards The awards of the actor.
     * @param movies The movies of the actor.
     * @throws IllegalArgumentException  when age is out of valid boundary
     */
    public Actor(String name, int age, String[] genres, String[] awards, String[] movies)
            throws IllegalArgumentException{
        super(name, age, genres, awards);
        this.movies = movies;
    }

    /**
     * Override of the toString() method that answers the specific information of an actor.
     * @return basic information of the actor (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an ACTOR\n"
                + "I make these types of movies: " + this.getGenresAsSingleString() + "\n"
                + "I have acted in these movies: " + Arrays.toString(this.movies) + "\n";
    }
}
