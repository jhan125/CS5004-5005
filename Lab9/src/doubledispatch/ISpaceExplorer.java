/**Name: Jiali Han
 * Lab 9: Problem 2
 */

package doubledispatch;
/**
 * This is the interface for space explorers.
 */

public interface ISpaceExplorer {
    /**
     * Calls when space explorer visit Mercury.
     * @param mercury instance of Mercury planet.
     */
    void visit(Mercury mercury);

    /**
     * Calls when space explorer visit Mars.
     * @param mars instance of Mars planet.
     */
    void visit(Mars mars);

    /**
     * Calls when space explorer visit Venus.
     * @param venus instance of Venus planet.
     */
    void visit(Venus venus);

    /**
     * Calls when space explorer visit an unknown planet.
     * @param aPlanet instance of an unknown planet.
     */
    default void visit(IPlanet aPlanet) {
        SimulationBuilder.addToLog("Visiting an unknown planet");
    }
}
