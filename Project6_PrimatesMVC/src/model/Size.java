/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package model;

/**
 * This is the enum type for monkey's size.
 */
public enum Size {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.size;
    }
}
