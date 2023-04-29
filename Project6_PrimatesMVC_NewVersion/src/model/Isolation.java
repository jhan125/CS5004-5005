/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class implements Housing Interface and
 * represents the Isolation type of housing.
 * Isolation is used to keep monkeys when they first arrive at the sanctuary.
 * At this time, each individual monkey is given a name, a species designation,
 * a sex, a size, a weight, an approximate age, and a favorite food.
 * Isolation consists of a series of cages each of which can house a single animal.
 * There are at most 20 monkeys in isolation (cages).
 */
public class Isolation implements Housing {
    private List<Monkey> monkeys; // record all monkeys in Isolation
    private final int capacity; // record total capacity of Isolation


    /**
     * This constructor creates an isolation with 20 cages.
     */
    public Isolation() {
        capacity = 20;
        monkeys = new ArrayList<>();
    }

    /**
     * Checks if the capacity of certain type of housing is full.
     * @return true if the capacity is full, false otherwise
     */
    public boolean isFull() {
        if (monkeys.size() < capacity) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addMonkey(Monkey monkey) throws IllegalArgumentException{
        if (exist(monkey.getName())) {
            throw new IllegalArgumentException("This monkey already exists in Isolation, so it can't be added again.");
        }
        if (isFull()) {
            throw new IllegalArgumentException("Due to full capacity, no monkey can be added.");
        }

        monkeys.add(monkey);
    }

    @Override
    public void removeMonkey(Monkey monkey) throws  IllegalArgumentException{
        if (monkeys.size() == 0) {
            throw new IllegalArgumentException("There's no monkey in Isolation, so no monkey can be removed.");
        }
        monkeys.remove(monkey);
    }

    @Override
    public List<Monkey> getMonkeyList() {
        return monkeys;
    }

    @Override
    public boolean exist(String name) {
        List<Monkey> list = getMonkeyList();
        for (Monkey m: list) {
            if (name.equalsIgnoreCase(m.getName())) {
                return true;
            }
        }
        return false;
    }

}
