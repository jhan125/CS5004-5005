/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This concrete class implements Housing Interface and
 * represents the Enclosure type of housing.
 * Each enclosure is configured to house a particular species of monkeys.
 * There are 8 enclosure spaces (one for each species of monkeys).
 */
public class Enclosure implements Housing {
    // key: species; value: monkeys of that species
    private Map<Species, List<Monkey>> monkeys;

    /**
     * This constructor creates an enclosure.
     */
    public Enclosure() {
        monkeys = new HashMap<>();
    }

    @Override
    public void addMonkey(Monkey monkey) throws IllegalArgumentException{
        if (!monkey.isHealthy()) {
            throw new IllegalArgumentException("This monkey is not healthy, so it can't be added to Enclosure!");
        }

        if (exist(monkey.getName())) {
            throw new IllegalArgumentException("This monkey already exists in Enclosure, so it can't be added again.");
        }
        Species species = monkey.getSpecies();
        // if this species exists in enclosure already
        if (monkeys.containsKey(species)) {
            // add monkey to this species' values
            monkeys.get(species).add(monkey);
        } else {
            // create a new species key then add that monkey to this key
            List<Monkey> list = new ArrayList<>();
            list.add(monkey);
            // add this new key-value pair to monkeys map
            monkeys.put(species, list);
        }
    }

    @Override
    public void removeMonkey(Monkey monkey) throws IllegalArgumentException{
        if (getMonkeyList().size() == 0) {
            throw new IllegalArgumentException("There's no monkey in the Enclosure!");
        }
        if (!exist(monkey.getName())) {
            throw new IllegalArgumentException("This monkey is not in Enclosure!");
        }
        Species species = monkey.getSpecies();
        // get monkey list of that species
        List<Monkey> list = monkeys.get(species);
        // remove this monkey from this monkey list
        list.remove(monkey);
    }

    @Override
    public List<Monkey> getMonkeyList() {
        List<Monkey> monkeysInEnclosure = new ArrayList<>();
        // iterate this map's values to get all monkeys
        for (List<Monkey> value: monkeys.values()) {
            monkeysInEnclosure.addAll(value);
        }
        return monkeysInEnclosure;
    }

    @Override
    public boolean exist(String name) {
        for (List<Monkey> list: monkeys.values()) {
            for (Monkey m: list) {
                if (name.equalsIgnoreCase(m.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Produce a list of monkeys of that certain species.
     *
     * @param species of that enclosure
     * @return a list of monkeys of given species
     * @throws IllegalArgumentException if there's no such species in this Enclosure
     */
    public String getSingleEnclosureList(Species species) {
        if (!monkeys.containsKey(species)) {
            throw new IllegalArgumentException("There's no such species in the Enclosure.");
        }
        List<Monkey> list = monkeys.get(species);
        StringBuilder sb = new StringBuilder();
        for (Monkey m: list) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }
}
