/**
 * Name: Jiali Han
 * Lab4: Interfaces & Inheritance (Artists)
 */

package artists;

/**
 * This Interface contains functionality that is
 * common to all artists in this package.
 */

public interface IArtist {

    /**
     * Adds the given award to the artist's list of awards.
     *
     * @param award the award to be added in String type
     */
    public void receiveAward(String award);

    /**
     * Returns the awards earned by the artist.
     *
     * @return a string array of awards earned by the artist
     */
    public String [] getAwards();
}
