/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 * Reference:
 * Do you need to write throw exception in interfaces?
 * https://levelup.gitconnected.com/a-couple-of-notes-about-exceptions-and-interfaces-in-java-164775a22abc#:~:text=When%20writing%20an%20interface%2C%20you,provided%20for%20in%20the%20interface.
 */

package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This concrete class implements Sanctuary Interface
 * and represents two types of housing: isolation and enclosure.
 */
public class SanctuaryImpl implements Sanctuary{
    private final Enclosure enclosure;
    private final Isolation isolation;

    /**
     * This constructor creates a SanctuaryImpl with new enclosure and isolation.
     */
    public SanctuaryImpl() {
        this.enclosure = new Enclosure();
        this.isolation = new Isolation();
    }

    @Override
    public Monkey createMonkey(String name, Species species, Sex sex, Size size,
        double weight, int age, Food favFood, boolean health) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name input can't be null or empty or blank.");
        }
        if (sex == null || (sex != Sex.FEMALE && sex != Sex.MALE)) {
            throw new IllegalArgumentException("Sex input must be FEMALE or MALE.");
        }
        if (size == null || (size != Size.MEDIUM && size != Size.SMALL && size != Size.LARGE)) {
            throw new IllegalArgumentException("Size input must be either SMALL, MEDIUM, or LARGE.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight can't be 0 or negative.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be negative.");
        }
        if (favFood == null || !Food.containsFood(favFood)) {
            throw new IllegalArgumentException("Food can't be null or invalid.");
        }
        if (species == null || !Species.containsSpecies(species)) {
            throw new IllegalArgumentException("Food can't be null or invalid.");
        }

        return new Monkey(name, species, sex, size, weight, age, favFood, health);
    }

    @Override
    public void addMonkeyToIsolation(Monkey monkey) throws IllegalArgumentException{
        if (exist(monkey)) {
            throw new IllegalArgumentException("This monkey already exists in Isolation, so it can't be added.");
        }
        if (isolation.isFull()) {
            throw new IllegalArgumentException("There's no more space in Isolation, so it can't be added.");
        }
        isolation.addMonkey(monkey);
    }

    @Override
    public void addMonkeyToEnclosure(Monkey monkey) throws IllegalArgumentException {
        if (enclosure.exist(monkey.getName())) {
            throw new IllegalArgumentException("This monkey already exists in Enclosure, so it can't be added.");
        }
        if (!monkey.isHealthy()) {
            throw new IllegalArgumentException("This monkey is unhealthy, so it can't be added to Enclosure.");
        }
        isolation.removeMonkey(monkey);
        enclosure.addMonkey(monkey);
    }

    @Override
    public String getSingleEnclosureList(Species species) {
        return enclosure.getSingleEnclosureList(species);
    }

    @Override
    public List<Monkey> getMonkeyList() {
        List<Monkey> monkeys = new ArrayList<>();
        monkeys.addAll(isolation.getMonkeyList());
        monkeys.addAll(enclosure.getMonkeyList());
        Collections.sort(monkeys);
        return monkeys;
    }

    @Override
    public String getAlphabetMonkeyList() {
        List<Monkey> monkeys = getMonkeyList();
        Collections.sort(monkeys);
        // when there's no monkey in sanctuary, throw exception
        if (monkeys == null || monkeys.size() == 0) {
            throw new IllegalArgumentException("There's no monkey in the sanctuary!");
        }
        StringBuilder sb = new StringBuilder();
        for (Monkey m: monkeys) {
            sb.append(m.getName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public Monkey getMonkey(String name) {
        List<Monkey> monkeys = getMonkeyList();
        for (Monkey m: monkeys) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        throw new IllegalArgumentException("There is no such monkey in the Sanctuary!");
    }

    @Override
    public void treatMonkey(Monkey monkey) throws IllegalArgumentException{
        if (monkey.isHealthy()) {
            throw new IllegalArgumentException("This monkey is already health!");
        }
        monkey.makeHealthy();
    }

    @Override
    public String getIsolationMonkeyList() throws IllegalArgumentException{
        List<Monkey> monkeys = isolation.getMonkeyList();
        // when there's no monkey in isolation, throw exception
        if (monkeys.size() == 0) {
            throw new IllegalArgumentException("There's no monkey in the sanctuary!");
        }
        Collections.sort(monkeys);
        StringBuilder sb = new StringBuilder();
        for (Monkey m: monkeys) {
            sb.append(m.getName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean exist(Monkey monkey) {
        if (!isolation.exist(monkey.getName()) && !enclosure.exist(monkey.getName())) {
            return false;
        }
        return true;
    }
}
