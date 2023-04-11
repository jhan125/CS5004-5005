/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package sanctuary;

import java.util.List;

/**
 * This Housing interface represents two types of housing:
 * 1. Isolation 2. Enclosure
 *
 * It also includes public methods like:
 * addMonkey(), removeMonkey, and getMonkeyList().
 */
public interface Housing {
    /**
     * Add a monkey to a certain type of housing.
     * @param monkey the monkey to be added
     */
    void addMonkey(Monkey monkey);

    /**
     * Remove a monkey from a certain type of housing.
     * @param monkey the monkey to be removed
     */
    void removeMonkey(Monkey monkey);

    /**
     * Get a monkey list of a certain type of housing.
     */
    List<Monkey> getMonkeyList();

    /**
     * Checks if this monkey exists in Isolation.
     * @return true if the monkey exists, false otherwise
     */
    boolean exist(String name);
}
