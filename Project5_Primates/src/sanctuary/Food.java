/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 * Reference:
 * Does enum type has to be in upper case letters?
 * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html#:~:text=Because%20they%20are%20constants%2C%20the,fields%20are%20in%20uppercase%20letters.&text=You%20should%20use%20enum%20types,a%20fixed%20set%20of%20constants.
 * How to check if an Enum value exists in Java?
 * https://www.baeldung.com/java-search-enum-values
 */

package sanctuary;

/**
 * This is the enum type for monkey's favorite food.
 */
public enum Food {
    EGGS("eggs"),
    FRUITS("fruits"),
    INSECTS("insects"),
    LEAVES("leaves"),
    NUTS("nuts"),
    SEEDS("seeds"),
    TREE_SAP("tree sap");

    private final String food;

    Food(String food) {
        this.food = food;
    }

    public static boolean containsFood(Food favFood) {
        String fav = favFood.toString();
        for (Food food: values()) {
            if (fav.equalsIgnoreCase(food.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.food;
    }
}
