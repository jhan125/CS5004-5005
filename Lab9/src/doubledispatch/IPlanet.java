/**Name: Jiali Han
 * Lab 9: Problem 2
 */
package doubledispatch;

/**
 * This is the interface for planets.
 */
public interface IPlanet {
    /**
     * The key behavior for planets to achieve when they accept() an explorer is to have the current explorer visit() the planet.
     * @param explorer to this planet
     */
    void accept(ISpaceExplorer explorer);
}
