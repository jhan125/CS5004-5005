/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 * Reference:
 * Do you need to write throw exception in interfaces?
 * https://levelup.gitconnected.com/a-couple-of-notes-about-exceptions-and-interfaces-in-java-164775a22abc#:~:text=When%20writing%20an%20interface%2C%20you,provided%20for%20in%20the%20interface.
 */

package sanctuary;

import java.util.List;

/**
 * This Sanctuary interface includes public methods
 * to build SanctuaryImpl class.
 */
public interface Sanctuary {

    /**
     * This constructor creates a monkey object by taking in monkey's attributes.
     *
     * @param name as String format
     * @param species as in Species type
     * @param sex as in Sex type
     * @param size as in Size type
     * @param weight as in double
     * @param age as in int
     * @param favFood as in Food type
     * @param health as in boolean type
     * @throws IllegalArgumentException if any parameter is invalid
     * @return a monkey with given attributes
     */
    Monkey createMonkey(String name, Species species, Sex sex, Size size,
                        double weight, int age, Food favFood, boolean health);

    /**
     * Adds monkey to Isolation.
     *
     * @param monkey the monkey to be added
     * @throws IllegalArgumentException if this monkey exists in Isolation already
     */
    void addMonkeyToIsolation(Monkey monkey);

    /**
     * Adds monkey to Enclosure after removing it from Isolation.
     *
     * @param monkey the monkey to be added
     * @throws IllegalArgumentException if this monkey exists in Enclosure already
     */
    void addMonkeyToEnclosure(Monkey monkey);

    /**
     * Produces a list for every enclosure that shows each individual monkey that is currently housed there.
     * For each individual monkey, the list should include their name, sex, and favorite food.
     *
     * @param species certain species in the enclosure
     * @return a list for every enclosure that shows each individual monkey
     */
    String getSingleEnclosureList(Species species);

    /**
     * Produce an alphabetical list (by name) of all monkeys housed in the Sanctuary.
     *
     * @return an alphabetical list (by name) of all monkeys housed in the Sanctuary.
     * @throws IllegalArgumentException if no monkey in the sanctuary
     */
    String getAlphabetMonkeyList();

    /**
     * Get all monkeys living in this sanctuary by sorting names alphabetically.
     *
     * @return an alphabetical list of all monkeys in the sanctuary
     */
    List<Monkey> getMonkeyList();

    /**
     * Get certain monkey object by searching its name.
     *
     * @param name of this monkey
     * @return monkey with this name
     * @throws IllegalArgumentException if no such monkey exists in the sanctuary
     */
    Monkey getMonkey(String name);

    /**
     * Change monkey's health status by giving medical treatment.
     *
     * @param monkey that is going to receive medical treatment
     * @throws IllegalArgumentException if this monkey is healthy already
     */
    void treatMonkey(Monkey monkey);

    /**
     * Get all monkeys living in the isolation by sorting names alphabetically.
     *
     * @return a string that shows an alphabetical list of all monkeys in the isolation
     */
    String getIsolationMonkeyList();

    /**
     * Checks whether a monkey exists in the sanctuary already.
     *
     * @return true if there's an existing monkey with same name, false otherwise
     */
    boolean exist(Monkey monkey);
}
