/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

import java.util.Arrays;

/**
 * This class represents a Musician.
 * It inherits the AbstractArtist class.
 * It defines the Musician() constructor,
 * getCurrentAlbum(), getRecordingComp(), and toString() method.
 */
public class Musician extends AbstractArtist {

    private String recordingComp;
    private String currentAlbum;

    /**
     * This constructor creates a Musician
     *
     * @param name The name of the musician.
     * @param age The age of the musician
     * @param genres The genres of the musician
     * @param awards The movies of the musician
     * @param currentAlbum The current album of the musician
     * @param recordingComp The recording company of the musician
     * @throws IllegalArgumentException  when age is out of valid boundary
     */
    public Musician(String name, int age, String[] genres, String[] awards, String currentAlbum, String recordingComp)
            throws IllegalArgumentException{
        super(name, age, genres, awards);
        this.currentAlbum = currentAlbum;
        this.recordingComp = recordingComp;

    }

    /**
     * Override of the toString() method that answers the specific information of a musician.
     * @return basic information of the musician (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an MUSICIAN\n"
                + "I make these types of music: " + this.getGenresAsSingleString() + "\n"
                + "My current album is: " + this.currentAlbum + "\n"
                + "My recording company is: " + this.recordingComp + "\n";
    }
}
