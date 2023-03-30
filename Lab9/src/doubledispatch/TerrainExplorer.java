/**Name: Jiali Han
 * Lab 9: Problem 2
 */

package doubledispatch;


/**
 * This is a concrete class that implements ISpaceExplorer Interface for TerrainExplorer.
 */
public class TerrainExplorer implements ISpaceExplorer{
    @Override
    public void visit(Mercury mercury) {
        SimulationBuilder.addToLog("Landing on Mercury...exploring for terrain");
    }

    @Override
    public void visit(Mars mars) {
        SimulationBuilder.addToLog("Landing on Mars...exploring for terrain");
    }

    @Override
    public void visit(Venus venus) {
        SimulationBuilder.addToLog("Landing on Venus...exploring terrain");
    }
}
