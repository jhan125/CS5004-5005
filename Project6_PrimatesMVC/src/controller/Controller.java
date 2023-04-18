/**
 * Name: Jiali Han
 * Project 6: Primates MVC
 */

package controller;

/**
 * This interface defines the methods that the view
 * will use to interact with the model.
 */
public interface Controller {

    /**
     * Creates a monkey based on given attributes entered by user.
     */
    void createMonkey();

    /**
     * Adds a monkey to ISOLATION.
     */
    void addToIsolation();

    /**
     * Adds a monkey to ENCLOSURE.
     */
    void addToEnclosure();

    /**
     * Treats a monkey to make it healthy.
     */
    void treatMonkey();

    /**
     * Produces a list of every enclosure.
     * Each enclosure list shows each individual monkey that is currently housed there
     * (for each monkey, include their name, sex, and favourite food)
     */
    void getEnclosureList();

    /**
     * Produce an alphabetical list (by name) of all monkeys housed in the Sanctuary
     */
    void getSanctuaryList();

    /**
     * Produce an alphabetical list (by name) of all monkeys housed in the Isolation
     */
    void getIsolationList();
}
