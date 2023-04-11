/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */
package sanctuary;

/**
 * This is the enum type for monkey's sex.
 */
public enum Sex {
    MALE("male"),
    FEMALE("female");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return this.sex;
    }
}
