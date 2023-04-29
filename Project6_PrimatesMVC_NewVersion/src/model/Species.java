/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */
package model;

/**
 * This is the enum type for monkey's species.
 */
public enum Species {
    DRILL("drill"),
    GUEREZA("guereza"),
    HOWLER("howler"),
    MANGABEY("mangabey"),
    SAKI("saki"),
    SPIDER("spider"),
    SQUIRREL("squirrel"),
    TAMARIN("tamarin");

    private final String species;

    Species(String species) {
        this.species = species;
    }

    public static boolean containsSpecies(Species species) {
        String s = species.toString();
        for (Species sp: values()) {
            if (s.equalsIgnoreCase(sp.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.species;
    }
}
