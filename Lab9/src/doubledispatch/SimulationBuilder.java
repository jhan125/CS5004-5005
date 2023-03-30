/**Name: Jiali Han
 * Lab 9: Problem 2
 */
package doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a concrete class that implements IPlanet interface for Venus
 */
public class SimulationBuilder {

    // this attribute is used to store the "captain's log" of all planetary exploration
    private static final List<String> log = new ArrayList<>();

    /**
     * A factory method that returns an instance of the concrete planet requested by (case-insensitive) name.
     * For example, createPlanet("mars") returns a new instance of the Mars planet.
     * If the planet requested is unknown to your factory method, return null.
     *
     * @param name of the planet
     * @return the corresponding IPlanet object
     */
    public static IPlanet createPlanet(String name) {
        if (name.toLowerCase().equals("mars")) {
            return new Mars();
        }
        if (name.toLowerCase().equals("mercury")) {
            return new Mercury();
        }
        if (name.toLowerCase().equals("venus")) {
            return new Venus();
        }
        return null;
    }

    /**
     * A factory method that creates an instance of one of the concrete space explorers.
     * If the explorer requested is unknown to your factory, return null.
     *
     * @param name of the space explorer
     * @return the corresponding ISpaceExplorer object
     */
    public static ISpaceExplorer createExplorer(String name) {
        if (name.toLowerCase().equals("lifeexplorer")) {
            return new LifeExplorer();
        }
        if (name.toLowerCase().equals("terrainexplorer")) {
            return new TerrainExplorer();
        }
        return null;
    }

    /**
     * Returns a List of String that is the "captain's log" of all planetary exploration.
     * In practical terms, each log entry is a element in the List<String>
     *
     * @return logs in a list of String format
     */
    public static List<String> getSimulationLog() {
        return log;
    }

    /**
     * Add the message to the log list when an explorer visits a planet.
     * @param message to be added to log
     */
    public static void addToLog(String message) {
        log.add(message);
    }
}
