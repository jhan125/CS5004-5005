import frequency.Analytics;
import doubledispatch.ISpaceExplorer;
import doubledispatch.IPlanet;
import doubledispatch.Mercury;
import doubledispatch.Mars;
import doubledispatch.Venus;
import doubledispatch.LifeExplorer;
import doubledispatch.TerrainExplorer;
import doubledispatch.SimulationBuilder;

public class Main {
    public static void main(String[] args) {
        // test problem 1
        String message = "Really? Like, really? I do need another cookie to cook?";
        System.out.println("Problem 1 input:\n" + message);
        System.out.println("Problem 1 result:\n" + Analytics.wordFrequency(message) + "\n");

        // test problem 2
        doubledispatch.LifeExplorer explorer = (LifeExplorer) SimulationBuilder.createExplorer("LifeExplorer");
        doubledispatch.Mars mars = (Mars) SimulationBuilder.createPlanet("Mars");
        explorer.visit(mars);
        System.out.println("Problem 2 result:\n" + SimulationBuilder.getSimulationLog());
    }
}