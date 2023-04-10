/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 * Reference:
 * How to sort a list of your own defined type alphabetically?
 * https://www.geeksforgeeks.org/sorting-custom-object-by-implementing-comparable-interface-in-java/
 */

package sanctuary;


/**
 * This concrete class represents Monkey and implements Comparable interface.
 * Each monkey has a name, a species designation, a sex,
 * a size, a weight, an approximate age, and a favorite food.
 */
public class Monkey implements Comparable<Monkey> {
    private final String name; // can't be changed, so make it final
    private final Species species; // can't be changed, so make it final
    private final Sex sex; // can't be changed, so make it final
    private Size size; // could change
    private double weight; // could change
    private int age; // could change
    private Food favFood; // could change
    private boolean health; // could change

    /**
     * This constructor creates a monkey object by
     * taking in monkey's attributes.
     *
     * @param name as String format
     * @param species as in Species type
     * @param sex as in Sex type
     * @param size as in Size type
     * @param weight as in double
     * @param age as in int
     * @param favFood as in Food type
     * @param health as in boolean type
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Monkey(String name, Species species, Sex sex, Size size, double weight,
                  int age, Food favFood, boolean health) throws IllegalArgumentException{
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

        this.name = name;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.favFood = favFood;
        this.size = size;
        this.weight = weight;
        this.health = health;
    }

    /**
     * Returns monkey's name.
     *
     * @return Name of the monkey
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns monkey's species.
     *
     * @return species of the monkey
     */
    public Species getSpecies() {
        return this.species;
    }

    /**
     * Returns monkey's age.
     *
     * @return age of the monkey
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Returns monkey's weight.
     *
     * @return weight of the monkey
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * Returns monkey's size.
     *
     * @return size of the monkey
     */
    public Size getSize(){
        return this.size;
    }

    /**
     * Returns monkey's health status.
     *
     * @return health status of the monkey
     */
    public boolean isHealthy(){
        return this.health;
    }

    /**
     * Returns information about a monkey in string format
     * that includes this monkey's name, sex, and favorite food.
     *
     * @return all required info about a monkey in string format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append(", ");
        sb.append("sex: ").append(sex).append(", ");
        sb.append("favorite food: ").append(favFood);
        return sb.toString();
    }

    /**
     * Set health status of a certain monkey
     * after he/she receives medical treatment.
     */
    public void makeHealthy() {
        this.health = true;
        System.out.println(getName() + " is healthy now!");
    }

    /**
     * Define this method so we can compare names of monkeys.
     *
     * @param other the other monkey we want to compare with
     */
    public int compareTo(Monkey other) {
        return this.name.compareTo(other.getName());
    }
}
