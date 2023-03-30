/**Name: Jiali Han
 * Lab 9: Problem 2
 */

package doubledispatch;

/**
 * This is a concrete class that implements IPlanet interface for Mars
 */
public class Mars implements IPlanet{
    /**
     * The key behavior for planets to achieve when they accept() an explorer is to have the current explorer visit() the planet.
     * @param explorer to this planet
     */
    @Override
    public void accept(ISpaceExplorer explorer) {
        explorer.visit(this);
    }
}
